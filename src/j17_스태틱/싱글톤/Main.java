package j17_스태틱.싱글톤;  //회원가입이나 로그인 만들시 로그인중인 객체는 하나만 있어야하기에 싱글톤으로 만들어야한다.

public class Main {
	
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		
		for(int i = 0; i < 4; i++) {
			b.insertStudent();
		}
		
		System.out.println("C에서 학생 전부 출력");
		c.showAll();
		
		
	}

}
