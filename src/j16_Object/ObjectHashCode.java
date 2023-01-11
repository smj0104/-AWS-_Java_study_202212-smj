package j16_Object;

public class ObjectHashCode {
	
	public static void main(String[] args) {
		Student s1 = new Student("김수현", 31);
		Student s2 = new Student("김수현", 31);
		SubStudent s3 = new SubStudent("김수현", 31);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode()); 
		
		System.out.println(s1.hashCode() == s2.hashCode()); //데이터에 대한 해시코드 조합을 비교
	
		System.out.println(s1.hashCode() == s3.hashCode());     //equals로 비교하면 f
	}

}
