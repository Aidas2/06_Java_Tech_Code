package it.akademija.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.products.Product;

public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findCartByUsername(String username);
	void deleteCartById(long id);

}
