package j16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		String name1 = "김준일";
		String name2 = "김준일";
		String name3 = new String("김준일");  // name3 name2는 서로 다름

		System.out.println(name1);
		System.out.println(name2);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		System.out.println(name1 == name2); //주소비교
		System.out.println(name2 == name3); //false가 나오지만 .equals를 사용하면 안에 든 실질적인 값을 비교하여 true가 나옴
		
		//////////////////////////////////////////////////////////////////////////////
		
		Student s1 = new Student("박은빈", 24); //new로 인해 주소가 다르다
		Student s2 = new Student("박은빈", 24); //new로 인해 주소가 다르다
		SubStudent s3 = new SubStudent("박은빈", 24);
		
		System.out.println(s1.equals(null));  //s1이 this equals의 반대 if(!string.equals("abc")
	}

}
