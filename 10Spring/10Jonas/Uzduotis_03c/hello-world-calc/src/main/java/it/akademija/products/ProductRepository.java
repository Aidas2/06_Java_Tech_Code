package it.akademija.products;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.model.User;

public interface ProductRepository extends JpaRepository<Product, Long> {} 
