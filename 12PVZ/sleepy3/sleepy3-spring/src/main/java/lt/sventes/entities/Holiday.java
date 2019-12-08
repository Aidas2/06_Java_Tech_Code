package lt.sventes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "HolidaysSventes")
public class Holiday {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // kas geriau ?
	private long id;
	@Column (unique=true, nullable=false)
	private String title;
	@Column
	private String description;
	@Column
	private String imageOfHoliday;
	@Column
	private String type;
	@Column
	private boolean isFlagRaised;
	
	public Holiday() {
		
	}
	//konstruktorius be id (ar geriau ir kodel su id ?)
	public Holiday(String title, String description, String imageOfHoliday, String type,
			boolean isFlagRaised) {
		super();
		//this.id = id;
		this.title = title;
		this.description = description;
		this.imageOfHoliday = imageOfHoliday;
		this.type = type;
		this.isFlagRaised = isFlagRaised;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageOfHoliday() {
		return imageOfHoliday;
	}

	public void setImageOfHoliday(String imageOfHoliday) {
		this.imageOfHoliday = imageOfHoliday;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFlagRaised() {
		return isFlagRaised;
	}

	public void setFlagRaised(boolean isFlagRaised) {
		this.isFlagRaised = isFlagRaised;
	}
		
}
