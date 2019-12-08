package lt.itmokymai.spring;
// 4.03 uzduotis. ServiceC klasėje sukurti produktų sąrašą. Sukuriam produkto klase (nes kad kurti sarasa pirma reikia tureti objektus kuriuos desim i ta sarasa):
public class Product {
	private String title;
	private String image;
	private String description;
	private double price;
	private int quantity;
	
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
		return "4 uzduotis. Product [title = " + title + ", image = " + image + ", description = " + description + ", price = " + price
				+ ", quantity = " + quantity + "]";
	}
	
}
