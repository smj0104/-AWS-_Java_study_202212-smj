package 입문;
//예외 처리를 하면 예외 상황을 알려주는 메세지가 나오고 프로그램이 비정상적으로 종료되지 않는다.
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class 파일입출력예외 {
	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {  //예외 클래스의 toString() 메서드 호출
			System.out.println("오류발생");
			
			e.printStackTrace();
		}
		System.out.println("여기도 수행된다.");
	}

}
