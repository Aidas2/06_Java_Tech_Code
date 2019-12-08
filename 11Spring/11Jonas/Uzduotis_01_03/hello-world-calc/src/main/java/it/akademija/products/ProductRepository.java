package it.akademija.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	void deleteProductById(long id);
} 
