package j12_배열;

public class Array2 {
	//메소드를 사용해서 간단하게 묶을수있다 
	public static void printNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);

		}
		System.out.println();
	}

	public static void main(String[] args) {

		String[] names = new String[3];

		names[0] = "김상현";
		names[1] = "임나영";
		names[2] = "김종환";

		String[] names2 = new String[] { "이상현", "손지호", "이강용" };          //둘 다 크기를 지정하지않음
		String[] names3 = { "123", "456", "789 ", "101" };				   // == 

		printNames(names);
		printNames( new String[] { "이상현", "손지호", "이강용" });
		printNames(names3);
		//printNames({ "123", "456", "789 ", "101" });

	}
}
