package lt.itmokymai.spring;

import org.springframework.stereotype.Service;

@Service(value="serviceABean")
public class ServiceA {
	private String message;
	
	public ServiceA() {
		this.message = "ServiceA message";
	}
	
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
