package lt.sventes.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import lt.sventes.entities.Country;
import lt.sventes.entities.Year;
import lt.sventes.enums.HolidayType;

public class ReturnHolidayDTO {
	
	private Long id;
	private String title;
	private String description;
	private HolidayType type;
	private String imageOfHoliday;
	private boolean isFlagRaised;
	private Date hireDate;
	private int distance;
	private double price;

//	private Set<Country> countriesList = new HashSet<>();
//	private Set<Year> yearsList = new HashSet<>();

	public ReturnHolidayDTO() {
	}

	public ReturnHolidayDTO(
			Long id,
			String title,
			String description,
			HolidayType type,
			String imageOfHoliday,
			boolean isFlagRaised,
			Date hireDate,
			int distance,
			double price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.imageOfHoliday = imageOfHoliday;
		this.isFlagRaised = isFlagRaised;
		this.hireDate = hireDate;
		this.distance = distance;
		this.price = price;
	}

//	public ReturnHolidayDTO(
//			Long id,
//			String title,
//			String description,
//			HolidayType type,
//			String imageOfHoliday,
//			boolean isFlagRaised,
//			Date hireDate,
//			int distance,
//			double price, Set<Country> countriesList, Set<Year> yearsList) {
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.type = type;
//		this.imageOfHoliday = imageOfHoliday;
//		this.isFlagRaised = isFlagRaised;
//		this.hireDate = hireDate;
//		this.distance = distance;
//		this.price = price;
//		this.countriesList = countriesList;
//		this.yearsList = yearsList;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HolidayType getType() {
		return type;
	}

	public void setType(HolidayType type) {
		this.type = type;
	}

	public String getImageOfHoliday() {
		return imageOfHoliday;
	}

	public void setImageOfHoliday(String imageOfHoliday) {
		this.imageOfHoliday = imageOfHoliday;
	}

	public boolean isFlagRaised() {
		return isFlagRaised;
	}

	public void setFlagRaised(boolean flagRaised) {
		isFlagRaised = flagRaised;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public Set<Country> getCountriesList() {
//		return countriesList;
//	}
//
//	public void setCountriesList(Set<Country> countriesList) {
//		this.countriesList = countriesList;
//	}
//
//	public Set<Year> getYearsList() {
//		return yearsList;
//	}
//
//	public void setYearsList(Set<Year> yearsList) {
//		this.yearsList = yearsList;
//	}
}
