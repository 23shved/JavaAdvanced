package shved.ua.lviv;

import java.io.PrintWriter;
import java.sql.SQLException;



public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		BookDao bookDao = new BookDao(ConnectionUtil.openConnection());
		bookDao.readAll().forEach(System.out::println);
		System.out.println(bookDao.read(1));
		
	
	}

}
