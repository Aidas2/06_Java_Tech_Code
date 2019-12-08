package lt.itmokymai.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//App.main() metode sukurti IoC konteinerį.
		//iš konteinerio gauti ServiceA bean.
		//atspausdinti ServiceA.getResult() rezultatą

		ServiceA serviceA = (ServiceA) context.getBean("serviceABean");
		System.out.println(serviceA.getResult());
		
		ServiceA2 serviceA2 = (ServiceA2) context.getBean("serviceA2Bean");
		System.out.println(serviceA2.getResult());
		
		ServiceA3 serviceA3 = (ServiceA3) context.getBean("serviceA3Bean");
		System.out.println(serviceA3.getResult());
		
				
		((ConfigurableApplicationContext) context).close();
	}
}

//mvn eclipse:eclipse
//mvn clean package
//mvn exec:java
