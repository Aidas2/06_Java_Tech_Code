package lt.sventes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")  //lenteles pavadinimas DB (neirasius sukuria savo automatiskai)
public class Country { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // kas geriau ?
	private long id;
	@Column (unique=true, nullable=false)
	private String title;
	@Column
	private String imageOfFlag;
	@Column
	private String president;
	
	public Country() {
		
	}
	//konstruktorius be id (ar geriau ir kodel su id ?)
	public Country(String title, String imageOfFlag, String president) {
		super();
		//this.id = id;
		this.title = title;
		this.imageOfFlag = imageOfFlag;
		this.president = president;
	}

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

	public String getImageOfFlag() {
		return imageOfFlag;
	}

	public void setImageOfFlag(String imageOfFlag) {
		this.imageOfFlag = imageOfFlag;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}
	
}
