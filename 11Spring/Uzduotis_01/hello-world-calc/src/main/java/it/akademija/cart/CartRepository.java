package it.akademija.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.products.Product;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
