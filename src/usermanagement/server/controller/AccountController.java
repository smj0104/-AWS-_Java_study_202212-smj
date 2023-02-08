package usermanagement.server.controller;

import j20_JSON.builder.User;
import usermanagement.dto.ResponseDto;

public class AccountController {
	
	private static AccountController instance;
	
	private AccountController() {}
	
	public static AccountController getinstance() {
			if(instance == null) {
				instance = new AccountController();
			}
		
		return instance;
	}
	
	public ResponseDto<?> register(User user) {
		
		
		return new ResponseDto<String>("ok", "회원가입 성공");
		
	}

}
