package j09_클래스;
//클래스는 변수와 메소드를 묶어놓은것 멤버 변수 멤버 메소드라고 부른다
public class j09_Student {  //repository  == db의 저장소
	
	

	String name; // 틀에는 초기화 필요X
	int age;
	//기본생성자
	j09_Student() {
		System.out.println("생성됨");

	}

	void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
		
	
//클래스 명세서 자료형 변수명 접근지정자 제시하면 그걸로 코드짜기
//index out of   nullpointexception
}
