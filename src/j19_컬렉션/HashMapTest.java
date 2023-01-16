package j19_컬렉션;
//map에는 순서가 없어서 hash라는 방식으로 정리함  hashmap
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("username", "aaa");
		dataMap.put("password", "123");
		dataMap.put("name", "김준일");
		dataMap.put("email", "aaa@gmail.com");
		
		List<String> hobby = new ArrayList<>();
		hobby.add("골프");
		hobby.add("축구");
		hobby.add("농구");
		hobby.add("음악감상");
		
		dataMap.put("hobbys" , hobby);
		
		
		System.out.println(dataMap);
		
		List<String> list = (List<String>)dataMap.get("hobbys");
		System.out.println(list.get(0));  //arraylist로 다운캐스팅할수도있지만 보통은 list로 사용함

	}
}
