package j17_스태틱;
//스태틱은 공유의 영역
public class TestA {

	private static int num;
	
	public static void setNum(int num) {
		TestA.num = num;
	}
	
	public static int getNum() {
		return num;
	}
}
