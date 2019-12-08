package lt.itmokymai.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */

public class App {
			
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		
		ServiceA serviceA = (ServiceA) context.getBean("serviceABean");
		//arba
		//ServiceA serviceA = (ServiceA) context.getBean(ServiceA.class);
		
		System.out.println(serviceA.getResult());
				
		ServiceB serviceB = (ServiceB) context.getBean("serviceBBean");
		System.out.println((serviceB.getResult()));

		ServiceC serviceC = (ServiceC) context.getBean("serviceCBean");
		System.out.println(serviceC.getResult() + " - spausdinimas is ServiceC");
		

		
		//ProductListClass productList = (ProductListClass) context.getBean("productList");
		//System.out.println(productList.getProductList());
				
		ProductListClass newMegaList = (ProductListClass) context.getBean("productList");
		
		//pirmas budas spausdinti produktu lista
		//System.out.println(newMegaList.toString());
		
		
		((ConfigurableApplicationContext) context).close();
		
		
		
	
	}

}
