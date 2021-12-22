package shved.ua.lviv.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import shved.ua.lviv.dao.UserDao;
import shved.ua.lviv.daoimpl.UserDaoImpl;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.services.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	private static Logger LOG = Logger.getLogger(UserServiceImpl.class);
	private static UserService userServiceImpl;
	
	public UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			LOG.error(e);
		}
	}
	public static UserService getUserService() {
		if (userServiceImpl==null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
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
	@Override
	public User readByEmail(String email) {
		return userDao.readByEmail(email);
	}


}
