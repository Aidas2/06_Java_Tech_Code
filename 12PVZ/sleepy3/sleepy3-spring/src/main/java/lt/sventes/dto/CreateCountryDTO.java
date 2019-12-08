package lt.sventes.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
//tarpine klase tarp, skirta naujo objekto duomenu bazeje sukurimui
//su sia klase dirba Controller

public class CreateCountryDTO {
	
	//private long id;  //kodel nebereikia (nes ReturnCountryDTO tai yra)?
	@NotNull
	@Length(min = 1, max = 50)
	private String title;
	@NotNull
	@Length(min = 1, max = 50)
	private String imageOfFlag;
	@NotNull
	@Length(min = 1, max = 50)
	private String president;
	
	//Jonas - tik tuscias konstruktorius
	//Migle - tuscias ir pilnas
	//Andrius - tik pilnas konstruktorius
	
	public CreateCountryDTO() {
		
	}

	public CreateCountryDTO(@NotNull @Length(min = 1, max = 50) String title,
			@NotNull @Length(min = 1, max = 50) String imageOfFlag,
			@NotNull @Length(min = 1, max = 50) String president) {
		super();
		this.title = title;
		this.imageOfFlag = imageOfFlag;
		this.president = president;
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
