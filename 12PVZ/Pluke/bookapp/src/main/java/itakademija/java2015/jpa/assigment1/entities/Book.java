package itakademija.java2015.jpa.assigment1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = -2592264505437536988L;
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotBlank
	private String title;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	private String edition;
	@JoinColumn(name = "author_id")
	@ManyToOne(optional = true, cascade = { CascadeType.ALL })
	private Author author;
	
	@Column
	@Size(min=1, max=13)
	private String isbnNumber;
	
	@JoinColumn(name="genre_id")
	@ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Genre> genres = new ArrayList<Genre>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
		author.addBook(this);
	}
	
	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", edition=" + edition
				+ ", author=" + ((author == null) ? null : author.getName()) + "]" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCodeWithoutBooks()); 
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (edition == null) {
			if (other.edition != null) {
				return false;
			}
		} else if (!edition.equals(other.edition)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (releaseDate == null) {
			if (other.releaseDate != null) {
				return false;
			}
		} else if (!releaseDate.equals(other.releaseDate)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
	public boolean equalsSkipAuthors(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} 
		if (edition == null) {
			if (other.edition != null) {
				return false;
			}
		} else if (!edition.equals(other.edition)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (releaseDate == null) {
			if (other.releaseDate != null) {
				return false;
			}
		} else if (!releaseDate.equals(other.releaseDate)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
}
