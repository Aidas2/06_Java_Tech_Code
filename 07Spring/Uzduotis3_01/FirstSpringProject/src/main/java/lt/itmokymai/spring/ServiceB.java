package lt.itmokymai.spring;

//uzduotis 3. Sukurti ServiceB klasę lt.itmokymai.spring pakete
//ir realizuoti ServiceA priklausomybę naudojant set*
//priklausomybės injekciją:

public class ServiceB {
	private ServiceA serviceA;

	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public String getResult() {
		return "ServiceB result:" + serviceA.getResult();
	}
}
