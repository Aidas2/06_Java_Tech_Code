package it.akademija.products;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public void createProduct(Product product) {
		productRepository.save(product);	
	}

	public void deleteProduct(long id) {
		productRepository.delete(new Product(id, "", "", "", 0.0, 0));
	}
	
	
	public void updateProduct(Product productToUpdate) {
		productRepository.save(productToUpdate);
	}
	
}
