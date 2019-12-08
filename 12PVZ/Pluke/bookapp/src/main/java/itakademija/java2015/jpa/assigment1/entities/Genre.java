package itakademija.java2015.jpa.assigment1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private int id;
	
	public Genre(String genre) {
		this.genre = genre;
	}
	
	private String genre;
	
	@ManyToMany(mappedBy="genres", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Book> books;
	
	public Genre() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book b) {
		if (getBooks() == null)
			setBooks(new ArrayList<>());
		if (!getBooks().contains(b))
			getBooks().add(b);
	}
}
