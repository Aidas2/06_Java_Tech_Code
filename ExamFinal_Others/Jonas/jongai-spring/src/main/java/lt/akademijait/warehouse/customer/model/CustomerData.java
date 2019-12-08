package lt.akademijait.warehouse.customer.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lt.akademijait.warehouse.inventory.model.Inventory;

public class CustomerData {
	private String customerCode;
	@NotNull
	@Length(min = 1, max = 15)
	private String firstName;
	@NotNull
	@Length(min = 1, max = 30)
	private String lastName;
	private LocalDate birthday;
	private String phoneNumber;
	private String customerType; // Čia type yra String, nes aš transformuoju Enumą į Stringą servise ir dar pakeičiu visus "_" į "-"
	// čia surišimui
	//List<Inventory> inventories;
	
	
	public CustomerData(String customerCode, @NotNull @Length(min = 1, max = 15) String firstName,
			@NotNull @Length(min = 1, max = 30) String lastName, LocalDate birthday, String phoneNumber,
			String customerType) {
		super();
		this.customerCode = customerCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.customerType = customerType;
		//this.inventories = inventories;
	}


	public String getCustomerCode() {
		return customerCode;
	}


	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCustomerType() {
		return customerType;
	}


	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	
	
	

}
