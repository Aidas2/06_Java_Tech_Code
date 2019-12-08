package lt.sventes.country;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CountryDetails {
	@Id
	private String nameOfPresident;
	@Column
	private String dateOfHoliday;
	
	//empty constructor
	public CountryDetails() {
		
	}

	//Source --> Generate Constructor using Fields
	public CountryDetails(String nameOfPresident, String dateOfHoliday) {
		super();
		this.nameOfPresident = nameOfPresident;
		this.dateOfHoliday = dateOfHoliday;
	}

	//Source --> Generate Getters and Setters
	public String getNameOfPresident() {
		return nameOfPresident;
	}

	public void setNameOfPresident(String nameOfPresident) {
		this.nameOfPresident = nameOfPresident;
	}

	public String getDateOfHoliday() {
		return dateOfHoliday;
	}

	public void setDateOfHoliday(String dateOfHoliday) {
		this.dateOfHoliday = dateOfHoliday;
	}

	
}
