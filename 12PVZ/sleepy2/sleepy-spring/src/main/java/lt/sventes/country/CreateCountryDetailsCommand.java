package lt.sventes.country;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public final class CreateCountryDetailsCommand {
	@NotNull
	@Length(min = 1, max = 50)
	private String image;
	@NotNull
	@Length(min = 1, max = 100)
	private String description;
		
	// toliau - get ir set metodai
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
