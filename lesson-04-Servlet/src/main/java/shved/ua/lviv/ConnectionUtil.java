package shved.ua.lviv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "1111";
	private static String URL = "jdbc:mysql://localhost:3306/librarynew";
	
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// Establish connection to MySQL
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}