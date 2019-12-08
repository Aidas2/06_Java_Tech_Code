package it.akademija.products;

import java.util.List;

import it.akademija.model.User;

public interface ProductDao {
	List<Product> getProducts();

	void createProduct(Product product);

	void deleteProduct(String title);
}
