package j17_스태틱.싱글톤;

public class C {
	
	public void showAll() { 
	//	A a = b.getA();  //b에 있는 a를 가져와야함
	
		A.getInstance().showStudents();  // 이것만으로 A객체를 가지고 온 셈
	}
}
