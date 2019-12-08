package it.akademija;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//08 pamoka 04 uzduotis. Sukuriame klase RestServisas, pazymime ja @RestController

@RestController
public class RestService {
	
	private List<Product> productList = new ArrayList<>();
	
	@Autowired
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
//08 pamoka 04 uzduotis. Sukuriame metoda getProductsCollection, pazymime ji @RequestMapping su "/productsCollection"
	
	@RequestMapping("/productsCollection")
	public List<Product> getProductsCollection() {
		System.out.println(productList);
		return productList;
	}
}
