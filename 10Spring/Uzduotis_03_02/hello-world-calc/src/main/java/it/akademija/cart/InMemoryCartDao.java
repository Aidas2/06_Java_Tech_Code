package it.akademija.cart;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCartDao implements CartDao{
	
	private final List<Cart> carts = new CopyOnWriteArrayList<>();

	@Override
	public List<Cart> getCart() {
		return Collections.unmodifiableList(carts);
	}
	
	@Override
	public void createCart(Cart cart) {
		carts.add(cart);
	}

	@Override
	public void deleteCart(String title) {
		// TODO Auto-generated method stub
		for (Cart currentCart : carts) {
			if (title.equals(currentCart.getTitle())) {
				carts.remove(currentCart);
				break;
			}
		}
	}
}
