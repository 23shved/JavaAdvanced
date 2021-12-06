package shved.ua.lviv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
	private static String READ_ALL = "select * from librarynew.data";
	private static String CREATE = "insert into librarynew.data(bookName, price, link) values (?,?,?)";
	private static String READ_BY_ID = "select * from librarynew.data where id =?";
	private static String UPDATE_BY_ID = "update librarynew.data set bookName =?, price=? where id=?";
	private static String DELETE_BY_ID = "delete from librarynew.data where id =?";
	private static BookDao bookDao;

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public BookDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setInt(2, book.getPrice());
		preparedStatement.setString(3, book.getLink());

		preparedStatement.executeUpdate();
	}
	
	public Book read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return BookMapper.map(result);
	}
	public void update(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setInt(2, book.getPrice());
		preparedStatement.setInt(3, book.getId());
		preparedStatement.executeUpdate();

	}
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	
	}

	public List<Book> readAll() throws SQLException {
		List<Book> listofBook = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		
		while(result.next()) {
			listofBook.add(BookMapper.map(result));
		}
		return listofBook;
	}

}
