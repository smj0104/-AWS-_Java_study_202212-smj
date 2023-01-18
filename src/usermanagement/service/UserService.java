package usermanagement.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	private Gson gson;
	
	private static UserService instance;

	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
			//BCrypt.checkpw ("1234", asdrasdffasdfdasfds) 1234와 복호화된 숫자를 비교함

	public Map<String, String> loginUser(String userJson) {
		Map<String, String> response = new HashMap<>();
		
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		for(Entry<String, String> userEntry : userMap.entrySet()) {		
			User user = gson.fromJson(userJson, User.class);
			
			user.getPassword(BCrypt.checkpw(user., BCrypt.gensalt()));

		
		}
		
	}
		
	
	public Map<String, String> register(String userJson) {
		//response: 응답
		Map<String, String> response = new HashMap<>();
		
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		for(Entry<String, String> userEntry : userMap.entrySet()) {
			if(userEntry.getValue().isBlank()) { //getValue로 값을 꺼내고 isBlank로 value가 비었는지 확인 비었으면 에러
										//스페이스바를 빈값으로 본다
				response.put("error", userEntry.getKey() + "은(는) 공백일 수 없습니다.");  //에러 날려줌 어느필드가 비었는지 알기위해 entry사용
				return response;
				
			}
			
		}
		
		User user = gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴! User 객체로 변환");
		System.out.println(user);
		
		if(duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용중인 사용자 이름입니다.");
			return response;
		}
		

		if(duplicatedEmail(user.getEmail())) {
			response.put("error", "이미 가입된 이메일입니다.");
			return response;
		}
//		String pw = BCrypt.hashpw("1234", BCrypt.gensalt());
//		System.out.println(pw); 
//		System.out.println(BCrypt.checkpw("1234", pw)); 
//		
//		
		//user.setPassword(BCrypt.);
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후");
		System.out.println(user);
		
		userRepository.saveUser(user);
		
		response.put("ok", "회원가입 성공");
		
		return response;
	}
	
//	User user = gson.fromJson(log, null)
//	public void register(String userJson) {
//		User user = gson.fromJson(userJson, User.class);
//		if(duplicatedUsername(user.getUsername())) {  //notnull이라는 뜻
//			
//		}
	
	
	
	private boolean duplicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
		
	}
	
	private boolean duplicatedEmail(String email) {
		return userRepository.findUserByEmail(email) != null;
		
	}
	
		
		
}
