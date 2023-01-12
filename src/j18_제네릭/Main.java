package j18_제네릭;

public class Main {

	public static void main(String[] args) {
		TestData<Integer> td = new TestData<Integer>("김준일", 100);
		TestData<Double> td2 = new TestData<Double>("junil", 100.05);
		System.out.println(td);
		System.out.println(td2);

	}

}
