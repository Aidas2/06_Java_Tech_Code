package lt.itmokymai.spring;

import org.springframework.stereotype.Service;

@Service(value="serviceABean")
public class ServiceA {
	private String message;

	//konstruktorius ("uzharkodinam" kad perduotu nors kokia zinute) 
	public ServiceA() {
		this.message = "8 pamoka. (2_01 uzduotis) ServiceA message";
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
