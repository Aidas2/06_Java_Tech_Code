package lt.itmokymai.spring;

public class ServiceA3 {
	private String message;
	
	public String getResult() {
		return getMessage();
		}
	
	public String getMessage() {
		return message;
		}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("Spausdinimas is klase ServiceA3 init metodo");
	}
	
	public void destroy() {
		System.out.println("Spausdinimas is klase ServiceA3 destroy metodo");
	}
	
}
