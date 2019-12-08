package lt.itmokymai.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		ServiceA serviceA = (ServiceA) context.getBean("serviceABean");
		System.out.println(serviceA.getResult());
		
//Uzduotis 3.1. lt.itmokymai.spring.App.main() atspausdinti
//ServiceB.getResult() metodo rezultatą
		ServiceB serviceB = (ServiceB) context.getBean("serviceBBean");
		System.out.println(serviceB.getResult());
		
		((ConfigurableApplicationContext) context).close();
	}
}

//mvn eclipse:eclipse
//mvn clean package
//mvn exec:java
