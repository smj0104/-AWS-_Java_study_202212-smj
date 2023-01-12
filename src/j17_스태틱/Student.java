package j17_스태틱;
// static특징 약간 기울어진 글꼴 ,0 이미 할당되어있다
public class Student {
	
	private static final int CODE = 20230000;  
	private static int ai = 1;  //auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
		
	}

	public static int getAutoIncrement() {
		System.out.println("현재 AI: " + ai); //생성이 안되도 쓸수있는 static 변수 , static변수 안에서는 static과 지역변수만 가능하다.
		//System.out.println("학생 이름: " + name); //생성이 되야지만 사용가능하기에 쓸수없다 
 		return ai;
	}
	
	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	

}
