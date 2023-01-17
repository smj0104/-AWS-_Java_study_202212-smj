package usermanagement.repository;

import java.util.ArrayList;
import java.util.List;

import usermanagement.entity.User;

public class UserRepository {
	
	private List<User> userDataList;
	
	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	private UserRepository() {
		userDataList = new ArrayList<>();
	}
	
	public void saveUser(User user) {
		userDataList.add(user);
	}
	
	public User findUserByUsername(String username) {
		for(User user : userDataList) {
			if(user.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}

}
