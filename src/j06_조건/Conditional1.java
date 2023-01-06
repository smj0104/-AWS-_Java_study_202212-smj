package j06_조건;

public class Conditional1 {
	
	public static void main(String[] args) {
	
		int num = 11;
		int num2 = 10;
		
		if(num > num2) System.out.println("num이 num2보다 큽니다.");
		else System.out.println("num이 num2보다 크지 않습니다.");
	
		//if(num > num2) System.out.println("num이 num2보다 큽니다.");
		//if(num == num2) System.out.println("num이 num2보다 같습니다.");
		//if(num < num2) System.out.println("num이 num2보다 작습니다.");
		
		if(num > num2) {
			System.out.println("num이 num2보다 큽니다.");
			System.out.println("num: " + num);
		}
		else {
			if (num == num2) { System.out.println("num과 num2가 같습니다.");
			}
			else { System.out.println();
			}
		
		//넘과 넘2가 같습니다
		//넘이 넘2보다 작습니다.
		
	}

	
}
	}
