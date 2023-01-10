package j10_생성자;

public class J10_Student {
	
	public String name; //참조 변수 레퍼런스 변수 멤버 변수
	int age;// <-- 디폴트 상태
	
	
	J10_Student() {
		System.out.println("기본 생성자 호출"); // <----- no argument constructor
	}

	J10_Student(int age) {
		System.out.println("학생의 나이: " + age);
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}
	
//	J10_Student(String _name, int _age) {
//		name = _name;
//		age = _age; 안좋은 예시
//	}
	
	J10_Student(String name, int age) { // all argument constructor
		this.name = name;
		this.age = age; //this는 자기자신의 주소 붙이면 참조 변수 사용 아닐시에는 지역변수 사용
	}
	
	void printInfo() {
		System.out.println("학생 이름: " + name);
		System.out.println("학생 나이: " + age);
	}
}
