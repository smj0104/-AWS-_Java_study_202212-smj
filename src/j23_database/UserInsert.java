package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import j20_JSON.builder.User;

public class UserInsert {
	
	private DBConnectionMgr pool;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public int saveUser(User user) {//여러개를 한번에 받으려면 list사용
		int successCount = 0;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = pool.getConnection();
			
			sql = "insert into user_mst\r\n"
					+ "values (0, ?, ?, ?, ?)";
				
				
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  //pool에서 connection 객체 생성
			preparedStatement.setString(1, user.getUsername()); //첫번째 물음표에 username을 넣겠다
			preparedStatement.setString(2, user.getPassword()); //user에 들어있는 값을 db로 옮겨줌
			preparedStatement.setString(3, user.getName()); 
			preparedStatement.setString(4, user.getEmail()); 
			//쿼리를 작성해서 넣겠다는 뜻
			
			successCount = preparedStatement.executeUpdate(); //insert, update, delete 명령 실행
			//몇개가 적용이 된건지 int값으로 리턴해줌
			resultSet = preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				System.out.println("이번에 만들어진 user_id Key값: " + resultSet.getInt(1));
				user.setUserId(resultSet.getInt(1));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
	}
	
	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;
		
		
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = pool.getConnection();
			List<Integer> roles = (List<Integer>) map.get("roles");
			User user = (User) map.get("user");
			
			sql = "insert into role_dtl values";  //map안에 든 list의 크기만큼 반복
			
			for(int i = 0; i < roles.size(); i++) {
				
				sql += "(0, ?, ?)";
				
				if(i < roles.size() - 1 ) {
					sql += ",";
				}
			}
			
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i = 0; i < roles.size(); i++) {
				preparedStatement.setInt((i*2) + 1, roles.get(i));
				preparedStatement.setInt((i*2) + 2, user.getUserId());
			}
			
			successCount = preparedStatement.executeUpdate();
			
//			preparedStatement.setInt(1, roles.get(0));
//			preparedStatement.setInt(2, user.getUserId());
//			preparedStatement.setInt(3, roles.get(1));
//			preparedStatement.setInt(4, user.getUserId());
//			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return successCount;
	}

	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert();
		
		User user = User.builder()
				.username("eee")
				.password("1234")
				.name("eee")
				.email("eee@gmail.com")
				.build();
		
		int successCount = userInsert.saveUser(user);
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		System.out.println(user);
	
		/*================================================*/
		
		List<Integer> roleIdList = new ArrayList<>();
		
		roleIdList.add(2);
		roleIdList.add(3);
		
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdList);
		
		successCount = userInsert.saveRoles(map);
		
		////////////////////////////////////////////////////////////////////
		
		int listSize = 3;
		
		String sql = "insert into test values";
		String values = "(0, ?, ?)";
		
		for(int i = 0; i < listSize; i++) {
			sql += values;   //sql = sql + values
			if(i < listSize - 1) {
				sql += ",";
			}
		}
		
		System.out.println(sql);
		
		
		
		
	}

}
