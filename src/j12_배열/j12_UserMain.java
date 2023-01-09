package j12_배열;

public class j12_UserMain {
	
	public static void main(String[] args) {
		j12_User[] users = new j12_User[0];
		j12_User[] users2 = new j12_User[100];
		
		j12_UserRepository userRepository = new j12_UserRepository(users);
		j12_UserRepository userRepository2 = new j12_UserRepository(users2);
		
		j12_UserService service = new j12_UserService(userRepository);
		
		service.run();
		service.stop();
		
		System.out.println("코드 수정하였습니다.");
		System.out.println("코드 수정하였습니다.");
	}
	
		//프로젝트의 생성    1프로젝트 생성  2 github repository 생성 3 repository에 프로젝트 옮김 4 최초 커밋(init) 5.push
	
		//readme 문법 :HTML참조 작성법 검색후 참조 자주 연습할것
		
}
