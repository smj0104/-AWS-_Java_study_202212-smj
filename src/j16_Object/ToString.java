package j16_Object;

public class ToString {
	
	public static void main(String[] args) {
//		Object obj = new Object();
//		
//		System.out.println(obj);
//		
//		//String str2 = obj; //object 자료형을 string에 넣는다는 뜻(불가능함)
//		
//		String str = obj.toString(); 
//		
//		System.out.println(str);
		
		Student student1 = new Student("조병철", 34);
		Student student2 = new Student("조병철1", 341);
		Student student3 = new Student("조병철2", 342);
		Student student4 = new Student("조병철3", 343);  //이 객체의 정보를 문자열로 바꿔서 보기위함
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student4);
		
		System.out.println();
		
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		System.out.println(student3.toString());
		System.out.println(student4.toString());
	}

}
