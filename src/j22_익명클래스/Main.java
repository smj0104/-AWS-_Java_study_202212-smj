package j22_익명클래스;

public class Main {
	
	public static void main(String[] args) {
		Calculator c1 = new Addition();
		System.out.println(c1.calc(10,20));
		
	///////////////////////////////////////////////////
		//한번만 사용할 기능인 경우 익명 클래스를 사용한다  인터페이스와 추상클래스 포함
		Calculator c2 = new Calculator() {  //구현된 클래스의 이름이 없기에 익명 클래스라고 부름
			
			@Override
			public int calc(int x, int y) {
				return x - y;
			}
		};  //구현된 클래스
		
		System.out.println(c2.calc(200, 100));
		
	}

}
