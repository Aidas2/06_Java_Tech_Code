package it.akademija.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Tai yra DTO - data transfer object.
//Skirta tam, kad butu galima pernesti duomenis (is kur?) i (i kur?)
@Entity
public final class Cart {
	@Id
	private long id;
	@Column
	private String title;
	@Column
	private String image;
	
	public Cart() {
	}

	public Cart(long id, String title, String image) {
		this.id = id;
		this.title = title;
		this.image = image;
	}
	
	// toliau - get ir set metodai

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
