package itakademija.java2015.jpa.core;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.Genre;

public class AuthorDbTestingHelper {
	static final Logger log = LoggerFactory.getLogger(AuthorDbTestingHelper.class);
	
	static void deleteAllBooks(EntityManager em) {
		log.debug("Deleting all books from DB!");
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
	
			CriteriaDelete<Book> deleteQuery = cb.createCriteriaDelete(Book.class);
			deleteQuery.from(Book.class);
			Query q = em.createQuery(deleteQuery);
	
			q.executeUpdate();
	
			em.getTransaction().commit();
		} catch (SecurityException | IllegalStateException | RollbackException e) {
			e.printStackTrace();
		}
	}

	static void deleteAllTags(EntityManager em) {
		log.debug("Deleting all tags from DB!");
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
	
			CriteriaDelete<AuthorTag> deleteQuery = cb.createCriteriaDelete(AuthorTag.class);
			deleteQuery.from(AuthorTag.class);
			Query q = em.createQuery(deleteQuery);
	
			q.executeUpdate();
	
			em.getTransaction().commit();
		} catch (SecurityException | IllegalStateException | RollbackException e) {
			e.printStackTrace();
		}
	}

	static void deleteAllAuthors(EntityManager em) {
		log.debug("Deleting all authors from DB!");
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
	
			CriteriaDelete<Author> deleteQuery = cb.createCriteriaDelete(Author.class);
			deleteQuery.from(Author.class);
			Query q = em.createQuery(deleteQuery);
	
			q.executeUpdate();
	
			em.getTransaction().commit();
		} catch (SecurityException | IllegalStateException | RollbackException e) {
			e.printStackTrace();
		}
	}
	
	static void deleteAllGenres(EntityManager em) {
		log.debug("Deleting all genres from DB!");
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
		    CriteriaDelete<Genre> deleteQuery = cb.createCriteriaDelete(Genre.class);
		    deleteQuery.from(Genre.class);
			Query q = em.createQuery(deleteQuery);

			q.executeUpdate();

		    em.getTransaction().commit();
		} catch (SecurityException | IllegalStateException | RollbackException e) {
		    e.printStackTrace();
		}
	}

	// search finds correct number of results
	// search finds matching data
	// search does not return non-matching data
	// search finds results which have multiple tags
	
	@SafeVarargs
	public
	static Boolean allAuthorsFound(List<Author> searchResults, Predicate<Author> ... preds) {
		Boolean ret = null;
		for (Predicate<Author> p: preds) { 
			boolean found = searchResults.stream().anyMatch(p);
			if (ret == null)
				ret = found;
			else
				ret &= found;
			if (ret == false)
				break;
		}
		return ret;
	}

	public static Predicate<Author> byName(String name, String lastname) {
		
		Predicate<Author> res = new Predicate<Author>() {
			@Override
			public boolean test(Author t) {
				if (t == null)
					return false;
				if (name == null && t.getName() != null)
					return false;
				if (name != null && t.getName() == null)
					return false;
				if (!t.getName().equals(name))
					return false;
				
				if (lastname == null && t.getLastname() != null)
					return false;
				if (lastname != null && t.getLastname() == null)
					return false;
				if (!t.getLastname().equals(lastname))
					return false;
				
				return true;
			}
		};
		return res;
	}
	
}