package j21_예외;

// 프로그램의 오류 == 예외
public class ArrayException {

	public static void main(String[] args) {

		Integer[] nums = { 1, 2, 3, 4, 5 };

		try { // 문제가 생긴곳에 try로 감싸기
			throw new NullPointerException(); // 강제로 예외 발생시킴
//		for(int i = 0; i < 6; i++) {  //예외가 일어날수도 있는 부분
//			System.out.println(nums[i]);
//		}
		} catch (IndexOutOfBoundsException e) { // 오류가 나면 catch가 받아줌
			System.out.println("예외 처리함");
		} catch (NullPointerException e) {
			System.out.println("빈값 처리함");
		} catch (Exception e) {
			System.out.println("예상 못한 예외 처리함"); // 예상 못한 예외를 잡아준다. 하나로 다 잡을순 없음 위에서부터 예외를 타고 내려옴
		}

		System.out.println("프로그램 정상 종료");
	}
}
