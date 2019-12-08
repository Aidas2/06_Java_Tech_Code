package itakademija.java2015.jpa.assigment1.entities.repositories;

import java.util.List;

import itakademija.java2015.jpa.assigment1.entities.Book;

public interface BookRepository {
	/*
	 * If book.id is set then update operation is performed
	 * If book.id == null then insert operation is performed
	 */
	public void insertOrUpdate(Book book);
	public void delete(Book book);
	public void deleteById(Long bookId);
	public List<Book> findByTitleFragment(String titleFragment);
	public Long countAllBooks();
	public List<Book> findAllBooks();
	public Book findByISBNnumber(String isbnNumber);
	public List<Book> findBook(String authorName, Integer releaseYear, String titleWord, String genre);
/*	public List<Book> findBooks(String nameOrLastname, Integer year, String titleFragment, String tag);
*/	public List<Book> findBooks2(String nameOrLastname, Integer year, String titleFragment, String tag);
}
