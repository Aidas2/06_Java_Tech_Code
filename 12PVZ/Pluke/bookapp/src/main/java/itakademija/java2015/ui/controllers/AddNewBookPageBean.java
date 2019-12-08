package itakademija.java2015.ui.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.Genre;
import itakademija.java2015.jpa.assigment1.entities.repositories.AuthorRepository;
import itakademija.java2015.jpa.assigment1.entities.repositories.BookRepository;
import itakademija.java2015.jpa.assigment1.entities.repositories.GenreRepository;

public class AddNewBookPageBean {
	static final Logger log = LoggerFactory.getLogger(AddNewBookPageBean.class);
	/**
	 * Repositories
	 */
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;

	/**
	 * Other pages for functionality re-use
	 */
	private AuthorsListPageBean authorsListPageBean;
	
	/**
	 * Holds data for entering new book information like title and release date.
	 * In other words - it backs up form for new book.
	 */
	private Book newBook;
	private String genre;
	
	/**
	 * Initialization method for bean
	 */
	public void init() {
		newBook = new Book();
	}
	
	public String addNew() {
		/**
		 * At this point, book data is stored in newBook variable, we can save it to DB
		 */
		Author author = authorsListPageBean.getData().getCurrentAuthor();
		log.debug("Before saving book, got author: {}", author);
		log.debug("New book data: {}", newBook);
		newBook.setAuthor(author);
		author.addBook(newBook);
		this.setGenreForBook(this.genre);
		authorRepo.save(author);
		
		
		return AuthorsListPageBean.NAV_LIST_AUTHORS;
	}
	
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public AuthorsListPageBean getAuthorsListPageBean() {
		return authorsListPageBean;
	}
	public void setAuthorsListPageBean(AuthorsListPageBean authorsListPageBean) {
		this.authorsListPageBean = authorsListPageBean;
	}
	public AuthorRepository getAuthorRepo() {
		return authorRepo;
	}
	public void setAuthorRepo(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	public BookRepository getBookRepo() {
		return bookRepo;
	}
	public void setBookRepo(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public void setGenreForBook (String genre){
		newBook.getGenres().add(new Genre(genre));
	}
	
	public Book getNewBook() {
		return newBook;
	}
	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}
}
