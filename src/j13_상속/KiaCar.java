package j13_상속;
// 동일한 주소안에 같은 메소드 두개는 불가능  메소드는 이름과 자료형이 중요함  
// 클래스는 자료형 업캐스팅 다운캐스팅이 가능
public class KiaCar extends Car{
	
	public KiaCar() {
		super();//부모클래스, 상위객체를 의미(여기선 Car를 의미) //super는 항상 최상위에 위치
		System.out.println("자식");//상속시 다른 주소에 저장되는것이라 같은 이름으로 여러곳에서 사용가능
		
	}
	
	@Override //재정의한것 (주소값이 달라짐) 메소드형과 자료형이 같아야 override
	public int discountPrice(int percentage) {
		// TODO Auto-generated method stub
		return super.discountPrice(percentage);
	}
	
	
	
//	public void test() {
//		KiaCar kc = this; //자기 자신을 주소로 변수를 쓸때 사용한다
//	}
	
}
