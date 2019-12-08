package lt.svs.dto;

import lt.svs.entities.Customer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReturnInventorDTO {

	private Long id;
	private String title;
	private Double weight;
	private Integer numberOfSector;
	private Date placementDate;

	//private Set<Customer> holidaysList = new HashSet<>();
	
	public ReturnInventorDTO() {
		
	}

	public ReturnInventorDTO(Long id, String title, Double weight, Integer numberOfSector, Date placementDate) {
		this.id = id;
		this.title = title;
		this.weight = weight;
		this.numberOfSector = numberOfSector;
		this.placementDate = placementDate;
	}

//	public ReturnInventorDTO(Long id, String title, Double weight, Integer numberOfSector, Date placementDate, Set<Customer> holidaysList) {
//		this.id = id;
//		this.title = title;
//		this.weight = weight;
//		this.numberOfSector = numberOfSector;
//		this.placementDate = placementDate;
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
