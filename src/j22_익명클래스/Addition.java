package j22_익명클래스;

public class Addition implements Calculator {
	
	@Override
	public int calc(int x, int y) {  //추상메소드를 오버라이드 해줘야 사용가능하다

		return x + y;
	}

}
