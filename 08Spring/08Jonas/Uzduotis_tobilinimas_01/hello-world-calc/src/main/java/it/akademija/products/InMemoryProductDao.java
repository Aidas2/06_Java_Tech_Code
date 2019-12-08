package it.akademija.products;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.model.User;

@Repository
public class InMemoryProductDao implements ProductDao{
	
	private final List<Product> products = new CopyOnWriteArrayList<>();

	@Override
	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
		
	}

	@Override
	public void createProduct(Product product) {
		products.add(product);
		
	}

	@Override
	public void deleteProduct(String title) {
		for (Product currentProduct : products) {
			if (title.equals(currentProduct.getTitle())) {
				products.remove(currentProduct);
				break;
			}
		}
		
	}

	@Override
	public void updateProduct(Product productToUpdate) {
		// TODO Auto-generated method stub
		for (int i = 0; i < products.size(); i++) {
			if(productToUpdate.getId() == products.get(i).getId()) {
				products.set(i, productToUpdate);
			}
		}
	}
	
}
