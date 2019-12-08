package lt.itmokymai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="serviceCBean")
public class ServiceC extends ServiceA {
	
	private Spausdintuvas printer;
	
//	@Autowired
//	public ServiceC(Spausdintuvas printer) {
//		this.printer = printer;
//	}
	

	
	@Override
	public String getResult() {
		return "ServiceC result:" + getMessage();
		}
}
