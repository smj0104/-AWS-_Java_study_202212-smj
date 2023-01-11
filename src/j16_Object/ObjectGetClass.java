package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {

	public static void main(String[] args) {
		Student student = new Student("김재영", 29);

		System.out.println(student.getClass());  //instanceof는 상속되었을때 문제를 야기할수있다.
		System.out.println(Student.class);  

		System.out.println(student.getClass().getName()); // 셋 다 서로 다름
		
		Class studentClass = student.getClass();
		
		String  className = studentClass.getName();
		System.out.println("클래스 이름: " + className);
		
		String simpleName = studentClass.getSimpleName(); //클래스 파일명만 찍어준다
		System.out.println("클래스 이름만: " + simpleName);
		
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);  //field.toString
		}
		System.out.println();
		
		Method[] methods = studentClass.getDeclaredMethods(); //메소드 클래스의 배열
		for(Method method : methods) {
			System.out.println(method);
			
		}
				
	}

}
