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
		return "8 pamoka. 2_01 uzduotis. ServiceB result:" + serviceA.getResult();
	}
}
