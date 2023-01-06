package j07_반복;

import java.util.Scanner;

public class Loop3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int a = 0;
		int b = 0;
		int sum = 0;
		int result = 0;
		
		count = scanner.nextInt();
		System.out.println("반복횟수: " + count);
		
		
		for(int i = 1; i < count + 1; i++ ) {
			System.out.println(i + "번 반복");
			a = scanner.nextInt();
			System.out.println("a: " + a);
			b = scanner.nextInt();
			System.out.println("b: " + b);
			sum = a + b;
			System.out.println(i + "번 합: " + sum);
			result += sum;
			
			System.out.println("총합: " + result);
		
			
		}
		
		
		
		
		
		
		
			
	}
}
