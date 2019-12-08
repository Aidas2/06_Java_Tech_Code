package it.akademija.products;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateProductCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String title;
	@NotNull
	private double price;
	@NotNull
	private int quantity;
	@NotNull
	@Length(min = 1, max = 30)
	private String image;
	@NotNull
	@Length(min = 1, max = 30)
	private String description;
		
	// toliau - get ir set metodai
	
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
	
	
}
