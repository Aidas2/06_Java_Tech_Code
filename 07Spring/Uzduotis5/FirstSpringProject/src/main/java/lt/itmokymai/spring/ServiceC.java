package lt.itmokymai.spring;
//Sukurti lt.itmokymai.spring.ServiceC klasę, kuri paveldėtų lt.itmokymai.spring.ServiceA klasę.
public class ServiceC extends ServiceA {

	@Override
	public String getResult() {
		return "ServiceC result:" + getMessage();
		}
}
