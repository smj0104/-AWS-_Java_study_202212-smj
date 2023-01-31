package j24_람다;
@FunctionalInterface  //함수형 인터페이스 인터페이스를 작성함에 있어서 제약을 걸어준다 (람다를 의미)
public interface Instrument {
	
	public String play(String instrument);
	
	public default void testPrint() {
		System.out.println("가능하다");  //디폴트 메소드는 구현된 객체이기에 몇개든 가능하다
	}
	

}
