package lt.sventes.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lt.sventes.entities.Holiday;

import org.hibernate.validator.constraints.Length;

public class CreateCountryDTO {
	
	//private Long id;

	@NotNull
	@Length(min = 1, max = 50)
	private String title;
	@NotNull
	@Length(min = 1, max = 50)
	private String imageOfFlag;
	@NotNull
	@Length(min = 1, max = 50)
	private String president;

	@NotNull
	@Length(min = 1, max = 500)
	private Double area;

	@NotNull
	@Length(min = 1, max = 500)
	private Long population;

	//private Set<Holiday> holidaysList = new HashSet<>();
	
	public CreateCountryDTO() {
		
	}

	public CreateCountryDTO(
			//Long id,
			@NotNull @Length(min = 1, max = 50) String title,
			@NotNull @Length(min = 1, max = 50) String imageOfFlag,
			@NotNull @Length(min = 1, max = 50) String president,
			@NotNull @Length(min = 1, max = 500) Double area,
			@NotNull @Length(min = 1, max = 500) Long population) {
		//this.id = id;
		this.title = title;
		this.imageOfFlag = imageOfFlag;
		this.president = president;
		this.area = area;
		this.population = population;
	}

//	public CreateCountryDTO(
//			//Long id,
//			@NotNull @Length(min = 1, max = 50) String title,
//			@NotNull @Length(min = 1, max = 50) String imageOfFlag,
//			@NotNull @Length(min = 1, max = 50) String president,
//			@NotNull @Length(min = 1, max = 500) Double area,
//			@NotNull @Length(min = 1, max = 500) Long population,
//			Set<Holiday> holidaysList) {
//		//this.id = id;
//		this.title = title;
//		this.imageOfFlag = imageOfFlag;
//		this.president = president;
//		this.area = area;
//		this.population = population;
//		this.holidaysList = holidaysList;
//	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

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
