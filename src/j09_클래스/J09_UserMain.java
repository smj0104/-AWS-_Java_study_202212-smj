package j09_클래스;

public class J09_UserMain {
	
	public static void main(String[] args) {
		J09_User user1 = new J09_User();
		J09_User user2 = new J09_User();
		J09_User user3 = new J09_User();
		
		user1.username = "손민재1";
		user1.password = 1234;
		user1.name = "손민재";
		user1.email = "adkjd@gmail.com";
		
		user2.username = "abc";
		user2.password = 4321;
		user2.name = "abc";
		user2.email = "adkdasdfasfsd@gmail.com";
		
		user3.username = "kim";
		user3.password = 125667;
		user3.name = "김씨";
		user3.email = "kim@gmail.com";
		
		user1.printUserInfo();
		System.out.println();
		
		user2.printUserInfo();
		System.out.println();
		
		user3.printUserInfo();
		
	}
	

}
