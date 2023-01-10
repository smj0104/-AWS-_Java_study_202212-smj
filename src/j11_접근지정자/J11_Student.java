package j11_접근지정자;
// ctrl shift f 줄정리
// private public 기억하기
// alt shift s 게터세터 
public class J11_Student {

	String name;
	int age;
	
	public J11_Student() {
	}

	public J11_Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

}
