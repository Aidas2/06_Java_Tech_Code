package itakademija.java2015.jpa.assigment1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(indexes = @Index(columnList = "name ASC, lastname DESC", name = "AUTH_NAME_IDX", unique=false) , name = "AUTHOR")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR, length = 1, name = "AUTHOR_TYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("G") // general
public class Author implements Serializable {

	private static final long serialVersionUID = 5089035398648855772L;
	@Id
	@GeneratedValue
//	@Column(name="ID")
	private Long id;
	@NotNull
	@NotBlank

	private String name;
	private String lastname;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Book> books;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AuthorTag> tags;

	public List<AuthorTag> getTags() {
		return tags;
	}

	public void setTags(List<AuthorTag> tags) {
		this.tags = tags;
	}

	// @OneToOne(cascade=CascadeType.ALL)
	@Embedded
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book b) {
		if (getBooks() == null)
			setBooks(new ArrayList<>());
		if (!getBooks().contains(b))
			getBooks().add(b);
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String surname) {
		this.lastname = surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else {
			Book[] a1 = books.toArray(new Book[] {});
			Book[] a2 = other.books.toArray(new Book[] {});
			if (a1.length != a2.length)
				return false;
			for (int i = 0; i < a1.length; i++) {
				if (!a1[i].equalsSkipAuthors(a2[i]))
					return false;
			}
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (tags == null) {
			if (other.tags != null) {
				return false;
			}
		} else {
			if (other.tags == null)
				return false;
			AuthorTag[] a1 = tags.toArray(new AuthorTag[]{});
			AuthorTag[] a2 = other.tags.toArray(new AuthorTag[]{});
			if (a1.length != a2.length)
				return false;
			for (int i=0;i < a1.length; i++) {
				if (!a1[i].equals(a2[i]))
					return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", lastname=" + lastname + ", books=["
				+ ((books == null) ? books : books.size()) + "]" + ", address=" + address + "]" + super.toString();
	}

	public int hashCodeWithoutBooks() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

}
