package j12_배열;
//코드를 읽었을때 비슷한 성격끼리 묶어두면 좋다.
import java.util.Scanner;

public class j12_UserService2 {

	private Scanner scanner;// 대입 할 일 없음 항상 생성자를 통해서만 대입
	private j12_UserRepository userRepository;  //repository가 service에 의존

	public j12_UserService2(j12_UserRepository userRepository) {
		scanner = new Scanner(System.in);// 이 객체를 생성해야지만 스캐너가 할당된다 (메모리 정리용)
		this.userRepository = userRepository;
		// userRepository = new j12_UserRepository(null); (결합도가 높아짐)

	}

	public void run() {
		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);

		}
	}

	public void stop() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500); // 500 = 0.5초
				System.out.println("프로그램 종료중....(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}

	private char inputSelect(String menuName) {
		System.out.println(menuName + "메뉴 선택: ");
		char select = scanner.next().charAt(0);// 제일 첫글자 하나만 잘라서 char에 넣어준다
		scanner.nextLine(); // 버퍼 비우는 용 (윗줄에 enter가 들어가서)
		return select;

	}

	private void showMainMenu() {
		System.out.println("===========<<메인메뉴>>============");
		System.out.println("1. 사용자 전체 조회");
		System.out.println("2. 사용자 등록 ");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("================================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}

	private void showUsers() {
		j12_User[] users = userRepository.getUserTable();

		System.out.println("=================<<회원 전체 조회>>====================");

		for (j12_User user : users) {
			System.out.println(user.toString());
		}

		System.out.println("===================================================");

	}

	private void registerUser() {
		j12_User user = new j12_User();
		

		System.out.println("================<<회원 등록>>====================");
		System.out.println("사용자이름: ");
		user.setUsername(scanner.nextLine());

		System.out.println("비밀번호: ");
		user.setPassword(scanner.nextLine());

		System.out.println("성명: ");
		user.setName(scanner.nextLine());

		System.out.println("이메일: ");
		user.setEmail(scanner.nextLine());
		
		userRepository.saveUser(user);
	}
	
	private void checkUser() { //사용자이름 = 아이디
		j12_User user = null;
		String username = null;
		
		System.out.println("\"=================<<사용자이름으로 회원 조회>>====================\"");
		System.out.println("사용자이름: ");
		username = scanner.nextLine();
		
		user = userRepository.finduserByUserName(username);
		
		if(user == null) {
			System.out.println("존재X 사용자");
			return;
		}
		
		System.out.println(user.toString());
		System.out.println("======================================");
		
	}
	
	private void updateUser() {
		j12_User user = verifyUsername();
		if(user ==  null) {
			System.out.println("존재X 사용자");
			return;
		}
		
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");		
			loopFlag = updateMenu(user, select);}
			}
		
		private void updatePassword(j12_User user) {
			String oldPassword = null;
			String newPassword = null;
			String confirmPassword = null;
			
			System.out.println("=========<<비밀번호 변경>>===========");
			
			System.out.println("기존 비밀번호 입력: ");
			oldPassword = scanner.nextLine();
			
			if(!comparePassword(user.getPassword(),oldPassword)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return;
			}
			
			System.out.println("새로운 비밀번호 입력: ");
			newPassword = scanner.nextLine();
			System.out.println("새로운 비밀번호 확인: ");
			confirmPassword = scanner.nextLine();
			
			if(!comparePassword(newPassword, confirmPassword)) {
				System.out.println("새로운 비밀번호가 서로 일치하지 않습니다.");
				return;
			}
			
			private boolean comparePassword(String prePassword, String nextPassword) {
				return prePassword.equals(nextPassword);
			}
			
		
		
		
		
//		System.out.println("==========회원 조회===========");
//		user = verifyUsername();
//		
//		if(user == null) {
//		System.out.println("존재하지 않는 사용자이름입니다.");
//		return; // 실패사례일때 null을 걸어주는것이 좋다.
//		}
//		System.out.println(user.toString());
//		System.out.println("===========================");
		
	}
	
	//private void abcdasa==user() {
		
	//}

	private boolean mainMenu(char select) {
		boolean flag = true;

		if (isExit(select)) {
			flag = false;
			
		} else {
			if (select == '1') {
				showUsers();
			} else if (select == '2') {
				registerUser();
			} else if (select == '3') {  //사용자이름으로 회원 조회
				checkUser();
			} else if (select == '4') { //1비밀번호 변경 2이름 변경 3이메일 수정 나와야함    b써서 뒤로가기 가능하게 (비밀번호 수정시 기존의 비밀번호와 일치하는지 확인하기) "수정 할 사용자 이름을 입력하세요: " 	
			} else {                    // << 사용자 이름: aaa >>             
				System.out.println(getSelectedErrorMessage());
			}

		}
		System.out.println();

		return flag;
	}

	private boolean isExit(char select) {
		return select == 'q' || select == 'Q'; // 리팩토링 기법 (기존의 소스코드를 정리)
	}
	private boolean isBack(char select) {
		return select == 'b' || select == 'B'; // 리팩토링 기법 (기존의 소스코드를 정리)
	}
	private String getSelectedErrorMessage() {
		return "###<<잘못된 입력입니다. 다시 입력하세요.>>###"; // void를 사용가능하지만 값이 고정되어 고칠수없게된다.
	}

	private j12_User verifyUsername() { //유저이름 검증
		String username = null;
		System.out.println("사용자이름: ");
		username = scanner.nextLine();
		return userRepository.finduserByUserName(username);
	}
	private void showUpdateMenu(j12_User user) {
		System.out.println("수정메뉴");
		System.out.println("사용자이름");
		System.out.println("====");
		System.out.println("비밀번호 변경");
		System.out.println("이름 변경");
		System.out.println("이메일 변경");
		System.out.println("====");
		System.out.println("b.뒤로가기");
		System.out.println();
	}
	private boolean updateMenu(j12_User user, char select) { //?
		boolean flag = true;
		
		if(isBack(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				updatePassword(user);
			}else if(select == '2') {
				
			}else if(select == '3') {
			}else {
				System.out.println(getSelectedErrorMessage());
			}
			}
		System.out.println();
		
		return flag;
		
	}
}
