package j17_스태틱;

public class Cartest {
	public static void main(String[] args) {
		Car[] cars = new Car[10];
		
		cars[0] = new Car("Amodel");
		cars[1] = new Car("Bmodel");
		cars[2] = new Car("Cmodel");
		cars[3] = new Car("Dmodel");
		cars[4] = new Car("Emodel");
		cars[5] = new Car("Fmodel");
		cars[6] = new Car("Gmodel");
		cars[7] = new Car("Hmodel");
		cars[8] = new Car("Umodel");
		cars[9] = new Car("E");
		
		for(Car i : cars) {
			System.out.println(i);
		}
	}

}
