package it.akademija.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
@DiscriminatorValue(value = "Clothes")
public class Clothes extends IndustrialGoods {
	
	public Clothes() {
		
	}

	public Clothes(String title, ProductDetails productDetails, double price, int quantity) {
		super(title, productDetails, price, quantity);
	}

	public Clothes(@Valid long id, String title, ProductDetails productDetails, double price, int quantity) {
		super(id, title, productDetails, price, quantity);
	}

	public Clothes(long productId, String productTitle, int quantity) {
		super(productId, productTitle, quantity);
	}

}
