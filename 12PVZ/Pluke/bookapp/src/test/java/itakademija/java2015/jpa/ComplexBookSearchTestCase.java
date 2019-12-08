package itakademija.java2015.jpa;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.core.AuthorAppUnitTestBase;
import itakademija.java2015.jpa.core.BookDbDataBuildHelper;

public class ComplexBookSearchTestCase extends AuthorAppUnitTestBase {

	static final Logger log = LoggerFactory.getLogger(ComplexBookSearchTestCase.class);

	/*@Test
	public void testNullParametersHasNoEffect() {
		// GIVEN 2 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "title", "4326", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "title2", "76893", "genre2", "tagTitle2");
		saveBooks(book1, book2);

		// WHEN book is searched without specifying any parameters

		String nameOrLastname = null;
		Integer metai = null;
		String titleFragment = null;
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN 2 books returned;
		assertThat(searchResults.size(), is(2));
		assertThat(searchResults, hasItems(book1, book2));
		
	}
	@Test
	public void testNameParamFiltersNames() {
		// GIVEN 2 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "title", "4532", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "title2", "0967", "genre2", "tagTitle2");
		saveBooks(book1, book2);

		// WHEN book is searched without specifying any parameters

		String nameOrLastname = "name2";
		Integer metai = null;
		String titleFragment = null;
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN 
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItem(book2));
	}
	
	@Test
	public void testNameParamFiltersLastnames() {
		// GIVEN 2 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "title", "65781", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "title2", "34210", "genre2", "tagTitle2");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name2", "different", 2001, "title2", "8964", "genre3", null);
		saveBooks(book1, book2, book3);

		// WHEN book is searched with param that matches only book3

		String nameOrLastname = "different";
		Integer metai = null;
		String titleFragment = null;
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book3 as the only result
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItem(book3));
	}
	@Test
	public void testTitleFiltersFragmentLeavingOthers() {
		// GIVEN 2 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "2342", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "abcde", "2437", "genre2", "tagTitle2");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name2", "different", 2001, "abcdef", "75643", "genre3", null);
		saveBooks(book1, book2, book3);

		// WHEN book is searched with param that matches only book3

		String nameOrLastname = null;
		Integer metai = null;
		String titleFragment = "def";
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book3 as the only result
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItem(book3));
	}
	@Test
	public void testTitleFiltersSubfragment() {
		// GIVEN 2 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "1233", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "abcde", "12344", "genre2", "tagTitle2");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name2", "different", 2001, "abcdef", "12355", "genre3", null);
		saveBooks(book1, book2, book3);

		// WHEN book is searched with param that matches only book3

		String nameOrLastname = null;
		Integer metai = null;
		String titleFragment = "de";
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect matching books as result
		assertThat(searchResults.size(), is(2));
		assertThat(searchResults, hasItems(book2, book3));
	}
	@Test
	public void testFilteringByYear() {
		// GIVEN 3 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12366", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "abcde", "12377", "genre2", "tagTitle2");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name2", "different", 2005, "abcdef", "12388", "genre3", null);
		saveBooks(book1, book2, book3);

		// WHEN book is searched with param that matches only book3

		String nameOrLastname = null;
		Integer metai = 2005;
		String titleFragment = null;
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book3 as the only result
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItems(book3));
	}
	@Test
	public void testFilteringByTag() {
		// GIVEN 3 books saved to DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd","12399", "genre1", "tagTitle");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2001, "abcde", "12300", "genre2", "tagTitle2");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name2", "different", 2005, "abcdef", "12455", "genre3", null);
		saveBooks(book1, book2, book3);

		// WHEN book is searched with param that matches only book2

		String nameOrLastname = null;
		Integer metai = null;
		String titleFragment = null;
		String tagSearch = "tagTitle2";

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book2 as the only result
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItems(book2));
	}
	@Test
	public void testAllCriteriasWorkAsCombined() {
		// GIVEN 
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12466", "genre1", "tagTitle2");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12477", "genre2", null);
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12488", "genre3", "myTag");
		Book book4 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abde", "12499", "genre4", null);
		Book book5 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2001, "abcd", "12400", "genre3", null);
		Book book6 = BookDbDataBuildHelper.buildSampleBook("name", "different", 2000, "abcd", "12755", "genre3", null);
		saveBooks(book1, book2, book3, book4, book5, book6);

		// WHEN book is searched with all params 

		String nameOrLastname = "nam";
		Integer metai = 2000;
		String titleFragment = "abc";
		String tagSearch = "tagTitle2";

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book1 as result - only match
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItems(book1));
	}
	
	@Test
	public void testSqlInjectionDoesNotWork() {
		// GIVEN 
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12766", "genre3", "tagTitle2");
		saveBooks(book1);

		// WHEN book is searched with all params 

		String nameOrLastname = "'";
		Integer metai = null;
		String titleFragment = "'%'%'";
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect no exception will be throwed.
	}*/
	
