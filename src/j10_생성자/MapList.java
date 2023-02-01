package j10_생성자;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapList {

	public static void main(String[] args) {
		List<String> colors = new ArrayList<>();
		colors.add("red, green , blue");
		
		List<String> sizes =  new ArrayList<>();
		sizes.add("SS, S, M, L, XL");
		
		Map<String, List<String>> options = new HashMap<>();
		options.put(("사이즈= "), sizes);
		options.put(("색상= "), colors);
		
		for(Entry<String, List<String>> entry : options.entrySet()) {
			System.out.println(entry.getKey() );
			System.out.println(entry.getValue() );
		}
	} 
}
