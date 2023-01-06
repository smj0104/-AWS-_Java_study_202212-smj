package j11_접근지정자.default1;

//클래스 안에서만 동작한는것들은 private로 숨기기
public class J11_StudentDefault {

	private String name;
	private int age;

	public J11_StudentDefault() {

	}

	public J11_StudentDefault(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

	// Getter 값을 가져옴
	public String getName() {
		return name;
	}

	// Setter 값을 정해줌
	public void SetName(String name) {
		this.name = name;
	}
	// 게터 세터 자동완성 alt shift s

}
