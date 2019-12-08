package it.akademija.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Tai yra DTO - data transfer object.
//Skirta tam, kad butu galima pernesti duomenis (is kur?) i (i kur?)
@Entity
public final class Product {
	@Id
	private long id;
	@Column
	private String title;
	@Column
	private String image;
	@Column
	private String description;
	@Column
	private double price;
	@Column
	private int quantity;

	public Product() {
	}

	public Product(long id, String title, String image, String description, double price, int quantity) {
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	// toliau - get ir set metodai

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
}
