package lt.sventes.dto;

public class ReturnHolidayDTO {
	
	private long id;	// cia id yra (bent jau pas Migle) ?
	private String title;
	private String description;
	private String imageOfHoliday;
	private String type;
	private boolean isFlagRaised;


	//Jonas - tik tuscias (EditCountryCommand), tik pilnas (CountryData)
	//Migle - tuscias ir pilnas
	//Andrius - tik pilnas konstruktorius
	
	public ReturnHolidayDTO() {
		super();
	}

	public ReturnHolidayDTO(String title, String description, String imageOfHoliday, String type,
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
