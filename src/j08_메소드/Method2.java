package j08_메소드;

public class Method2 {
	//공식을 정의하고 입력과 출력이 있는것 = 함수
	//매개변수(입력): x, 반환: x
	//호이스팅: 실행전에 소스코드 분석후 정의
	//메소드 = 클래스 안에 정의된 함수
	
	public static void method1() {
		System.out.println("단순 실행");
		System.out.println();
	}
	
	//매개변수 :int 하나입력, 반환 : x
	public static void method2(int  num) {
		System.out.println("num: " + num);
		System.out.println();
	}
	//매개변수: int 두개 입력, 반환 : x
	public static void method3(int num, int num2) {
		System.out.println("num: " + num);
		System.out.println();
		System.out.println("num2: " + num2);
		System.out.println();
	}
	
	public static String method4() {
		return "데이터 반환";
	}
	
	public static String method5(int age) {
		String ageStr = age + "살";
		return ageStr;
	}
	
	
	
	public static void main(String[] args) {
		method1(); //함수 호출
		method2(100);
		method3(200,300);
		
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
		System.out.println(method5(30));
		System.out.println();
	}
	
	
	
}
