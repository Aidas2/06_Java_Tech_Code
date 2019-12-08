package it.akademija.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.akademija.products.Product;
import it.akademija.products.ProductRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	public List<Cart> getCart() {
		return cartRepository.findAll();
	}

	public void addProductToCart(Cart cart) {
		cartRepository.save(cart);
	}

	public void deleteProductFromCart(long id) {
		cartRepository.delete(new Cart(id, "", ""));
	}

}
