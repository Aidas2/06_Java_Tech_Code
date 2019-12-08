package lt.itmokymai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//Sukurti lt.itmokymai.spring.ServiceC klasę, kuri paveldėtų lt.itmokymai.spring.ServiceA klasę.

@Service(value="serviceCBean")
public class ServiceC extends ServiceA {

//8 pamoka. 02_02 uzduotis. Isideti Spaudintuvas priklausomybe i Service C
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
