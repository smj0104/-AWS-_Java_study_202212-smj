package j04_연산자;

/*
 * 논리연산자
 * 0이 아니면 반드시 참
 * 
 * AND(곱) T && T , T && F
 * 
 * OR(합) T || F 
 * 
 * 
 * NOT(부정) !T
 */

public class Operation3 {
	public static void main(String[] args) {
		int num = 11;
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 == 0; //false
		
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2 || flag3 && flag1));
		
	}

}
