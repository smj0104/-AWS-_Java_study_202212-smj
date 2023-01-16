package j19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringMain {
	// map은 key value가 한쌍  map에는 entry가 들어감
	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
		// map을 map에 전부 넣을대 putall 사용
		strMap.put("이종현", "a");
		strMap.put("진채희", "b");
		strMap.put("김재영", "c");
		strMap.put("이상현", "d");

		System.out.println(strMap);

		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e")); // e는 존재하지 않기에 null값 출력
		System.out.println();
		// 반복 돌리기 key값이 1 2 3 4 순이 아니라 for문은 불가능

		for (String k : strMap.keySet()) { // key를 set으로 꺼내서 for문 사용가능 for each를 iterator로 바꿀수도있다.
			System.out.println("key: " + k);
			System.out.println(strMap.get(k)); // abcd 반복함
		}
		for(String v : strMap.values()) {
			System.out.println("value: " + v);
		}
		
		//Set<Entry<String, String>> s = null;
		
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry); //set안에 entry라는 자료형으로 들어가있다
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());  //key와 value 따로 빼기
			System.out.println();
			
		}
		
		strMap.forEach((k,v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
		System.out.println(strMap.entrySet());  //key와 value를 묶어서 출력
		
	}

}
