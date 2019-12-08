package itakademija.java2015.jpa.assigment1.entities.repositories;

import java.util.Collection;

import itakademija.java2015.jpa.assigment1.entities.Book;

public interface GenreRepository {
	
	public Collection<Book> findBookByGenre(String genre);

}
