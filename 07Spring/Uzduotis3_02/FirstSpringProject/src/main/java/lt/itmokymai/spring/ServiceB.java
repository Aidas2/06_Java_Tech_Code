package lt.itmokymai.spring;

public class ServiceB {
	private ServiceA serviceA;
	/*
	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
	*/
//Uzduotis 3_02.Pakeisti lt.itmokymai.spring.ServiceB klasę, kad naudotų ServiceA priklausomybės injekciją per konstruktorių (pvz. 59 skaidreje):
	public ServiceB(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public String getResult() {
		return "ServiceB result:" + serviceA.getResult();
	}
}
