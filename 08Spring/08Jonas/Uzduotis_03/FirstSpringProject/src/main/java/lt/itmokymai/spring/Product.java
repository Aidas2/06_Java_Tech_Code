package lt.itmokymai.spring;

public class Product {
	private String title;
	private String image;
	private String description;
	private double price;
	private int quantity;
	
	public Product() {
		this.title = "Samsung1";
		this.image = "pav.jpg";
		this.description = "Description";
		this.price = 15.0;
		this.quantity = 10;
	}
	
	public Product(String title) {
		this.title = title;
		this.image = "pav.jpg";
		this.description = "Description";
		this.price = 15.0;
		this.quantity = 10;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [title=" + title + ", image=" + image + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	
}
