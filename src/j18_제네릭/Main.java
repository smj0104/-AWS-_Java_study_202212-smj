package j18_제네릭;

public class Main {

	public static void main(String[] args) {
		TestData<?, ?> td = new TestData<String, Integer>("김준일", 100);
		TestData<?, ?> td2 = new TestData<String, Double>("junil", 100.05);
		System.out.println(td);  
		System.out.println(td2);
		
		CMRespDto<?> cm =
		new CMRespDto<>(200, "성공", td);  //td의 값을 받아와서 자료형이 정해져있음 (string, integer)
		
		System.out.println(cm);
		
		

	}

}
