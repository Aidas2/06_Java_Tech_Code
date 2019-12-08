package it.akademija.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findCartByUsername(String username);
	void deleteCartById(long id);

}
