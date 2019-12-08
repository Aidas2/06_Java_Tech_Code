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
	//Cia yra mano pirmas produkto atnaujinimo medotas, kai priimu visus produkto duomenis
	/*
	@Override
	public void updateProduct(Product productToUpdate) {
		for (int i = 0; i < products.size(); i++) {
			if(productToUpdate.getId() == products.get(i).getId()) {
				products.set(i, productToUpdate);
			}
		}
	}
	*/
	
	//Cia yra 2 produkto atnaujinimo metodas, kai paduodamas tik produkto ID
	@Override
	public void updateProduct(long id, Product productToUpdate) {
		for (int i = 0; i < products.size(); i++) {
			if(id == products.get(i).getId()) {
				products.set(i, productToUpdate);
			}
		}
	}

	
	
}
