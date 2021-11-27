package ua.lviv.mavenJU.JA.lesson_02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper {

	public static Users map(ResultSet result) throws SQLException {
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		int age = result.getInt("age");
		
		return new Users(firstName, lastName, age);
	}
}
