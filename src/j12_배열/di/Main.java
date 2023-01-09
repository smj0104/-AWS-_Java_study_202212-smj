package j12_배열.di;
//dependency injection  DI 의존성 주입  (따로 검색할것) DI 방식으로 개발?
public class Main {
	
	public static void main(String[] args) {
		
		Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		
		Test_B tb = new Test_B(tc2);
		
		Test_A ta = new Test_A(tb);

		//ta.setTb(tb); 
		
		ta.testA1();
		ta.testA2();
	}

}
