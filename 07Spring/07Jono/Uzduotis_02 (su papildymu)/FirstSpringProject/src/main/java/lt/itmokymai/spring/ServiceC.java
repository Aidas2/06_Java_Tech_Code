package lt.itmokymai.spring;

public class ServiceC {
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
		System.out.println("Spausdinimas is init metodo");
	}
	
	public void destroy() {
		System.out.println("Spausdinimas is destroy metodo");
	}
	
}
