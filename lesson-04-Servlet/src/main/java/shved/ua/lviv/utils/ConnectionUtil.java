package shved.ua.lviv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "shved2306";
	private static String URL = "jdbc:mysql://localhost:3306/my_shop";
	
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// Establish connection to MySQL
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}
