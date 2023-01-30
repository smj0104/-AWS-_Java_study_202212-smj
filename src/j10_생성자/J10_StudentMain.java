package j10_생성자;

//기본생성자는 생략되어있지만 오버로딩이 일어나면 생략이 비활성화
//기본생성자도 써야할시 직접 타이핑 필요
//생성자의 오버로딩= 메모리 할당할때 값을 넣겠다
public class J10_StudentMain {
	
	public static void main(String[] args) {
		
		J10_Student s1 = new J10_Student("박성진", 29);  //새주소 생성
		s1.printInfo();
		
		s1.name = "김준일";
		
	}

}
