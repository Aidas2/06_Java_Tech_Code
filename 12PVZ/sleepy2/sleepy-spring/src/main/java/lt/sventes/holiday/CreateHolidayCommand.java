package lt.sventes.holiday;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public final class CreateHolidayCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String title;
	@NotNull
	@Length(min = 1, max = 30)
	private String description;
	@NotNull
	@Length(min = 1, max = 30)
	private String image;
	@NotNull
	@Length(min = 1, max = 30)
	private String typeOfHoliday;
	@NotNull
	private boolean riseOfFlag;
	
	
	//Source --> Generate Getters and Setters 
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
