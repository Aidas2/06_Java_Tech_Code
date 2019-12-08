package lt.sventes.country;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateCountryCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String title;
	@NotNull
	@Length(min = 1, max = 30)
	private String imageOfFlag;
	@NotNull
	@Length(min = 1, max = 100)
	private String nameOfPresident;
	@NotNull
	@Length(min = 1, max = 100)
	private String dateOfHoliday;
	
	
	//Source --> Generate Getters and Setters 
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
	public String getNameOfPresident() {
		return nameOfPresident;
	}
	public void setNameOfPresident(String nameOfPresident) {
		this.nameOfPresident = nameOfPresident;
	}
	public String getDateOfHoliday() {
		return dateOfHoliday;
	}
	public void setDateOfHoliday(String dateOfHoliday) {
		this.dateOfHoliday = dateOfHoliday;
	}
	
}
