package shved.ua.lviv.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import shved.ua.lviv.dao.UserDao;
import shved.ua.lviv.daoimpl.UserDaoImpl;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.services.ProductService;
import shved.ua.lviv.services.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	
	public UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public User create(User t) {
		return userDao.create(t);
	} 


	@Override
	public User read(Integer t) {
		return userDao.read(t);
	}


	@Override
	public User update(User t) {
		return userDao.update(t);
	}


	@Override
	public void delete(Integer t) {
		userDao.delete(t);
	}


	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}


}