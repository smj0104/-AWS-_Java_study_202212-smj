package j17_스태틱.싱글톤;
//싱글톤 사용시 변수명 고정 , 생성자는 내부에서 생성못하게 private사용
public class A {

	private Student[] students;
	
	private static A instance = null;
	
	private A() {
		students = new Student[3];
	}
	
	public static A getInstance() {
		if(instance == null) {
			instance = new A();  // 자기 자신을 생성해서 주는것
		} return instance;
	}
	
	public void addStudent(Student student) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				return;
			}
		}
		
		System.out.println("더 이상 학생을 추가할 수 없습니다.");  //break로 끊을시 같이 출력되어버린다
		System.out.println();
	}
	
	public void showStudents() {
		for(Student student : students) {
			System.out.println(student);  //student.tostring은 X , null이라는 주소에는 .tostring이 없음
		}
		System.out.println();
		
	}
}
