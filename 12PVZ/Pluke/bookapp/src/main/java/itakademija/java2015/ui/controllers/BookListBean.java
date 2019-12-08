package itakademija.java2015.ui.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.Genre;
import itakademija.java2015.jpa.assigment1.entities.repositories.BookRepository;

public class BookListBean {

	static final Logger log = LoggerFactory.getLogger(BookListBean.class);
	
	public static final String NAV_SHOW_ADD_BOOK = "show-add-book";
	public static final String NAV_LIST_BOOKS = "list-books";
	
	public static class BookListPageData implements Serializable {

		private static final long serialVersionUID = -7847613490719023414L;
		
		@Valid
		private Book newBook;
		
		@Valid
		private Book currentBook;
		
		private List<Book> foundBooks;
		
		private String titles;
		
		private String searchTitle;
		
		private String authorNames;
		
		private String searchAuthorName;
		
		private String genres;
		
		private String searchGenres;
		
		private Integer releaseYears;
		
		private Integer searchYear;
		
		public void init() {
			newBook = new Book();
			foundBooks = new ArrayList<Book>();
		}

		public Book getNewBook() {
			return newBook;
		}

		public void setNewBook(Book newBook) {
			this.newBook = newBook;
		}

		public Book getCurrentBook() {
			return currentBook;
		}

		public void setCurrentBook(Book currentBook) {
			this.currentBook = currentBook;
		}

		public List<Book> getFoundBooks() {
			return foundBooks;
		}

		public void setFoundBooks(List<Book> foundBooks) {
			this.foundBooks = foundBooks;
		}

		public String getTitles() {
			return titles;
		}

		public void setTitles(String titles) {
			this.titles = titles;
		}

		public String getSearchTitle() {
			return searchTitle;
		}

		public void setSearchTitle(String searchTitle) {
			this.searchTitle = searchTitle;
		}

		public String getAuthorNames() {
			return authorNames;
		}

		public void setAuthorNames(String authorNames) {
			this.authorNames = authorNames;
		}

		public String getSearchAuthorName() {
			return searchAuthorName;
		}

		public void setSearchAuthorName(String searchAuthorName) {
			this.searchAuthorName = searchAuthorName;
		}

		public String getGenres() {
			return genres;
		}

		public void setGenres(String genres) {
			this.genres = genres;
		}

		public String getSearchGenres() {
			return searchGenres;
		}

		public void setSearchGenres(String searchGenres) {
			this.searchGenres = searchGenres;
		}

		public Integer getReleaseYears() {
			return releaseYears;
		}

		public void setReleaseYears(Integer releaseYears) {
			this.releaseYears = releaseYears;
		}

		public Integer getSearchYear() {
			return searchYear;
		}

		public void setSearchYear(Integer searchYear) {
			this.searchYear = searchYear;
		}
		
	}
	private BookListPageData data;

	private BookRepository bookRepo;

	public BookListPageData getData() {
		return data;
	}

	public void setData(BookListPageData data) {
		this.data = data;
	}

	public BookRepository getBookRepo() {
		return bookRepo;
	}

	public void setBookRepo(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Book> getBookList() {
		return bookRepo.findAllBooks();
	}
	
	public String convertGenreListToGenreString(List<Genre> genres) {
		String result = "";
		for (Genre genre: genres) {
			result += genre.getGenre() + " ";
		}
		return result;
	}
	
	public String deleteSelectedBook(Book book) {
		if (book == null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Book you want to delete is null"));
		else {
			FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "You are deleting" + book.getTitle()));
			bookRepo.delete(book);
		}
		return NAV_LIST_BOOKS;
	}
	
	public String showAddBookPage(Book b) {
		log.debug("Will store selected book for later access in Add new Book form: {}", b);
		data.currentBook = b;
		return NAV_SHOW_ADD_BOOK;
	}
	
	public String searchBooks() {
		//save to session
		data.foundBooks = bookRepo.findBook(data.getSearchAuthorName(), data.getSearchYear(), data.getSearchTitle(), data.getSearchGenres());
		return NAV_LIST_BOOKS;
	}
}
