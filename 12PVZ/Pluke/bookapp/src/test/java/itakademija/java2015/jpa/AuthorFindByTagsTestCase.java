/*package itakademija.java2015.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.core.AuthorAppUnitTestBase;
import itakademija.java2015.jpa.core.AuthorDbTestingHelper;
import itakademija.java2015.jpa.core.BookDbDataBuildHelper;

public class AuthorFindByTagsTestCase extends AuthorAppUnitTestBase {

	static final Logger log = LoggerFactory.getLogger(AuthorFindByTagsTestCase.class);

	@Test
	// search finds correct number of results
	public void testFindAllAuthorsByTag() {
		// GIVEN 3 books (+3 authors) with 2 of them tagged "awesome" saved in DB
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name1", "lastname1", 2000, "abcd", "12387", "genre1", "awesome");
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2000, "abcd", "24563", "genre2", "awesome");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name3", "lastname3", 2000, "abcd", "34690", "genre3", "sad");
		saveBooks(book1, book2, book3);
		
		// WHEN we search for authors tagged "awesome"
		String tag = "awesome";
		
		// THEN
		// we expect 2 results returned containing 
		List<Author> searchResults = authorRepo.findAllAuthorsByTag("awesome");
		assertThat(searchResults.size(), is(2));
		
		assertTrue(AuthorDbTestingHelper.allAuthorsFound(searchResults, 
				AuthorDbTestingHelper.byName("name1", "lastname1"),
				AuthorDbTestingHelper.byName("name2", "lastname2")));
		
	}
	// search finds correct number of results
	// search finds matching data
	// search does not return non-matching data
	@Test
	public void testFindAuthorsWithMultipleTagsByTag() {
		// GIVEN 1 book has 3 TAGS with search needle in the middle
		Book book1 = BookDbDataBuildHelper.buildSampleBook("name1", "lastname1", 2000, "abcd", "72387", "genre1", "awesome");
		List<AuthorTag> tags = book1.getAuthor().getTags();
		
		AuthorTag tag1 = new AuthorTag();
		tag1.setTag("super");
		tags.add(0, tag1);
		
		AuthorTag tag2 = new AuthorTag();
		tag2.setTag("bad");
		tags.add(tag2);
		
		
		
		Book book2 = BookDbDataBuildHelper.buildSampleBook("name2", "lastname2", 2000, "abcd", "987", "genre2", "black");
		Book book3 = BookDbDataBuildHelper.buildSampleBook("name3", "lastname3", 2000, "abcde", "6543", "genre3", "sad");
		saveBooks(book1, book2, book3);
		
		// WHEN we search for authors tagged "awesome"
		List<Author> searchResults = authorRepo.findAllAuthorsByTag("awesome");
		
		// THEN
		// we expect 1 result returned containing first author 
		assertThat(searchResults.size(), is(1));
		
		assertTrue(AuthorDbTestingHelper.allAuthorsFound(searchResults, 
				AuthorDbTestingHelper.byName("name1", "lastname1")
				));
		
	}
}
*/