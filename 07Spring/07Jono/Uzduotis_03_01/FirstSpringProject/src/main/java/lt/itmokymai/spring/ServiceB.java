package lt.itmokymai.spring;

public class ServiceB {
	private ServiceA serviceA;

	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public String getResult() {
		return "ServiceB result:" + serviceA.getResult();
	}
}
