package 주석;
//백엔드 구조 알아보기
public class 주석0130 {
	/*
	 * 최종적으로 만들어야 하는 백엔드 구조
	 * 1. 클라이언트 (스마트폰이나 웹브라우저)
	 * 요청을 통해서 웹서버로 이동 (톰캣 사용)
	 * 2.필터와 시큐리티 
	 * 권한이 있는지 요청이 제대로 된건지 확인
	 * 필터(CORS) 시큐리티(X-Frame)
	 * 3.Controller
	 * 서블릿 디스패처로 이동 (핸들러 맵핑과 Controller로 구조가 잡혀져있다)
	 * controller : 일반과 annotation rest controller로 나뉨
	 * 중간에 뷰, 뷰리졸버등이 생겨남
	 * 다시 응답을 통해 필터와 시큐리티로 이동 
	 * (AOP?)
	 * 4.DTO - Service 객체 - Repository - JDBC - DB로 처리
	 * 여기서 repository부터 DB까지가 Entity라고 부름
	 * 
	 * nullpoint가 떳다 = 참조할 주소가 없다
	 *.build가 마지막으로 객체생성
	 *
	 *                             맵 엔트리 기능 재확인 result set entry set
	 *제네릭 복습
	 *List 특징 : 중복이 가능하다 , 순서가 있다 (배열과 같음)
	 * int[] nums == List<Integer> nums
	 *배열과 리스트의 차이 (가능하면 배열 대신 리스트 사용하라) 
	 *배열은 배열이라 쓰고(배열이라는 자료형 그 자체)         List는 class다(변수와 메소드가 들어있다 배열은 .add() 같은게 없음)
	 *
	 *ArrayList<?> list = new ArrayList<String>(); 앞쪽에 ? 사용가능 앞쪽에 변수가 정해져있어야 뒤쪽 생략 가능
	 *와일드카드 					  new ArrayList<User>(); 자료형이 결정되는건 생성되는 시점
	 *list.toArray(); 리스트를  배열로 바꿈
	 * == 리턴값이 object[]로 업캐스팅 되어 들어간다 int로 바꾸고싶을경우 그냥 다운캐스팅이 아닌 값을 하나하나 꺼내어서 다운캐스팅 해야한다.
	 * 
	 * Key : value 중복불가 key랑 value가 같은게 존재할 수 없음
	 * 
	 * 
	 * 
	 */

}
