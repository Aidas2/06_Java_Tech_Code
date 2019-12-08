package it.akademija.cart;

import java.util.List;

import it.akademija.products.Product;

public interface CartDao {
	
	List<Cart> getCart();

	void createCart(Cart cart);

	void deleteCart(String title);
}
