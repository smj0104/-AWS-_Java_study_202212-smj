package j12_배열;
//MVC(모델 뷰 컨트롤러) -> service -> repository -> DB (기본 틀로 잡고 살을 붙여간다)
//프로그래밍은 반복이 중요

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
