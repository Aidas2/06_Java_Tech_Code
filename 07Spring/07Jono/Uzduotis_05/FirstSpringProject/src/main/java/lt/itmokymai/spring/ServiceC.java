package lt.itmokymai.spring;

public class ServiceC extends ServiceA {
	
	@Override
	public String getResult() {
		return "ServiceC result:" + getMessage();
		}
}
