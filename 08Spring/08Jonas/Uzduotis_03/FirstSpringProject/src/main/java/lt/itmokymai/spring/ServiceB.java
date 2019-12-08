package lt.itmokymai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="serviceBBean")
public class ServiceB {
	private ServiceA serviceA;
	
	@Autowired
	public ServiceB(@Qualifier(value="serviceABean")ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public String getResult() {
		return "ServiceB result:" + serviceA.getResult();
	}
}
