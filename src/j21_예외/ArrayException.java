package j21_예외;

//java compile언어 처음부터 끝까지 한번에 해석 python은 한줄씩
// 프로그램의 오류 == 예외   unchecked exception 예외처리를 하지않아도 프로그램이 진행됨
public class ArrayException {

	public static void main(String[] args) {

		Integer[] nums = { 1, 2, 3, 4, 5 };

		try { // 문제가 생긴곳에 try로 감싸기
			throw new NullPointerException(); // 강제로 예외 발생시킴
//		for(int i = 0; i < 6; i++) {  //예외가 일어날수도 있는 부분 인덱스를 초과시킴
//			System.out.println(nums[i]);
//		}
		} catch (IndexOutOfBoundsException e) { // 오류가 나면 catch가 받아줌 하위객체들부터 먼저 검사
			System.out.println("예외 처리함");
		} catch (NullPointerException e) { // 안에 있는 주소를 호출할 수 없다.
			System.out.println("빈값 처리함");
		} catch (Exception e) {
			System.out.println("예상 못한 예외 처리함"); // 예상 못한 예외를 잡아준다. 하나로 다 잡을순 없음 위에서부터 예외를 타고 내려옴 (상위 객체라 모든 예외를 다 잡아줌)
		}

		System.out.println("프로그램 정상 종료");
	}
}

//런타임exception의 하위는 unchecked 중간에 런타임이 없을경우 checked exception