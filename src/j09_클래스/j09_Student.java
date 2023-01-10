package j09_클래스;
//클래스는 변수와 메소드를 묶어놓은것
public class j09_Student {

	String name; // 틀에는 초기화 필요X
	int age;
	//기본생성자
	j09_Student() {
		System.out.println("생성됨");

	}

	void prinInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

}
