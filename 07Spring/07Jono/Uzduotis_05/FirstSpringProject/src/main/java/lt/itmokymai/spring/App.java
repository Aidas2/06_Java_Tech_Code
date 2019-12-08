package lt.itmokymai.spring;

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
    	  			  			
    			
    			
    			ServiceB serviceB = (ServiceB) context.getBean("serviceBBean");
    			System.out.println((serviceB.getResult()));
    			
    			
    		
    			((ConfigurableApplicationContext) context).close();
    	 				
    			
    			
    }
    
    
}
