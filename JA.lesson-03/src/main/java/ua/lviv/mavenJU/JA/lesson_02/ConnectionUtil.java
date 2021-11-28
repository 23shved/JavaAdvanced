package ua.lviv.mavenJU.JA.lesson_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "9999";
	private static String URL = "jdbc:mysql://localhost:3306/users";
	
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// Establish connection to MySQL
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}
