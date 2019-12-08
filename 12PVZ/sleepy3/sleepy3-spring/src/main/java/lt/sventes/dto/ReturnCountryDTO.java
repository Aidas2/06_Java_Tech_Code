package lt.sventes.dto;
//tarpine klase, tarp DB ir interneto, reikalinga duomenu atidavimui i interneto puslapi (kad atiduoti ne pati irasa is DB, o tik tam tikrus duomenis)
//su sita klase dirba servisas
public class ReturnCountryDTO {

	private long id; // cia id yra (bent jau pas Migle) ?
	private String title;
	private String imageOfFlag;
	private String president;
	
	//Jonas - tik tuscias (EditCountryCommand), tik pilnas (CountryData)
	//Migle - tuscias ir pilnas
	//Andrius - tik pilnas konstruktorius
	
	public ReturnCountryDTO() {
		
	}

	public ReturnCountryDTO(String title, String imageOfFlag, String president) {
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
