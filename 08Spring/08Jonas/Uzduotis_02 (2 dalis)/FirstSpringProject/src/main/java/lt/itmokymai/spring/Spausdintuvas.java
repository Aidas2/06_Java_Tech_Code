package lt.itmokymai.spring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value="spausdintuvas")
@Scope("singleton")
public class Spausdintuvas {
	
	//private List<Product> listToBePrinted = new ArrayList<>();
	private ProductListClass listToBePrinted = new ProductListClass();
	
	@Autowired
	public Spausdintuvas (@Qualifier(value="productList") ProductListClass listToBePrinted) {
	//public Spausdintuvas (List<Product> listToBePrinted) {
		this.listToBePrinted = listToBePrinted;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct");
		System.out.println(listToBePrinted);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("@PreDestroy");
		System.out.println(listToBePrinted);
	}
}
