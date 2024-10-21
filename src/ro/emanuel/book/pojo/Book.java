package ro.emanuel.book.pojo;

public class Book {
	
	private int id;
	private String title;
	private int pages;
	private int price;
	
	private Book() {
		
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", price=" + price + "]";
	}

	public Book(int id, String title, int pages, int price) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.price = price;
	}

	public Book(String title, int pages, int price) {
		super();
		this.title = title;
		this.pages = pages;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
