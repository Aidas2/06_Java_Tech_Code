package lt.sventes.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
//tarpine klase tarp, skirta naujo objekto duomenu bazeje sukurimui
//su sia klase dirba Controller

public class CreateHolidayDTO {
	
	//private long id; //kodel nebereikia (nes ReturnHolidayDTO tai yra)?
	@NotNull
	@Length(min = 1, max = 80)
	private String title;
	@NotNull
	@Length(min = 1, max = 80)
	private String description;
	@NotNull
	@Length(min = 1, max = 80)
	private String imageOfHoliday;
	@NotNull
	@Length(min = 1, max = 80)
	private String type;
	private boolean isFlagRaised;
	
	//Jonas - tik tuscias konstruktorius
	//Migle - tuscias ir pilnas
	//Andrius - tik pilnas konstruktorius
	
	public CreateHolidayDTO() {
		
	}

	public CreateHolidayDTO(@NotNull @Length(min = 1, max = 80) String title,
			@NotNull @Length(min = 1, max = 80) String description,
			@NotNull @Length(min = 1, max = 80) String imageOfHoliday, @NotNull @Length(min = 1, max = 80) String type,
			boolean isFlagRaised) {
		super();
		this.title = title;
		this.description = description;
		this.imageOfHoliday = imageOfHoliday;
		this.type = type;
		this.isFlagRaised = isFlagRaised;
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
