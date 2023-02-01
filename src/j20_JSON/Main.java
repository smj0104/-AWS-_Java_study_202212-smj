package j20_JSON;

public class Main {
	public static void main(String[] args) {
		
		Computer builder = new Computer.Builder()
			.CpuType("AMD")
			.RamSize(16)
			.SsdSize(512)
			.build();
		
		System.out.println(builder);
		

			
	}
	
}
