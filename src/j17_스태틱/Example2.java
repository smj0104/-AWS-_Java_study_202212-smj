package j17_스태틱;

public class Example2 {
	public static void main(String[] args) {
		Example studentLee = new Example();  //학생 인스턴스 생성시 serialNum의 변수값은 계속 증가
		studentLee.setStudentName("이지원");
		System.out.println(studentLee.serialNum);
		System.out.println(studentLee.studentName + "학번: " + studentLee.studentID);
		
		Example studentSon = new Example();
		studentSon.setStudentName("손수경");
		System.out.println(studentSon.serialNum);
		System.out.println(studentSon.studentName + "학번: " + studentSon.serialNum);
	}

}
