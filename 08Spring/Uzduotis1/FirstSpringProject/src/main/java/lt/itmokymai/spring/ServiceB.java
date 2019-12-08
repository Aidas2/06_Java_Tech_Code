package lt.itmokymai.spring;

public class ServiceB {
	private ServiceA serviceA;
	/*
	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
	
//Uzduotis 3_02. Pakeisti lt.itmokymai.spring.ServiceB klasę, kad naudotų ServiceA priklausomybės injekciją per konstruktorių
	public ServiceB(ServiceA serviceA) {
		this.serviceA = serviceA;
	}*/

//uzduotis 5. Pasirasom seteri (?)
public void setServiceA(ServiceA serviceA) {
	this.serviceA=serviceA;
	}
//turi grazinti sia reiksme + servciceABean reiksme is application-contextxml):
	public String getResult() {
		return "5 uzduotis. ServiceB result:" + serviceA.getResult();
	}
}
