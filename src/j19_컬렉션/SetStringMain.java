package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {

	public static void main(String[] args) {
		Set<String> setStr = new HashSet<>(); // hash값으로 정렬
		List<String> listStr = new ArrayList<>();

		listStr.add("임나영");
		listStr.add("강대협");
		listStr.add("손지호");
		listStr.add("최해혁");
		listStr.add("최해혁");

		System.out.println(listStr);

		setStr.add("김상현");
		setStr.add("강대협");
		setStr.add("손지호");
		setStr.add("최해혁");
		setStr.add("최해혁");
		setStr.addAll(listStr); // addAll 사용시 자동으로 중복제거  set을 만들고 ArrayList에넣어도 들어감 map은 제외
 
		System.out.println(setStr);
		String serachName = "손지호";
		// 반드시 foreach 사용
		for (String name : setStr) {
			if (name.equals(serachName)) {

				System.out.println(name);
			}
		}

		Iterator<String> iterator = setStr.iterator(); // iterator 공간에 넣어두고 꺼내서 비교함
		while (iterator.hasNext()) {
			String n = iterator.next();
			if (n.equals(serachName)) {
				System.out.println(n);
			}
		}
	}

}
