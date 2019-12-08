package it.akademija.products;

import java.util.List;

import it.akademija.model.User;

public interface ProductDao {
	List<Product> getProducts();

	void createProduct(Product product);

	void deleteProduct(String title);
	
	//mano metodas -> pirminis (senas)
	//void updateProduct(Product product);
	
	//mano metodas produkto atnaujinimui naujas
	void updateProduct(long id, Product product);
}
