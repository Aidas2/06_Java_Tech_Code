package lt.itmokymai.spring;

import java.util.ArrayList;
import java.util.List;

//4.03 uzduotis. ServiceC klasėje sukurti produktų sąrašą. Sukuriam produktu saraso klase:
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
