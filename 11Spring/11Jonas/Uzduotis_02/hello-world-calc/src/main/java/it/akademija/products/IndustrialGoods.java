package it.akademija.products;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;

@MappedSuperclass
public abstract class IndustrialGoods extends Product {
	
	public IndustrialGoods() {
		
	}

	public IndustrialGoods(String title, ProductDetails productDetails, double price, int quantity) {
		super(title, productDetails, price, quantity);
	}

	public IndustrialGoods(@Valid long id, String title, ProductDetails productDetails, double price, int quantity) {
		super(id, title, productDetails, price, quantity);
	}

	public IndustrialGoods(long productId, String productTitle, int quantity) {
		super(productId, productTitle, quantity);
	}
	
}
