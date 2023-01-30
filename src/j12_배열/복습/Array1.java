package j12_배열.복습;

public class Array1 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		System.out.println(new int[] {10, 20, 30, 40, 50});  //배열의 주소값이 나옴
		System.out.println((new int[] {10, 70, 30, 40, 50})[0]); //0번 인덱스에서 꺼내라
		System.out.println((new int[] {10, 20, 30, 40, 50})[1]);
		
		int[] nums = new int[] {10, 20, 30, 40, 50};
		//new를 통해 생성하되 넣을수있는 공간만 만듬
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		//[] = 인덱스
		
		//String[] names = new String[] {new String("김준일"), "김준이");}  //리터럴문제
	}
}
