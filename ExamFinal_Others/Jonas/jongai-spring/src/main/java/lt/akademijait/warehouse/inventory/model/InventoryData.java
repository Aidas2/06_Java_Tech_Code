package lt.akademijait.warehouse.inventory.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class InventoryData {
	private String inventoryCode;
	@NotNull
	@Length(min = 1, max = 50)
	private String inventoryTitle;
	@NotNull
	private double inventoryWeigth;
	@NotNull
	private int inventorySector;
	@NotNull
	private LocalDate dateOfPlacement;
	
	public InventoryData(String inventoryCode, @NotNull @Length(min = 1, max = 50) String inventoryTitle,
			@NotNull double inventoryWeigth, @NotNull int inventorySector, @NotNull LocalDate dateOfPlacement) {
		super();
		this.inventoryCode = inventoryCode;
		this.inventoryTitle = inventoryTitle;
		this.inventoryWeigth = inventoryWeigth;
		this.inventorySector = inventorySector;
		this.dateOfPlacement = dateOfPlacement;
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
	
	
	

}