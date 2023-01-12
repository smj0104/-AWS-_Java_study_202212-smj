package j16_Object;

class Test { // 이 패키지 안에서만 참조가능 이렇게 사용하지말것
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}

	@Override        //?
	protected void finalize() throws Throwable { // 소멸될때 실행되는 
		System.out.println(num + "객체 소멸");
	}

}

public class ObjectFinalize {

	public static void main(String[] args) {
		Test test = null;

		for (int i = 0; i < 30; i++) {
//			try {
//				Thread.sleep(500);  //프로그램이 쉬는동안 jvm이 소멸시킴
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			test = new Test(i);

			test = null;

			System.gc(); // gc = garbage collector
		}

	}

}
