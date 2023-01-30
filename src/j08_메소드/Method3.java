package j08_메소드;

	//메소드 오버로딩(오버로드)                  메소드 오버로딩과 오버라이딩의 차이?
public class Method3 {
	
	public static void ov1() {
		System.out.println("매개변수 없음");
	}
	
	public static void ov1(int a) {
		System.out.println("int 매개변수 하나");
	}
	
	public static void ov1(int a, String b) {
		System.out.println("int 먼저 그다음 String");
	
	}
	
	public static void ov1(String a, int b) {
		System.out.println("String 먼저 그다음 int");
	}
	
	public static void main(String[] args) {
		ov1();
		ov1(10);
		ov1(10, "bee");
		ov1("bee", 10);
	}
}
