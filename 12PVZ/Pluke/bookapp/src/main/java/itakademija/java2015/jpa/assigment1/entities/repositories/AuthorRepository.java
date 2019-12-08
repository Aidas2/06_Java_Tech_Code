package itakademija.java2015.jpa.assigment1.entities.repositories;

import java.util.List;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;

public interface AuthorRepository {

	public Author findFirstByNameAlternative(String name);

	public Author findFirstByName(String name);

	public List<Author> findAll();

	public void save(Author newAuthor);

	public void delete(Author author);
	
	public AuthorTag findTag(String tag);
	
	public List<Author> findAllAuthorsByTag(String tag);

}
