package j12_배열;

public class Array4 {
	public static void main(String[] args) {
		j12_User[] users = new j12_User[3];
		
		j12_User[] users2 = new j12_User[] {
				new j12_User("aaa", "1234", "김종환", "ㅁasd@gmail.com"),
				new j12_User("bbb", "45235", "김da", "asdasfdsa@gmail.com"),
				new j12_User("ccc", "543532", "김dsa", "hgsdfsg@gmail.com")
		};
		
		j12_User[] users3 = new j12_User[] {
				new j12_User("aaa", "1234", "김종환", "ㅁasd@gmail.com"), //쉼표찍기
				new j12_User("bbb", "45235", "김da", "asdasfdsa@gmail.com"),
				new j12_User("ccc", "543532", "김dsa", "hgsdfsg@gmail.com")
		};
		
		
		
		users[0] = new j12_User("aaa", "1234", "김종환", "ㅁasd@gmail.com");
		users[1] = new j12_User("bbb", "45235", "김da", "asdasfdsa@gmail.com");
		users[2] = new j12_User("ccc", "543532", "김dsa", "hgsdfsg@gmail.com");
		
		for(int i =0; i < users.length; i++) {
			
			System.out.println(users[i].toString());
			System.out.println(users2[i].toString());
			System.out.println(users3[i].toString());
			
		}

	}
	

}
