package j16_Object;
//toString instanceof classclass getclass 이해하기
//모든class는 getclass가 있다
import java.util.Objects;

public class Student { // extends Object가 모든 클래스에 생략되어있다. 명시하는 순간 사라짐
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
		public int hashCode() {
		return Objects.hash(name, age);
		}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) { // null 확인우선으로
			return false;
		}

		if (!(obj.getClass() == Student.class)) {  //객체가 Student인지 확인
			return false;
			
		}

		Student s = (Student) obj;   //object 검사 
		boolean result = name.equals(s.name) && age == s.age;      //instanceof는 사용자제

		return result;
	}

	@Override
	public String toString() {
		return "이름: " + name + "\n나이: " + age;
	}

}
