package j17_스태틱;

public class Example {
	public static int serialNum = 1000;  //인스턴스 생성과 상관없이 가장 먼저 생성된다
	public int studentID;
	public String studentName;
	public int grade;
	public String address;
	
	
	public Example() {  //생성자
		serialNum++;   //학생이 생성될 때마다 1씩 증가
		studentID = serialNum; // 증가된 값을 학번 인스턴스 변수에 부여해줌
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}

}
