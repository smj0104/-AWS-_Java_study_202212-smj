package j15_인터페이스;
//인터페이스는 구현하는 용이 아니다 (나중에 익명 클래스 사용시엔 가능)
public interface Calculator {
	
	public int ERROR = -999999;  //abstract final 생략가능
	
	public double plus(double x, double y);  //구현객체 사용 불가능
	public double minus(double x, double y); 
	
	public default double multiplication(double x, double y) {   //일반 메소드를 쓸려면 abstract 대신 default / 일반(멤버)변수를 가질수 없다. 상수는 가질수있음
		return x * y;
		
	}
	public double division(double x, double y);
	
	

}
