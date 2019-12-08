package lt.sventes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
@Entity
@Table (name = "Years-Metai")
public class Year {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // kas geriau ?
	private long id;
	@Column (unique=true, nullable=false)
	private Integer year;
	@Column
	private Integer day;
	@Column
	private String horoscope;

	public Year() {
		
	}
	//konstruktorius be id (ar geriau ir kodel su id ?)
	public Year(long id, Integer year, Integer day, String horoscope) {
		super();
		//this.id = id;
		this.year = year;
		this.day = day;
		this.horoscope = horoscope;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getHoroscope() {
		return horoscope;
	}

	public void setHoroscope(String horoscope) {
		this.horoscope = horoscope;
	}
	
}
*/