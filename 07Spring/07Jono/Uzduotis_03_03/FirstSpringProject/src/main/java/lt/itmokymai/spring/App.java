package lt.itmokymai.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	
    	
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext(
    			"application-context.xml");
    			ServiceA serviceA = (ServiceA) context.getBean("serviceABean");
    			System.out.println(serviceA.getResult());
    			
    			ServiceB serviceB = (ServiceB) context.getBean("serviceBBean");
    			System.out.println((serviceB.getResult()));
    			
    			ServiceC serviceC = (ServiceC) context.getBean("serviceCBean");
    			System.out.println(serviceC.getResult() + " - spausdinimas is ServiceC");
    			
    			
    			((ConfigurableApplicationContext) context).close();
    }
    
    
}
