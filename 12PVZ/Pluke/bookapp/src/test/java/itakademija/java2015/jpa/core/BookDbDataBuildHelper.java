package itakademija.java2015.jpa.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import itakademija.java2015.jpa.assigment1.entities.Address;
import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.Genre;


public class BookDbDataBuildHelper {

	public static Book buildSampleBook1() {
		Book book = new Book();
		LocalDateTime releaseDate = LocalDateTime.of(2008, Month.MAY, 28, 0, 0);
		Date convertedDate = Date.from(releaseDate.atZone(ZoneId.systemDefault()).toInstant());
		book.setReleaseDate(convertedDate);
		book.setTitle("Effective Java");
		book.setIsbnNumber("3728293");
		book.getGenres().add(new Genre("comedy"));

		Address add1 = buildAddress();

		Author author = new Author();
		author.setName("Joshua");
		author.setLastname("Bloch");
		author.setAddress(add1);

		book.setAuthor(author);

		return book;
	}

	public static Address buildAddress() {
		Address add1 = new Address();
		add1.setBuilding("11");
		add1.setCity("Vilnius");
		add1.setCountry("LT");
		add1.setFlat("0");
		return add1;
	}

	public static Book buildSampleBook2() {
		LocalDateTime releaseDate;
		Date convertedDate;
		Author author;
		Book book;
		author = new Author();
		author.setName("Javier");
		author.setLastname("Fernandez");
		author.setAddress(buildAddress());

		releaseDate = LocalDateTime.of(2012, Month.OCTOBER, 25, 0, 0).truncatedTo(ChronoUnit.DAYS);
		convertedDate = Date.from(releaseDate.atZone(ZoneId.systemDefault()).toInstant());
		book = new Book();
		book.setTitle("Java 7 Concurrency Cookbook");
		book.setAuthor(author);
		book.setReleaseDate(convertedDate);
		book.setIsbnNumber("359483737");
//		book.getGenres().add(new Genre("sci-fi"));
		return book;
	}

	public static Book buildSampleBook(String name, String lastname, int releaseYear, String title, String isbnNumber, String genre, String tag) {
		Book sample = buildSampleBook2();

		List<Genre> genres = sample.getGenres();
		Genre g1 = new Genre();
		g1.setGenre(genre);
		genres.add(g1);

		LocalDateTime date = LocalDateTime.now().withYear(releaseYear).truncatedTo(ChronoUnit.DAYS);
		Date convertedDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
		sample.setReleaseDate(convertedDate);

		sample.getAuthor().setName(name);
		sample.getAuthor().setLastname(lastname);
		sample.setTitle(title);
		List<AuthorTag> tags = new ArrayList<>();
		if (tag != null) {
			AuthorTag at = new AuthorTag();
			at.setTag(tag);
			tags.add(at);
		}
		sample.getAuthor().setTags(tags);

		return sample;
	}

}
