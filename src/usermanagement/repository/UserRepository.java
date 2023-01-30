package usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usermanagement.config.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

/*
 *  UserDao (data access object) 데이터에 접근하는 용도
 */

public class UserRepository {
	
	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	private DBConnectionMgr pool; //usermanegement config
	
	private UserRepository() {
		pool = DBConnectionMgr.getInstance();
	}

	// 건수가 리턴이라 int
	public int saveUser(User user) {
		int successCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;  //autoincrement 키값 받아오는용
		
		try {
			
			con = pool.getConnection();
			String sql = "insert into user_mst values(0, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				user.setUserId(rs.getInt(1)); //열을 하나씩 참조
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
	
	public int saveRoleDtl(RoleDtl roleDtl) {
		int successCount = 0;
		
		String sql = null;
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con = pool.getConnection();
			
			sql = "insert into role_dtl values (0, ?, ?)";
			
			pstmt = con.prepareStatement(sql); //key 값 활용할일이 없으면 generate key 필요없음
			pstmt.setInt(1, roleDtl.getRoleId());
			pstmt.setInt(2, roleDtl.getUserId());
			
			successCount = pstmt.executeUpdate();
//			
//			rs = pstmt.getGeneratedKeys();		
//			
//			if(rs.next()) {
//				
//			roleDtl.setRoleDtlId(rs.getInt(1));
//				
//			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		
		
		return successCount;
		
	}
	
	public User findUserByUsername(String username) {
		User user = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "SELECT\r\n"
					+ "	um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"  //6번부터 각각의 개체 생성 필요
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "from\r\n"
					+ "	   user_mst um\r\n"
					+ "    left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where\r\n"
					+ "	username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery(); 
			
			List<RoleDtl> roleDtls = new ArrayList<>();  //while 안에 있으면 매번 새로 생성함
			int i = 0;
			
			
			while(rs.next()) {
				if(i == 0) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
				}
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.roleMst(roleMst)  //해당되는 mst가 들어감
						.build();
				roleDtls.add(roleDtl);
				
				i++;
			}
			
			if(user != null) {
			user.setRoleDtls(roleDtls);  //완성된 디테일을 유저에 넣어준다
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	public User findUserByEmail(String email) {
		User user = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "SELECT\r\n"
					+ "	um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"  //6번부터 각각의 개체 생성 필요
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "from\r\n"
					+ "	   user_mst um\r\n"
					+ "    left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where\r\n"
					+ "	email = ?";  //where 조건 유의
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery(); 
			
			List<RoleDtl> roleDtls = new ArrayList<>();  //while 안에 있으면 매번 새로 생성함
			int i = 0;
			
			
			while(rs.next()) {
				if(i == 0) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
				}
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.roleMst(roleMst)  //해당되는 mst가 들어감
						.build();
				roleDtls.add(roleDtl);
				
				i++;
			}
			if(user != null) {
			user.setRoleDtls(roleDtls);  //완성된 디테일을 유저에 넣어준다
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
}
}
