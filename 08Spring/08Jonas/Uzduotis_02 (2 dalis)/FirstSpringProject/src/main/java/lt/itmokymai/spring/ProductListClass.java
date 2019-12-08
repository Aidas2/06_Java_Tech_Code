package lt.itmokymai.spring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="productList")
public class ProductListClass {
	
	private List<Product> productList = new ArrayList<>();

	public List<Product> getProductList() {
		return productList;
	}
	
	@Autowired
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "ProductListClass [productList=" + productList + "]";
	}
	
	/*
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct");
		System.out.println(productList);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("@PreDestroy");
		System.out.println(productList);
	}
	*/
}
