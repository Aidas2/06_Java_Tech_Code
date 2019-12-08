package lt.vtvpmc.exam.ui;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lt.vtvpmc.exam.entities.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;



public class NewClientBean {
	
	static final Logger logger = LoggerFactory.getLogger(NewClientBean.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String city;
    private Client client;
    
    @Transactional
    public String save() {
        Client client = new Client(clientFirstName, clientLastName, clientPhoneNumber, city);
        entityManager.persist(client);
        logger.info("New customer saved");
        return "main";
    }
    
    public String open(Client client) {
        setClient(client);
        return "addSurvey";
    }
    
    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    

    
}
