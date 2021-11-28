package ua.lviv.mavenJU.JA.lesson_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

	private static String READ_ALL = "select * from user";
	private static String READ_BY_NAME = "select * from user where first_name =?";
	private static String CREATE = "insert into user(first_name, last_name, age) values (?,?,?)";
	private static String DELETE_BY_LAST_NAME = "delete from user where last_name =?";

	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public UsersDao(Connection connection) {
		this.connection = connection;
	}
	

	public List<Users> readAll() throws SQLException {
		List<Users> listofUsers = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
		} catch (SQLException e) {
			CustomLoggerFile.logWithBasicConfigurator();
		}
		
		ResultSet result = preparedStatement.executeQuery();
		
		while(result.next()) {
			listofUsers.add(UsersMapper.map(result));
		}
		return listofUsers;
	}
	
	public Users readByName (String name) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_NAME);
			preparedStatement.setString(1, name);


		} catch (SQLException e) {
			CustomLoggerFile.logWithBasicConfigurator();
		}
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return UsersMapper.map(result);
	}
	public void insert(Users users) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setString(1, users.getFirstName());
			preparedStatement.setString(2, users.getLastName());
			preparedStatement.setInt(3, users.getAge());;
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			CustomLoggerFile.logWithDomConfigurator();
		}
		
	}
	public void delete(String lastName) throws SQLException {


		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_LAST_NAME);
			preparedStatement.setString(1, lastName);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			CustomLoggerFile.logWithDomConfigurator();
		}
	
	}
}
