package j12_배열;

public class Array1 {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		
		int[] nums = new int[5];  //배열자체는 참조 자료형 (일반자료형으로 만든것)
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		for(int i = 0; i < 5; i++) {
			System.out.println(nums[i]);
		}
	}
	/**
	 * 배열 = 일정한 크기로 이동할 수 있게끔 만듬 //클래스가 자료형이라 배열로 만들수있다.
	 * 반복문이 중요/ .length나 forEach()
	 * 
	 * a [0, 1, 2, 3, 4]
	 * for와forEach의 차이 인덱스의 유무, forEach는 새로운 공간에 값을 넣어서 가지고 옴 for는 바로 접근함
	 * forEach = 메소드명(customer? 람다를 쓸수있는 인터페이스)
	 */
}
