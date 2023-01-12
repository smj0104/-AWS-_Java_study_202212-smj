package j17_스태틱.싱글톤;

import java.util.Scanner;

public class B {
	
	
	
	



	public void insertStudent() {
		Scanner scanner = new Scanner(System.in);  //스캐너 위치 
		
		System.out.println("학생 이름: ");
		String name = scanner.nextLine();
		
		Student student = new Student(name);
		A.getInstance().addStudent(student);
		A.getInstance().showStudents();  //A라는 변수를 만들 필요없이 들고올수있어서 좋음
	}

}
