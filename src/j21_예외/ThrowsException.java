package j21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {
																		//unchecked는 안올라옴
	public static void printList(List<String>list, int size) throws Exception {
		
		for(int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		String[] names = {"김수현", "이종현", "박성진", "김동민"};
		try {
			//throw new ClassException
			printList(Arrays.asList(names), 5);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  //어떤 예외가 발생했는지 알려준다
		} finally { // 예외가 있으나 없으나 반드시 실행함
			System.out.println("무적권 실행함");
		}
		System.out.println("프로그램 정상종료");
	}

}
