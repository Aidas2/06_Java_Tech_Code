package lt.sventes.holiday;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String image;
	@Column
	private String typeOfHoliday;
	@Column
	private boolean riseOfFlag;
	
	//empty constructor
	public Holiday() {
	}

	//Source --> Generate Constructor using Fields
	public Holiday(long id, String title, String description, String image, String typeOfHoliday, boolean riseOfFlag) {
		super();  //???
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.typeOfHoliday = typeOfHoliday;
		this.riseOfFlag = riseOfFlag;
	}
	
	//konstruktorius be id
	public Holiday(String title, String description, String image, String typeOfHoliday, boolean riseOfFlag) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.typeOfHoliday = typeOfHoliday;
		this.riseOfFlag = riseOfFlag;
	}

	//Source --> Generate Getters and Setters 
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTypeOfHoliday() {
		return typeOfHoliday;
	}

	public void setTypeOfHoliday(String typeOfHoliday) {
		this.typeOfHoliday = typeOfHoliday;
	}

	public boolean isRiseOfFlag() {
		return riseOfFlag;
	}

	public void setRiseOfFlag(boolean riseOfFlag) {
		this.riseOfFlag = riseOfFlag;
	}

}
