package lt.itmokymai.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;






public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		ServiceA serviceA = (ServiceA) context.getBean("serviceABean");
		System.out.println(serviceA.getResult());

//Uzduotis 3_01. lt.itmokymai.spring.App.main() atspausdinti
//ServiceB.getResult() metodo rezultatą			
		ServiceB serviceB = (ServiceB) context.getBean("serviceBBean");
		System.out.println(serviceB.getResult());
//Uzduotis 3_02. Cia niekas nesikeicia.
//Uzduotis 3_03.
    		ServiceC serviceC = (ServiceC) context.getBean("serviceCBean");
    		System.out.println(serviceC.getResult() + " - spausdinimas is ServiceC (pagal uzduoti 03_03).");
		
		((ConfigurableApplicationContext) context).close();
	}
}

//mvn eclipse:eclipse
//mvn clean package
//mvn exec:java
