package 입문;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	
	static void printCollection(Collection<?> c) {  //object가 String의 상위타입이 아니기에 컴파일 불가능
		for(Object e : c) {
			System.out.println(e);
		}
	}

	
	public static void main(String[] args) {
		Collection<String> c =  new ArrayList<>();
		c.add("hi");
		printCollection(c);
	}

}
