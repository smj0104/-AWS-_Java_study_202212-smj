package j07_반복;

public class While1 {
	public static void main(String[] args) {
		
		int i = 0;
		int j = 0;
		
		while(i < 10) {
			j = 0;
			
			while(j < i + 1) {
				System.out.println("*");
				
				j++;
			}
			System.out.println();
			
			i++;
		}
	
		
	}

}
