package itakademija.java2015.jpa.assigment1.entities.repositories.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.repositories.GenreRepository;

public class GenreRepositoryJPA implements GenreRepository {
	
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	private EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public Collection<Book> findBookByGenre(String genre) {
		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Book> bookByGenreQuery = entityManager
					.createQuery("SELECT b From Book b join b.genres g WHERE g.genre = :genre", Book.class);
			bookByGenreQuery.setParameter("genre", genre);
			return bookByGenreQuery.getResultList();
		} finally {
			entityManager.close();
		}
	}

}
