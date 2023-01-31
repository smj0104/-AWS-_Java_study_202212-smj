package j24_람다;

public abstract class Lambda1 {

	public static void main(String[] args) {
		
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {  //재정의할 때 매개변수명 바꿀 수 있음
				return instrument + "를 연주합니다.";
			}
		};
		
		Instrument instrument2 =(String itm) -> {  //정의와 생성
			return itm + "를 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할 수 있다.
		// 매개변수의 이름을 바꿀 수 있다
		Instrument instrument3 =(itm) -> { //abstract 메소드가 하나밖에 없다  
			return itm + "를 연주합니다.";
		};
		
		//매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다. (없거나 두개이상X)
		Instrument instrument4 =itm -> {
			return itm + "를 연주합니다.";
		};
		
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다
		// 이때 리턴자료형이 정해져있으면 리턴값으로 사용이 된다.
		Instrument instrument5 = itm -> itm + "를 연주합니다."; //중괄호 생략 == return을 무조건 생략 if문이 실행문이 하나일때 중괄호 생략 가능한것과 비슷
		
		int result = 10 + 20;
		
		Instrument instrument6 = itm -> itm + "를 연주합니다." + result;  //main안의 지역변수를 가져와서 동시에 쓸 수 있다 
		
		System.out.println(instrument2.play("피아노")); //객체 안에 든 play의 메소드 호출
		
		String playText = instrument.play("드럼");
		System.out.println(playText);
		
		System.out.println(instrument6.play("기타"));
		
	}
}