	@Test
	@Ignore("Broken test")
	public void testAllCriteriasWorkAsCombinedWithAlternativeVersion() {
		// GIVEN 
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12711", "genre3", "tagTitle2");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12722", "genre2", null);
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12733", "genre3", "myTag");
		Book book4 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abde", "12744", "genre1", null);
		Book book5 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2001, "abcd", "12777", "genre3",null);
		Book book6 = BookDbDataBuildHelper.buildSampleBook("name", "different", 2000, "abcd", "12788", "genre1", null);
		saveBooks(book1, book2, book3, book4, book5, book6);

		// WHEN book is searched with all params 

		String nameOrLastname = "nam";
		Integer metai = 2000;
		String titleFragment = "abc";
		String tagSearch = "tagTitle2";

		List<Book> searchResults = bookRepo.findBooks2(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book1 as result - only match
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItems(book1));
	}
	@Test
	@Ignore("Broken test")
	public void testNoCriteriasWorkWithAlternativeVersion() {
		// GIVEN 
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12811", "genre3", "tagTitle2");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12822", "genre1", null);
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abcd", "12833", "genre5", "myTag");
		Book book4 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2000, "abde", "12844", "genre3", null);
		Book book5 = BookDbDataBuildHelper.buildSampleBook("name", "lastname", 2001, "abcd", "12855", "genre1", null);
		Book book6 = BookDbDataBuildHelper.buildSampleBook("name", "different", 2000, "abcd", "12866", "genre3", null);
		saveBooks(book1, book2, book3, book4, book5, book6);

		// WHEN book is searched with all params 

		String nameOrLastname = null;
		Integer metai = null;
		String titleFragment = null;
		String tagSearch = null;

		List<Book> searchResults = bookRepo.findBooks2(nameOrLastname, metai, titleFragment, tagSearch);

		// THEN we expect book1 as result - only match
		assertThat(searchResults.size(), is(6));
		assertThat(searchResults, hasItems(book1, book2, book3, book4, book5, book6));
	}
	
	@Test
	public void testComplexSearchWithGenres() {
		// GIVEN 3 books match Fantasy Genre, and only 1 book matches by year, book title and author name pattern.
		Book book1 = BookDbDataBuildHelper.buildSampleBook("1name", "lastname", 2000, "abcd", "12711", "Fiction", "tagTitle2");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("2name", "lastname", 2000, "abcd", "12722", "Fantasy", null);
		Book book3 = BookDbDataBuildHelper.buildSampleBook("3name2", "lastname3", 2000, "abcd", "12733", "Fantasy", "myTag");
		Book book4 = BookDbDataBuildHelper.buildSampleBook("4name3", "lastname5", 2000, "abde", "12744", "Fun", null);
		Book book5 = BookDbDataBuildHelper.buildSampleBook("5name", "lastname", 2001, "abcd", "12777", "Romantic",null);
		Book book6 = BookDbDataBuildHelper.buildSampleBook("6name", "different", 2000, "abcd", "12788", "Science", null);
		Book book7 = BookDbDataBuildHelper.buildSampleBook("4name3", "lastname5", 2000, "abde", "12744", "Fantasy", null);
		saveBooks(book1, book2, book3, book4, book5, book6, book7);

		// WHEN book is searched with all params 

		String nameOrLastname = "name3";
		Integer metai = 2000;
		String titleFragment = "abc";
		String genre = "Fantasy";
		List<Book> searchResults = bookRepo.findBook(nameOrLastname, metai, titleFragment, genre);

		// THEN we expect book3 as result - only match
		assertThat(searchResults.size(), is(1));
		assertThat(searchResults, hasItems(book3));
	}
}
