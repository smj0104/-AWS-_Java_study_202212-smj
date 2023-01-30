package j20_JSON.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder  //밑의 주석 처리 모두 builder에 해당
@AllArgsConstructor //전체생성자
public class User {
	//private int userId;
	private String username;
	private String password;
	private String name;
	private String email;

//	public static UserBuilder builder() {
//		//return new User().new UserBuilder();
//		return new UserBuilder(); //static이 아닐시 먼저 User를 생성하고 UserBuilder를 생성해야한다.
//	}
//	
//	@Data
//	public static class UserBuilder {  //클래스 안의 클래스 원래는 user가 생성되야만 사용가능 static이 있으므로 생성되지않아도 사용가능
//		private String username;
//		private String password;
//		private String name;
//		private String email;
//		
//
//		public UserBuilder username(String username) {
//			this.username = username;
//			return this;
//		}
//		
//		public UserBuilder password(String password) {
//			this.password = password;
//			return this;
//			
//		}public UserBuilder name(String name) {
//			this.name = name;
//			return this;
//			
//		}public UserBuilder email(String email) {
//			this.email = email;
//			return this;
//		}
//		public User build() { // 멤버 메소드 user클래스가 생성되야만 사용가능하다
//			return new User(username, password, name, email );  //set 안해주면 기본 null값 출력
//		}
//	}
}
