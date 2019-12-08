package lt.sventes.dto;

import java.util.HashSet;
import java.util.Set;

import lt.sventes.entities.Holiday;

import org.hibernate.validator.constraints.Length;

public class ReturnCountryDTO {

	private Long id;
	private String title;
	private String imageOfFlag;
	private String president;
	private Double area;
	private Long population;

	//private Set<Holiday> holidaysList = new HashSet<>();
	
	public ReturnCountryDTO() {
		
	}

	public ReturnCountryDTO(
			Long id,
			String title,
			String imageOfFlag,
			String president,
			Double area, Long population) {
		this.id = id;
		this.title = title;
		this.imageOfFlag = imageOfFlag;
		this.president = president;
		this.area = area;
		this.population = population;
	}

//	public ReturnCountryDTO(
//			Long id,
//			String title,
//			String imageOfFlag,
//			String president,
//			Double area, Long population, Set<Holiday> holidaysList) {
//		this.id = id;
//		this.title = title;
//		this.imageOfFlag = imageOfFlag;
//		this.president = president;
//		this.area = area;
//		this.population = population;
//		this.holidaysList = holidaysList;
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

	public String getImageOfFlag() {
		return imageOfFlag;
	}

	public void setImageOfFlag(String imageOfFlag) {
		this.imageOfFlag = imageOfFlag;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

//	public Set<Holiday> getHolidaysList() {
//		return holidaysList;
//	}
//
//	public void setHolidaysList(Set<Holiday> holidaysList) {
//		this.holidaysList = holidaysList;
//	}
}
