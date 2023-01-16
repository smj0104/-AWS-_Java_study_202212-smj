package j20_JSON;

import com.google.gson.Gson;

public class Json3 {

	public static void main(String[] args) {

		Gson gson = new Gson();

		System.out.println(Integer.valueOf("100") + 50); // 문자열 100을 integer로 바꿔줌
		System.out.println(Integer.parseInt("100") + 50);
		
		gson.toJson(null); //object를 json으로 바꿔줌
		gson.fromJson("", Object.class); //json을 object로 바꿔줌
	}

}
