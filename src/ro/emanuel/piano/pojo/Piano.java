package ro.emanuel.piano.pojo;

public class Piano {

	private int id;
	private String brand;
	private int price;
	private String color;
	
	private Piano() {
		
	}
	
	@Override
	public String toString() {
		return "Piano [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + "]";
	}

	public Piano(int id, String brand, int price, String color) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	public Piano(String brand, int price, String color) {
		super();
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
