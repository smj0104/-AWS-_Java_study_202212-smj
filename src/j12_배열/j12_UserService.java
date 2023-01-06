package j12_배열;

import java.util.Scanner;

public class j12_UserService {

	private Scanner scanner;// 대입 할 일 없음 항상 생성자를 통해서만 대입

	public j12_UserService() {
		scanner = new Scanner(System.in);// 이 객체를 생성해야지만 스캐너가 할당된다 (메모리 정리용)
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
		scanner.nextLine(); // 버퍼 비우는 용
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

	private boolean mainMenu(char select) {
		boolean flag = true;

		if (isExit(select)) {
			flag = false;
		} else {
			if (select == '1') {
			} else if (select == '2') {
			} else if (select == '3') {
			} else if (select == '4') {
			} else {
				System.out.println(getSelectedErrorMessage());
			}

		}
		System.out.println();

		return flag;
	}

	private boolean isExit(char select) {
		return select == 'q' || select == 'Q'; // 리팩토링 기법 (기존의 소스코드를 정리)
	}

	private String getSelectedErrorMessage() {
		return "###<<잘못된 입력입니다. 다시 입력하세요.>>###";  //void를 사용가능하지만 값이 고정되어 고칠수없게된다.
	}

}
