package lt.vtvpmc.exam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Client implements Serializable {
    
	private static final long serialVersionUID = -4082230778255953111L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
    private Long id;
    
	@Column (name = "first_name")
    private String firstName;
    
	@Column (name = "last_name")
    private String lastName;
    
	@Column (name = "phone_number")
	private String phoneNumber;
	
	@Column (name = "city")
    private String city;
    
    @OneToMany(mappedBy = "client", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Survey> surveys;

    public Client() {
    }

    public Client(String firstName, String lastName, String phoneNumber, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	} 
	
	 @Override
	    public String toString() {
	        return ("client id: " + id + " name: " + firstName + " " + lastName
	        		+ " answered " + surveys.size() + " surveys");
	    }
}
