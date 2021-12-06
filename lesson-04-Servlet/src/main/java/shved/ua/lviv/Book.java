package shved.ua.lviv;

public class Book {

	private int id;
	private String bookName;
	private int price;
	private String link;

	public Book(int id, String bookName, int price, String link) {
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.link = link;
	}
	public Book(String bookName, int price, String link) {
		this.bookName = bookName;
		this.price = price;
		this.link = link;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", link=" + link + "]";
	}

	
	
}
