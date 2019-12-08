package lt.akademijait.warehouse.inventory.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.akademijait.warehouse.customer.model.Customer;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column (unique=true, nullable=false)
	private String inventoryCode;
	@Column(unique=true, nullable=false) 
	private String inventoryTitle;
	@Column
	private double inventoryWeigth;
	@Column
	private int inventorySector;
	@Column
	private LocalDate dateOfPlacement;

	// senasis apjungimo -> čia yra ne savininkas
	// @ManyToMany(mappedBy="countries")
	// List<Holiday> holidays = new ArrayList<>();
	
	// Dabartinis veikiantis variantas, kai čia yra savininko pusė
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable(name = "customer_inventory", joinColumns = @JoinColumn(name = "inventory_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	List<Customer> customers = new ArrayList<>();

	//@OneToOne(cascade = {CascadeType.ALL}) // MERGE, CascadeType.DETACH})
	//private ProductDetails productDetails;
	//nebūtinas šitas laukas surišimui
	//@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	//private List<Cart> cart = new ArrayList<Cart>();

	public Inventory() {
	}

	//konstruktorius be id
	public Inventory(String inventoryCode, String inventoryTitle, double inventoryWeigth, int inventorySector,
			LocalDate dateOfPlacement) {
		super();
		this.inventoryCode = inventoryCode;
		this.inventoryTitle = inventoryTitle;
		this.inventoryWeigth = inventoryWeigth;
		this.inventorySector = inventorySector;
		this.dateOfPlacement = dateOfPlacement;	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public String getInventoryTitle() {
		return inventoryTitle;
	}

	public void setInventoryTitle(String inventoryTitle) {
		this.inventoryTitle = inventoryTitle;
	}

	public double getInventoryWeigth() {
		return inventoryWeigth;
	}

	public void setInventoryWeigth(double inventoryWeigth) {
		this.inventoryWeigth = inventoryWeigth;
	}

	public int getInventorySector() {
		return inventorySector;
	}

	public void setInventorySector(int inventorySector) {
		this.inventorySector = inventorySector;
	}

	public LocalDate getDateOfPlacement() {
		return dateOfPlacement;
	}

	public void setDateOfPlacement(LocalDate dateOfPlacement) {
		this.dateOfPlacement = dateOfPlacement;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	
	
	


	
	
	/*public void addHoliday(Customer customer) {
		this.holidays.add(customer);
		customer.getCountries().add(this);
	}
	
	public void removeHoliday(Customer customer) {
		this.holidays.remove(customer);
		customer.getCountries().remove(this);
	}*/
	
}



	