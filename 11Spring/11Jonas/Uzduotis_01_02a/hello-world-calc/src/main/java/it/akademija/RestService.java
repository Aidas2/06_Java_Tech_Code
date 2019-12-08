package it.akademija;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {
	
	private List<Product> productList = new ArrayList<>();
	
	@Autowired
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
	
	@RequestMapping("/productsCollection")
	public List<Product> getProductsCollection() {
		System.out.println(productList);
		return productList;
	}
}
