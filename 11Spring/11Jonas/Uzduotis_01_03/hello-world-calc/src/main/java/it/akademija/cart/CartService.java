package it.akademija.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.akademija.products.Product;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Transactional
	public Cart getCart(String username) {
		return cartRepository.findCartByUsername(username);
	}

	@Transactional
	public void addProductToCart(Cart cart, long productId, String productTitle, int quantity) {
		
		Cart currentCart = new Cart();
		if(cartRepository.findCartByUsername(cart.getUsername()) == null) {
			currentCart.setUsername(cart.getUsername());
		} else {
			currentCart = cartRepository.findCartByUsername(cart.getUsername());
		}
		
		currentCart.addProduct(new Product(productId, productTitle, quantity));
		cartRepository.save(currentCart);
		
	}

	@Transactional
	public void deleteProductFromCart(long id) {
		cartRepository.deleteCartById(id);
	}

}
