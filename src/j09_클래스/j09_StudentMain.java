package j09_클래스;
//생성자는 클래스명과 일치해야한다.형태는 메소드
//클래스는 초기화 X 메소드는 초기화시키기
public class j09_StudentMain {
	
	
	public static void main(String[] args) {
		j09_Student s1 = new j09_Student();
		j09_Student s2 = new j09_Student();
		j09_Student s3 = new j09_Student();
		
		
		s1.name = "김준일";
		s1.age = 30;
		
		s1.prinInfo();
		
		s2.prinInfo();
		
		s3.prinInfo();
		
		
//      J09_User
//		username(아이디)
//		password(비밀번호)
//		name(이름)
//		email(이메일)
//		
//		메소드
//		printuserInfo()
//		아이디: aaa
//		비밀번호: 1234
//		이름: 김종환
//		이메일: aaa@gmail.com
	}

}
