package j19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SearchData {
	
	public static void main(String[] args) {
		Map<String, Object> searchData = new HashMap<>();
		
		searchData.put("category", "소설");
		searchData.put("searchValue", "불편한 편의점");
		
		System.out.println(searchData);
		
		System.out.println(searchData.get("category"));
		System.out.println(searchData.get("searchValue"));
		
		System.out.println(searchData.keySet());  // Key값만 뽑음
		System.out.println(searchData.values());  // Values값만 뽑음
		System.out.println(searchData.entrySet()); //대괄호안에 묶은 값들은 반복이 가능하다
		
//		for(int i = 0; i < searchData.size(); i++) {
//			System.out.println(searchData.get(null));
//		} 인덱스로는 반복이 돌아가지않는다
		
		for(String key : searchData.keySet()) {
			System.out.println(searchData.get(key));
		}
		
	}

}
