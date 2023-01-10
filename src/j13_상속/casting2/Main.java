package j13_상속.casting2;

public class Main {

	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Subway subway = new Subway();

		Transportation transportation = new Transportation();
		Taxi t1 = (Taxi) transportation; // 다운캐스팅 (불가능)

		Transportation transportation1 = taxi;
		Subway s1 = (Subway) transportation1; // (불가능)

		Transportation transportation2 = subway; // 본래의 형태로 돌아갈때만 다운캐스팅이 허용된다.

		Transportation[] transportations = new Transportation[6];

		transportations[0] = taxi;
		transportations[1] = subway;
		transportations[2] = taxi;
		transportations[3] = subway;
		transportations[4] = taxi;
		transportations[5] = subway;

		for (int i = 0; i < transportations.length; i++) {
			if (transportations[i] instanceof Taxi) { // transportations[i]에서 꺼낸것이 Taxi인가?
				Taxi tx = (Taxi) transportations[i];
				tx.checkTaxiNumber();
				
			} else if (transportations[i] instanceof Subway) {  //getclass()는 명확하게 판단한다
				Subway sw = (Subway) transportations[i];
				sw.checkRoute();
			}
			
			Taxi tx = (Taxi) transportations[i];
			transportations[i].go();
		}
		
		

		for (Transportation t : transportations) { // for each
			t.stop();
		}

	}

}
