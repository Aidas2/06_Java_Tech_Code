package lt.itmokymai.spring;

public class ServiceB {
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
	
}
