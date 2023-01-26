package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
	private DBConnectionMgr pool; //pool은 db에 들어갈수있는 인원을 제한         arrayList 사용시 sychronized 사용필요  vector는 
	
	public RoleInsert() { //싱글톤
		pool = DBConnectionMgr.getInstance();//드라이버매니저
	}
	
	public int saveRole(String roleName) {
		int successCount = 0;
		
		String sql = null;
		Connection con = null;  //커넥션 객체 생성(jdbc 라이브러리)
		PreparedStatement pstmt = null;  //pstmt (DB랑 연결하는 용도)  이 둘은 필수  resultsetd은 쿼리 실행결과를 담음
		ResultSet rs  = null;
		
		
		try {
			con = pool.getConnection(); //DB와 연결해줌
			
			sql = "insert into role_mst values (0, ?)";
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//con 다음 순서 (generate keys 가져오기위해 필수)
			
			pstmt.setString(1, roleName);// set = 값을 지정함 (getter/setter 생각) 인덱스가 1부터 시작함  미완성된 물음표를 먼저 받고 값을 채움 (1번째 물음표에 값을 넣어라)
			
			successCount = pstmt.executeUpdate(); ////insert, update, delete 명령 실행  
			
			int newKey = 0;//키값
			//ResultSet 값 중복불가
			rs = pstmt.getGeneratedKeys(); //자동완성된 키값 가져옴(get)  
			if(rs.next()) { //rs.next()를 통해서 내려갈수있을면 true 아닐시 false를 반환 insert를 하나밖에 안해서 if사용
				newKey = rs.getInt(1);  //보통 리스트에 넣는다 list.add  rs칼럼 첫번째의 key값을 가져온다
			}
			
			System.out.println(newKey != 0 ? "새로운 키값: " + newKey : "키가 생성되지 않음");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);  //오류를 con pstmt rs가 처리
		}
		
	return successCount;	
	}
	public static void main(String[] args) {
		
		RoleInsert roleInsert = new RoleInsert();
		
		int successCount =  roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수: " + successCount );
		
	}
}
