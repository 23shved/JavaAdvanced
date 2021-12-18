package shved.ua.lviv;

import java.io.PrintWriter;
import java.sql.SQLException;

import shved.ua.lviv.utils.ConnectionUtil;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.serviceimpl.UserServiceImpl;
import shved.ua.lviv.services.UserService;
import shved.ua.lviv.shared.AbsractCRUD;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.shared.AbsractCRUD;



public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
		UserService userService = new UserServiceImpl();
	System.out.println(userService.readAll());
	userService.create(new User("UserTest", "User@Test", "User", "uSErtEs1"));
	System.out.println(userService.readAll());

	}

}
