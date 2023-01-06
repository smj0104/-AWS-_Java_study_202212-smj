package j06_조건;

public class Swtich1 {
	public static void main(String[] args) {

		String select = "B선택";
		
		switch (select) {
			case "A선택" : 
				System.out.println("PC(A)를 연결합니다.");
			case "B선택" : 
				System.out.println("PC(B)를 연결합니다.");
				break;
			case "C선택" :
				System.out.println("PC(C)를 연결합니다.");
			case "D선택" : 
				System.out.println("PC(D)를 연결합니다.");
				default :
					System.out.println("else와 같은 역할");
		}
	}

}
