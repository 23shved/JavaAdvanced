package shved.ua.lviv.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shved.ua.lviv.domain.User;
import shved.ua.lviv.dao.UserDao;
import shved.ua.lviv.utils.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	
	
	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`user_name`,`email`, `role`, `password`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String UPDATE_BY_ID = "update user set name=?, email = ?, role=? where id = ?";
	private static String DELETE_BY_ID = "delete from user where id=?";
	
	
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtil.openConnection();
		}
	
	@Override
	public User create(User t) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getEmail());
			preparedStatement.setString(3, t.getRole());
			preparedStatement.setString(4, t.getPassword());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public User read(Integer t) {
		
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, t);
			ResultSet result = preparedStatement.executeQuery();

			Integer id = result.getInt("id");
			String name = result.getString("user_name");
			String email = result.getString("email");
			String role = result.getString("role");
			
			user = new User(id, name, email, role);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return user;
	}

	@Override
	public User update(User t) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getEmail());
			preparedStatement.setString(3, t.getRole());
			preparedStatement.setInt(4, t.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
		
		
	}

	@Override
	public void delete(Integer t) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, t);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public List<User> readAll() {
		List<User> userRecords = new ArrayList<User>();
		
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Integer id = result.getInt("id");
				String name = result.getString("user_name");
				String email = result.getString("email");
				String role = result.getString("role");
				userRecords.add(new User(id, name, email, role));
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRecords;
	}

}
