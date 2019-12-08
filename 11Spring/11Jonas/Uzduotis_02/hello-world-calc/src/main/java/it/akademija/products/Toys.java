package it.akademija.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Toys")
public class Toys extends IndustrialGoods {
	
	public Toys() {
		
	}
	
	public Toys(String title, ProductDetails productDetails, double price, int quantity) {
		super(title, productDetails, price, quantity);
	}

}
