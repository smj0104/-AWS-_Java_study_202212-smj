package j15_인터페이스;

public class Main {
	
	public static void main(String[] args) {
		Equipment[] equipments = new Equipment[2]; //equipment를 담을수있는 배열이지 equipment가 담긴것은 아니다.  /밑의 계산기와 스마트폰이 들어가있음
		
		equipments[0] = new GeneralCalculator();
		equipments[1] = new SmartPhone();
		
		Calculator calculator = new Computer(); //업캐스팅
		
		
		System.out.println("모든 장비 전원 켜기");
		for(Equipment eq : equipments) {
			eq.powerOn();
		}
		System.out.println();
		
		System.out.println("모든 장비에서 10과 20을 더하기");
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.plus(10, 20);
			System.out.println("결과: " + result);
		}
		System.out.println();
		
		System.out.println("모든 장비에서 10과 20을 나누기");
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.division(10, 2);  //왠만해선 double로 계산  /돈계산 조회 count등은 int로 잡기
 			System.out.println("결과: " + result);
		}
		System.out.println();
		
		System.out.println("모든 장비 전원 끄기");
		for(Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
				
	}

}
