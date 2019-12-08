package lt.svs.dto;

import java.util.Date;

import lt.svs.enums.CustomerType;

public class ReturnCustomerDTO {
	
	private Long id;
	private String name;
	private String surname;
	private Date birthDate;
	private String phoneNumber;
	private CustomerType type;

//	private Set<Inventor> InventorsList = new HashSet<>();
//	private Set<Report> reportsList = new HashSet<>();

	public ReturnCustomerDTO() {
	}

	public ReturnCustomerDTO(Long id, String name, String surname, Date birthDate, String phoneNumber, CustomerType type) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}


//	public ReturnCustomerDTO(Long id, String name, String surname, Date birthDate, String phoneNumber, CustomerType type, Set<Inventor> inventorsList, Set<Report> reaportsList) {
//		this.id = id;
//		this.name = name;
//		this.surname = surname;
//		this.birthDate = birthDate;
//		this.phoneNumber = phoneNumber;
//		this.type = type;
//		InventorsList = inventorsList;
//		this.reportsList = reportsList;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}


//	public Set<Inventor> getInventorsList() {
//		return InventorsList;
//	}
//
//	public void setInventorsList(Set<Inventor> inventorsList) {
//		InventorsList = inventorsList;
//	}
//
//	public Set<Report> getReportsList() {
//		return reportsList;
//	}
//
//	public void setReportsList(Set<Report> reportsList) {
//		this.reportsList = reportsList;
//	}
}
