package lt.itmokymai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Pasibandymas {
	
	@Autowired
	@Qualifier("serviceABean")
	private ServiceA serviceA;
	
	public Pasibandymas() {
		System.out.println("Tuscias konstruktorius");
	}
	
	public void printMessage() {
		System.out.println("The message is - " + serviceA.getResult());
	}

}
