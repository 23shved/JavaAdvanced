package shved.ua.lviv.services;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.shared.AbsractCRUD;

import java.util.ArrayList;
import java.util.List;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.shared.AbsractCRUD;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.shared.AbsractCRUD;

public class UserServices {
	private List<User> listOfUsers = new ArrayList<>();
	private static UserServices userServices;
	private UserServices() {
		
	}
	
	public static UserServices getUserServices() {
		if(userServices == null) {
			userServices = new UserServices();
		}
		return userServices;
	}

	public List<User> getListOfUsers(){
		return listOfUsers;
	}
	
	public void saveUser(User user) {
		listOfUsers.add(user);
	}
	public User getUser(String email) {
		return listOfUsers.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
	}
}
