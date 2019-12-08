package lt.svs.dto;

import javax.validation.constraints.NotNull;

import lt.svs.entities.Customer;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateInventorDTO {
	
	//private Long id;

	@NotNull
	@Length(min = 1, max = 100)
	private String title;

	@NotNull
	@Length(min = 1, max = 50)
	private Double weight;

	@NotNull
	@Length(min = 1, max = 50)	//max = 2
	private Integer numberOfSector;

	@NotNull
	@Length(min = 1, max = 100)
	private Date placementDate;

	//private Set<Customer> holidaysList = new HashSet<>();
	
	public CreateInventorDTO() {
		
	}

	public CreateInventorDTO(
			//Long id,
			@NotNull @Length(min = 1, max = 100) String title, @NotNull @Length(min = 1, max = 50) Double weight, @NotNull @Length(min = 1, max = 50) Integer numberOfSector, @NotNull @Length(min = 1, max = 100) Date placementDate) {
		//this.id = id;
		this.title = title;
		this.weight = weight;
		this.numberOfSector = numberOfSector;
		this.placementDate = placementDate;
	}

//	public CreateInventorDTO(
//			//Long id,
//			@NotNull @Length(min = 1, max = 100) String title, @NotNull @Length(min = 1, max = 50) Double weight, @NotNull @Length(min = 1, max = 50) Integer numberOfSector, @NotNull @Length(min = 1, max = 100) Date placementDate, Set<Customer> holidaysList) {
//		//this.id = id;
//		this.title = title;
//		this.weight = weight;
//		this.numberOfSector = numberOfSector;
//		this.placementDate = placementDate;
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getNumberOfSector() {
		return numberOfSector;
	}

	public void setNumberOfSector(Integer numberOfSector) {
		this.numberOfSector = numberOfSector;
	}

	public Date getPlacementDate() {
		return placementDate;
	}

	public void setPlacementDate(Date placementDate) {
		this.placementDate = placementDate;
	}

//	public Set<Customer> getHolidaysList() {
//		return holidaysList;
//	}
//
//	public void setHolidaysList(Set<Customer> holidaysList) {
//		this.holidaysList = holidaysList;
//	}
}
