package j09_클래스;

public class j09_Student {

	String name; // 틀에는 초기화 필요X
	int age;

	j09_Student() {
		System.out.println("생성됨");

	}

	void prinInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

}
