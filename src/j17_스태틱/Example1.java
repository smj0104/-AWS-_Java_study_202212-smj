package j17_스태틱;

public class Example1 {
	public static void main(String[] args) {
		Example studentLee = new Example();
		studentLee.setStudentName("abc");
		
		System.out.println(studentLee.serialNum); // static변수의 초기값 출력
		studentLee.serialNum++;
		
		Example studentSon = new Example();
		studentSon.setStudentName("def");
		

		
		System.out.println(studentSon.serialNum);
		System.out.println(studentLee.serialNum);
	}

}
