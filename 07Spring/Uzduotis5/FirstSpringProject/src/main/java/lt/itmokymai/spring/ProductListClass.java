package lt.itmokymai.spring;

import java.util.ArrayList;
import java.util.List;

public class ProductListClass {
	
	private List<Product> productList = new ArrayList<Product>();

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "4 uzduotis. ProductListClass [productList = " + productList + "]";
	}
	
}
