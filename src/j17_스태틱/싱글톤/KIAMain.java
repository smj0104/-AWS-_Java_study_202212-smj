package j17_스태틱.싱글톤;

public class KIAMain {
	
	public static void main(String[] args) {
		KIA kia = KIA.getInstance();
		//KIA kia2 = new KIA;
		
		kia.printCompanyName();  //KIA안의 일반 멤버 변수
	}

}
