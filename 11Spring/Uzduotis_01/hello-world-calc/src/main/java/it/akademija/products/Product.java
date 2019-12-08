package it.akademija.products;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//Tai yra DTO - data transfer object.
//Skirta tam, kad butu galima pernesti duomenis (is kur?) i (i kur?)
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String title;
	@Column
	private double price;
	@Column
	private int quantity;
	@OneToOne(cascade = {CascadeType.ALL}) // CascadeType.MERGE, CascadeType.DETACH})
	private ProductDetails productDetails;
	
	

	public Product() {
	}

	public Product(long id, String title, ProductDetails productDetails, double price, int quantity) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.productDetails = productDetails;
	}
	
	//konstruktorius be id
	public Product(String title, ProductDetails productDetails, double price, int quantity) {
		//this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.productDetails = productDetails;
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
	
	//naujo lauko seteris ir geteris
	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	
}
