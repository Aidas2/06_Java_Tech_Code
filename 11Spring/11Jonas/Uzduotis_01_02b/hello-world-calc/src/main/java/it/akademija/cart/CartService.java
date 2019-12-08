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
	public List<Cart> getCart(String username) {
		return cartRepository.findCartByUsername(username);
	}

	@Transactional
	public void addProductToCart(Cart cart, long productId, String productTitle, int quantity) {
		System.out.println("-----------------------Prieš cart.addProduct metodą");
		cartRepository.save(cart);
		System.out.println("---------------------Padariau cartRepository.save()");
		System.out.println("----------------------- mano cart yra " + cart.getId());
		cart.addProduct(new Product(productId, productTitle, quantity));
		System.out.println("---------------------Padariau cart.addProduct()");
		System.out.println("--------------------------------------------------------------------------Kas yra sąraše?");
		System.out.println(cart.getProducts());
		cartRepository.save(cart);
		
		
	}

	@Transactional
	public void deleteProductFromCart(long id) {
		cartRepository.deleteCartById(id);
	}

}
