package shved.ua.lviv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {

	public static Book map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String bookName = result.getString("bookName");
		int price = result.getInt("price");
		String link = result.getString("link");
		
		return new Book(id, bookName, price, link);
	}
}
