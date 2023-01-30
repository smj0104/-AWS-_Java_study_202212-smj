package j01_출력;

class Calculator {

	int num1;
	int num2;

	static int add(int num1, int num2) {
		return num1 + num2;
	}

	static int sub(int num1, int num2) {
		return num1 - num2;

	}

	public static class Main {

		public static void main(String[] args) {

			Calculator cal = new Calculator();

			System.out.println(cal.add(10, 20));
			System.out.println(cal.sub(200, 100));

		}
	}
}