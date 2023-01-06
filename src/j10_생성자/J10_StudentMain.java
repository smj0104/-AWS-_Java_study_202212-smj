package j10_생성자;

//기본생성자는 생략되어있지만 오버로딩이 일어나면 생략이 비활성화
//기본생성자도 써야할시 직접 타이핑 필요

public class J10_StudentMain {
	
	public static void main(String[] args) {
		
		J10_Student s1 = new J10_Student("박성진", 29);
		s1.printInfo();
		
		s1.name = "김준일";
		
	}

}
