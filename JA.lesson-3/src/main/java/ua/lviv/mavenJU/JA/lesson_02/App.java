package ua.lviv.mavenJU.JA.lesson_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		UsersDao usersDao = new UsersDao(ConnectionUtil.openConnection());

		usersDao.readAll().forEach(System.out::println);

		System.out.println("==================================\n");
		System.out.println(usersDao.readByName("Vasyl"));
		System.out.println("==================================\n");
		
		usersDao.insert(new Users("Tolik", "Kvak", 23));
		usersDao.insert(new Users("Anatolik", "Kriak", 23));
		usersDao.insert(new Users("Johny", "Kvak", 23));

		usersDao.readAll().forEach(System.out::println);
		System.out.println("==================================\n");

		usersDao.delete("Kvak");
		usersDao.readAll().forEach(System.out::println);
		System.out.println("==================================\n");

	}

}
