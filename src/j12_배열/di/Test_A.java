package j12_배열.di;

public class Test_A {

	private final Test_B tb; //setter를 통해 갈아끼우는게 안될경우 final 
	
	
	public Test_A(Test_B tb) { // arguement = 변수
		this.tb = tb;  //무조건 초기화 되야하는 변수 required argument constructor (필수 매개변수를 가지는 생성자) 무조건 final이 잡혔을때
	}
	//tb = new Test_B();//강한 의존성 test a가 생성되야만 b도 생성됨         의존성이 높다 = 결합도가 높다
		
	
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
		//Test_B tb = new Test_B();

		tb.testB1();  //주소가 없는경우에 참조시 nullpointexception 오류
	}

	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!");
		//Test_B tb = new Test_B();

		tb.testB1();

	}
}
