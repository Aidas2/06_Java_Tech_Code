package lt.sventes.country;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String title;
	@Column
	private String imageOfFlag;
	//@Column
	@OneToOne(cascade = {CascadeType.ALL}) // CascadeType.MERGE, CascadeType.DETACH})  //kas cia per susiejimas, country su country ?
	private CountryDetails countryDetails;
		
	//empty constructor
	public Country() {
	}

	//Source --> Generate Constructor using Fields
	public Country(long id, String title, String imageOfFlag, CountryDetails countryDetails) {
		super(); //ar butina ???
		this.id = id; //kodel id yra tik prie country (product) ?
		this.title = title;
		this.imageOfFlag = imageOfFlag;
		this.countryDetails = countryDetails;
	}

	//Source --> Generate Constructor using Fields. Be id nes controleryje ....
	public Country(String title, String imageOfFlag, CountryDetails countryDetails) {
		super();
		this.title = title;
		this.imageOfFlag = imageOfFlag;
		this.countryDetails = countryDetails;
	}

	//Source --> Generate Getters and Setters 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageOfFlag() {
		return imageOfFlag;
	}

	public void setImageOfFlag(String imageOfFlag) {
		this.imageOfFlag = imageOfFlag;
	}

	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}
	
}
