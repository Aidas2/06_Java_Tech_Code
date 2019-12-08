package infobalt.bluOrangeApp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Train implements Serializable {
	private static final long serialVersionUID = -2592264505437536988L;
	
	@Id
	@GeneratedValue
	private Long trainNumber;
	
	@NotNull
	@NotBlank
	private String releaseDate;
	
	@NotNull
	@NotBlank
	private String factory;
	
	@NotNull
	@NotBlank
	private String city;
	
	@OneToMany(mappedBy = "train", fetch = FetchType.EAGER, orphanRemoval=true, cascade = { CascadeType.ALL })
	private List<Van> vans;
	
	public void addVan(Van m) {
		if (getVans() == null)
			setVans(new ArrayList<>());
		if (!getVans().contains(m))
			getVans().add(m);
	}

	public Long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Van> getVans() {
		return vans;
	}

	public void setVans(List<Van> vans) {
		this.vans = vans;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	
}
