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
	
	/**
	 * 클래스. 객체.  인스턴스
	 * 
	 * 클래스 = 틀 
	 * 그 틀로 찍어내는것 = 객체
	 * 만들어낸것 = 인스턴스
	 * 
	 * 일반적인 학생 = 객체
	 * 학생이름,나이,생년월일등의 변수 = 클래스
	 * 만들어서 메모리에 할당함
	 * 
	 * 클래스는 함수를 담을수있다 /클래스 = 참조 자료형 (메모리에 할당된 데이터를 참조하기에)
	 * 
	 * 동일한 자료형으로 정리해둔것 = 배열
	 * new aaaa(); == 메모리 할당(주소)
	 * 
	 * 동적할당 = 힙메모리 빌리기 (new 사용이 동적할당)
	 * 정적할당 = 스택영역
	 * static의 판단
	 * 
	 * class ㅁㅁㅁㅁ  {
	 * 
	 * 	변수 
	 * 			--> 스테틱과 멤버로 나뉨  (멤버 = 동적할당)
	 * 	메소드
	 * }
	 */
}
