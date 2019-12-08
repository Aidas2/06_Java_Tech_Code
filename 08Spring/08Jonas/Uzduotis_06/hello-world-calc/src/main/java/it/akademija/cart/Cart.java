package it.akademija.cart;

//Tai yra DTO - data transfer object.
//Skirta tam, kad butu galima pernesti duomenis (is kur?) i (i kur?)
public final class Cart {
	private int id;
	private String title;
	private String image;
	
	public Cart() {
	}

	public Cart(int id, String title, String image) {
		this.id = id;
		this.title = title;
		this.image = image;
	}
	
	// toliau - get ir set metodai

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
