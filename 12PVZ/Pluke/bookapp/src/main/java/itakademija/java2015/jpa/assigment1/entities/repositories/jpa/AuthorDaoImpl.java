package itakademija.java2015.jpa.assigment1.entities.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag_;
import itakademija.java2015.jpa.assigment1.entities.Author_;
import itakademija.java2015.jpa.assigment1.entities.repositories.AuthorRepository;

/**
 * Inconsistent naming for repository/dao Left intentionally for students to get
 * accustomed to interchangeable (almost) terms.
 *
 */
public class AuthorDaoImpl implements AuthorRepository {
	static final Logger log = LoggerFactory.getLogger(AuthorDaoImpl.class);

	private EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}

	@Override
	public Author findFirstByName(String name) {

		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Author> authorQuery = entityManager.createQuery("SELECT a From Author a WHERE a.name = :name",
					Author.class);
			authorQuery.setParameter("name", name);
			authorQuery.setMaxResults(1);

			return authorQuery.getSingleResult();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Author findFirstByNameAlternative(String name) {

		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Author> cq = cb.createQuery(Author.class);
			Root<Author> root = cq.from(Author.class);
			cq.select(root); // we select entity here
			cq.where(cb.equal(root.get(Author_.name), name));
			TypedQuery<Author> q = entityManager.createQuery(cq);
			q.setMaxResults(1);
			return q.getSingleResult();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Author> findAll() {

		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Author> cq = cb.createQuery(Author.class);
			Root<Author> root = cq.from(Author.class);
			cq.select(root); // we select entity here
			TypedQuery<Author> q = entityManager.createQuery(cq);
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void save(Author newAuthor) {

		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (!entityManager.contains(newAuthor))
				newAuthor = entityManager.merge(newAuthor);
			entityManager.persist(newAuthor);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(Author author) {

		EntityManager entityManager = getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			author = entityManager.merge(author);
			entityManager.remove(author);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public AuthorTag findTag(String tag) {

		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<AuthorTag> cq = cb.createQuery(AuthorTag.class);
			Root<AuthorTag> queryRoot = cq.from(AuthorTag.class);
			cq.select(queryRoot); // we select entity here
			cq.where(cb.equal(queryRoot.get(AuthorTag_.tag), tag));
			TypedQuery<AuthorTag> q = entityManager.createQuery(cq);
			try {
				return q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Author> findAllAuthorsByTag(String tag) {
		String jpql = "SELECT a FROM Author a JOIN a.tags t WHERE t.tag = :searchTag";

		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
			query.setParameter("searchTag", tag);
			return query.getResultList();
		} finally {
			entityManager.close();
		}
	}

	private EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}