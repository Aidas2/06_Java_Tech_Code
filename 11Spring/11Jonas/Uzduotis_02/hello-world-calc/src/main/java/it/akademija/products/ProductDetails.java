package it.akademija.products;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductDetails {
	@Column
	private String image;
	@Id
	private String description;
	//@OneToOne(mappedBy="productDetails", cascade = {CascadeType.MERGE, CascadeType.DETACH})
	//public Product product;
	
	public ProductDetails() {
		
	}
	
	
	public ProductDetails(String image, String description) {
		this.image = image;
		this.description = description;		
	}


	//seteriai ir geteriai
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

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
}
