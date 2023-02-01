package j17_스태틱.싱글톤;

public class School {
	private static School instance;
	private String schoolName;
	
	private School () {
		
	}
	public static School getInstance() {
		if (instance == null) {
			instance = new School();
		}
		return instance;
	}

}
