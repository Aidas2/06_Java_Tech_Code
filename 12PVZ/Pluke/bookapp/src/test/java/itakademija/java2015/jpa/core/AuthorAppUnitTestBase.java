package itakademija.java2015.jpa.core;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.repositories.AuthorRepository;
import itakademija.java2015.jpa.assigment1.entities.repositories.BookRepository;
import itakademija.java2015.jpa.assigment1.entities.repositories.jpa.AuthorDaoImpl;
import itakademija.java2015.jpa.assigment1.entities.repositories.jpa.BookRepositoryJPA;

public class AuthorAppUnitTestBase {
	static final Logger log = LoggerFactory.getLogger(AuthorAppUnitTestBase.class);
	private static EntityManagerFactory factory;
	private EntityManager entityManager;
	protected BookRepository bookRepo;
	protected AuthorRepository authorRepo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {

//			Persistence.generateSchema("bookReviewDb", null);
		}
		catch (Exception e) {
			log.warn("Failed to generate schema. Could be generated already");
		}
		factory = Persistence.createEntityManagerFactory("bookReviewDb");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
		if (factory != null && factory.isOpen())
			factory.close();
	}

	public AuthorAppUnitTestBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		entityManager = factory.createEntityManager();
		bookRepo = new BookRepositoryJPA();
		((BookRepositoryJPA) bookRepo).setEntityManagerFactory(factory);
	
		authorRepo = new AuthorDaoImpl();
		((AuthorDaoImpl) authorRepo).setEntityManagerFactory(factory);
	
		AuthorDbTestingHelper.deleteAllBooks(entityManager);
		AuthorDbTestingHelper.deleteAllAuthors(entityManager);
		AuthorDbTestingHelper.deleteAllTags(entityManager);
		AuthorDbTestingHelper.deleteAllGenres(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		if (entityManager.isOpen())
			entityManager.close();
	}

	void updateTagsFromDBIfExisting(Book b) {
		AuthorTag currTag = null;
		List<AuthorTag> l = b.getAuthor().getTags();
		Iterator<AuthorTag> I = l.iterator();
		while( I.hasNext())
		{
			currTag = I.next();
			AuthorTag tagFromDb = authorRepo.findTag(currTag.getTag());
			if (tagFromDb != null) {
				l.remove(currTag);
				l.add(tagFromDb);
			}
		}
	}
	protected void saveBooks(Book... booklist) {
		for (Book b : booklist) {
			updateTagsFromDBIfExisting(b);
			// If we create NEW tag with same tagstring- this will create unique constraint violation
			// for this we need re-use existing tag.
			bookRepo.insertOrUpdate(b);
		}
	}

}