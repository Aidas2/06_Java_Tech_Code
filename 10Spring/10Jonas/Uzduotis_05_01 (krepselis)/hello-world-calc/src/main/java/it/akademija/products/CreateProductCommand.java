package it.akademija.products;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public final class CreateProductCommand {
	//@NotNull
	//private long id;
	@NotNull
	@Length(min = 1, max = 30)
	private String title;
	@NotNull
	@Length(min = 1, max = 50)
	private String image;
	@NotNull
	@Length(min = 1, max = 100)
	private String description;
	@NotNull
	private double price;
	@NotNull
	private int quantity;
	
	// toliau - get ir set metodai
	/*
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}*/
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
