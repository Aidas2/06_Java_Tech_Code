package lt.akademijait.warehouse.customer.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.akademijait.warehouse.inventory.model.Inventory;

@Entity
@Table(name = "customer", indexes = { @Index(name = "idx_customerCode", columnList = "customerCode", unique = true),
		@Index(name = "idx_firstName", columnList = "firstName", unique = true),
		@Index(name = "idx_lastName", columnList = "lastName", unique = true),
		@Index(name = "idx_birthday", columnList = "birthday", unique = true) })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column (unique=true, nullable=false)
	private String customerCode;
	@Column (nullable=false) 
	private String firstName;
	@Column (nullable=false) 
	private String lastName;
	@Column
	private LocalDate birthday;
	@Column
	private String phoneNumber;
	@Column
	private CustomerType customerType;
	
	// Dabartinis veikiantis variantas, kai čia ne savininko pusė
	@JsonIgnore
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private List<Inventory> inventories = new ArrayList<>();
	
	

	public Customer() {
	}
	
	
	
	// Konstruktorius be id
	public Customer(String customerCode, String firstName, String lastName, LocalDate birthday, String phoneNumber,
			CustomerType customerType, List<Inventory> inventories) {
		super();
		this.customerCode = customerCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.customerType = customerType;
		//this.inventories = inventories;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

////////////////////////////////////////////////////////////////////////////////////

	/*public void setCountries(List<Country> countries) {
		this.countries = countries;
	}*/
	
	public void addInventory(Inventory inventory) {
		this.inventories.add(inventory);
		inventory.getCustomers().add(this);
	}
	
	public void removeInventory(Inventory inventory) {
		this.inventories.remove(inventory);
		inventory.getCustomers().remove(this);
	}
	
	
	
}
