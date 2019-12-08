package infobalt.bluOrangeApp.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Van implements Serializable {
	private static final long serialVersionUID = -2592264505437536988L;
	
	@Id
	@GeneratedValue
	private Long vanId;
	
	@NotNull
	@NotBlank
	private String vanType;
	
	@NotNull
	@NotBlank
	private String factory;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	private Double price;
	
	private Double finalPrice;
	
	@JoinColumn(name = "van_number")
	@ManyToOne(optional = true, cascade = { CascadeType.PERSIST })
	private Train train;


	public Long getVanId() {
		return vanId;
	}

	public void setVanId(Long vanId) {
		this.vanId = vanId;
	}

	public String getVanType() {
		return vanType;
	}

	public void setVanType(String vanType) {
		this.vanType = vanType;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public void calculateFinalPrice() {
		Double price = this.getPrice();
		Integer quantity = this.getQuantity();
		Double finalPrice = price * quantity;
		this.finalPrice = finalPrice;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
}
