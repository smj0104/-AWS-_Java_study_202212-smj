package j05_입력;

import java.util.Scanner;


public class Input2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		System.out.println("문자열1: ");
		String str1 = scanner.nextLine(); //유일하게 띄어쓰기 가능
		
		System.out.println("문자열2: ");
	    String str2 = scanner.next();
	    
	    System.out.println("정수: ");
	    int number1 = scanner.nextInt();
	    
	    System.out.println("실수: ");
	    double number2 = scanner.nextDouble();
	    
	    System.out.println("문자열1: " + str1);
	    System.out.println("문자열2: " + str2);
	    System.out.println("정수: " + number1);
	    System.out.println("실수: " + number2);
	     
		}

}
