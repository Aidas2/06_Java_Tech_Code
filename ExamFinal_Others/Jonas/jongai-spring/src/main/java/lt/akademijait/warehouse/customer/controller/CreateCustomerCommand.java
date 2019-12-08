package lt.akademijait.warehouse.customer.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateCustomerCommand {
	@NotNull
	@Length(min = 1, max = 15)
	private String firstName;
	@NotNull
	@Length(min = 1, max = 30)
	private String lastName;
	@NotNull
	private LocalDate birthday;
	@NotNull
	@Length(min = 1, max = 50)
	private String phoneNumber;
	@NotNull
	private String customerType;
	
	public CreateCustomerCommand () {
		
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
	