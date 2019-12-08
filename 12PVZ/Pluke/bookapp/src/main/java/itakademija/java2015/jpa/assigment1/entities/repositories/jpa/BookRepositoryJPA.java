package itakademija.java2015.jpa.assigment1.entities.repositories.jpa;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag_;
import itakademija.java2015.jpa.assigment1.entities.Author_;
import itakademija.java2015.jpa.assigment1.entities.Book;
import itakademija.java2015.jpa.assigment1.entities.Book_;
import itakademija.java2015.jpa.assigment1.entities.Genre;
import itakademija.java2015.jpa.assigment1.entities.Genre_;
import itakademija.java2015.jpa.assigment1.entities.repositories.BookRepository;

/**
 * Inconsistent naming for repository/dao Left intentionally for students to get
 * accustomed to interchangeable (almost) terms.
 *
 */
public class BookRepositoryJPA implements BookRepository {

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
	public void insertOrUpdate(Book book) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			boolean merged = false;
			for (AuthorTag t : book.getAuthor().getTags()) {
				if (!entityManager.contains(t) && t.getId() != null) {
					entityManager.merge(t);
					merged = true;
				} else
					entityManager.persist(t);
			}
			if (merged)
				entityManager.merge(book);
			else
				entityManager.persist(book);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(Book book) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(book);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void deleteById(Long bookId) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Book book = entityManager.find(Book.class, bookId);
			if (book != null)
				entityManager.remove(book);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Book> findAllBooks() {
		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Book> cq = cb.createQuery(Book.class);
			Root<Book> rootBook = cq.from(Book.class);
			cq.select(rootBook); // we select entity here
			TypedQuery<Book> q = entityManager.createQuery(cq);
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Book> findByTitleFragment(String titleFragment) {
		EntityManager entityManager = getEntityManager();
		TypedQuery<Book> q;
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Book> cq = cb.createQuery(Book.class);
			Root<Book> bookRoot = cq.from(Book.class);
			cq.select(bookRoot); // we select entity here
			cq.where(cb.like(cb.lower(bookRoot.get(Book_.title)), "%" + titleFragment.toLowerCase() + "%"));
			q = entityManager.createQuery(cq);
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long countAllBooks() {
		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
			countQuery.select(cb.count(countQuery.from(Book.class)));
			TypedQuery<Long> q = entityManager.createQuery(countQuery);
			return q.getSingleResult();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Book findByISBNnumber(String isbnNumber) {
		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Book> cq = cb.createQuery(Book.class);
			Root<Book> bookRoot = cq.from(Book.class);
			cq.select(bookRoot); // we select entity here
			cq.where(cb.equal(bookRoot.get(Book_.isbnNumber), isbnNumber));
			TypedQuery<Book> q = entityManager.createQuery(cq);
			return q.getSingleResult();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Book> findBook(String authorName, Integer releaseYear, String titleWord, String genre) {

		EntityManager em = getEntityManager();
		try {

			List<Predicate> criteria = new ArrayList<Predicate>();
			Predicate predicate = null;
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Book> cq = cb.createQuery(Book.class);
			Root<Book> bookRoot = cq.from(Book.class);
			cq.select(bookRoot);

			if (authorName != null && authorName != "") {
				Path<Author> authorRoot = bookRoot.get(Book_.author);
				predicate = cb.or(cb.like(cb.lower(authorRoot.get(Author_.name)), "%" + authorName.toLowerCase() + "%"),
						cb.like(cb.lower(authorRoot.get(Author_.lastname)), "%" + authorName.toLowerCase() + "%"));
				criteria.add(predicate);
			}

			if (releaseYear != null && releaseYear != 0) {
				Date fromDate = buildFromDate(releaseYear);
				Date tillDate = buildTillDate(releaseYear);

				predicate = cb.between(bookRoot.get(Book_.releaseDate), fromDate, tillDate);
				criteria.add(predicate);
			}

			if (titleWord != null && titleWord != "") {
				predicate = cb.like(bookRoot.get(Book_.title), likeClause(titleWord));
				criteria.add(predicate);
			}

			if (genre != null) {
				ListJoin<Book, Genre> genreJoin = bookRoot.join(Book_.genres);
				predicate = cb.equal(genreJoin.get(Genre_.genre), genre);
				
				criteria.add(predicate);
			}

			Predicate[] predicateArray = criteria.toArray(new Predicate[] {});
			cq.where(cb.and(predicateArray));

			TypedQuery<Book> q = em.createQuery(cq);

			return q.getResultList();

		} finally {
			em.close();
		}
	}

	// @Override
	public List<Book> findBooks3(String nameOrLastname, Integer year, String titleFragment, String tag) {

		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Book> cq = cb.createQuery(Book.class);
			// ... FROM Author a
			Root<Author> authorRoot = cq.from(Author.class);
			// ... FROM Author a JOIN a.books b ...
			ListJoin<Author, Book> bookJoin = authorRoot.join(Author_.books);
			// ... FROM Author a JOIN a.books b LEFT JOIN a.tags t
			ListJoin<Author, AuthorTag> tagJoin = authorRoot.join(Author_.tags, JoinType.LEFT);
			// SELECT b ...
			cq.select(bookJoin); // we select entity here
			List<Predicate> predicates = new ArrayList<>();
			Predicate predicate = null;
			if (nameOrLastname != null) {
				// sujungia:
				// lower(a.name) ...
				// AND
				// lower(a.lastname) ...
				predicate = cb.or(
						// LOWER(a.name) LIKE '%...%'
						cb.like(
								// padaro funkcija:
								// lower(...
								cb.lower(
										// Padaro reference i AUTHOR.name
										// musu atveju: a.name
										authorRoot.get(Author_.name)),
								// sulipdom %tagoreiskme%

								"%" + nameOrLastname.toLowerCase() + "%"),
						// LOWER(a.lastname) LIKE '%...%'
						cb.like(
								// LOWER(...
								cb.lower(
										// a.lastname ...
										authorRoot.get(Author_.lastname)),
								// '%perduotareiksme%'
								"%" + nameOrLastname.toLowerCase() + "%"));
				// rezultate:
				// lower(a.name) like lower('%reiksme%') OR lower(a.lastname)
				// like
				// lower('%reiksme%')
				predicates.add(predicate);
			}
			if (year != null) {
				/**
				 * Standartiniu JPQL funkciju metu 'istraukimui' is datos nera,
				 * todel bandome suktis su tuo kas yra. Perfrazuojame problema.
				 * Jeigu norime patikrinti ar konkreti data yra metu X, galime
				 * sakyti, kad ta data turi buti intervale nuo X metu sausio 1
				 * iki X + 1 metu sausio pirmos (neimtinai)
				 * 
				 */

				Date fromDate = buildFromDate(year);

				Date tillDate = buildTillDate(year);

				predicate =
				// ... BETWEEN ....
				cb.between(
						// b.releaseDate
						bookJoin.get(Book_.releaseDate), fromDate, // '2001-01-01'
						tillDate); // '2002-01-01'
				// rezultate:
				// b.releaseDate BETWEEN '2001-01-01' and '2002-01-01'
				predicates.add(predicate);
			}
			if (titleFragment != null) {
				// .. LIKE ..
				predicate = cb.like(
						// b.title
						bookJoin.get(Book_.title), likeClause(titleFragment));

				// rezultate:
				// b.title LIKE '%titleReiksme%'
				predicates.add(predicate);
			}
			if (tag != null) {
				predicate =
				// .. = ..
				cb.equal(
						// t.tag
						tagJoin.get(AuthorTag_.tag),
						// kintamojo reiksme, sakykim "premium"
						tag);
				// rezultatas:
				// t.tag = 'premium'
				predicates.add(predicate);
			}
			/**
			 * cb.adn(...) metodas priima tik masyvo tipa, todel List
			 * konvertuojame i masyva
			 **/
			Predicate[] predicateArray = predicates.toArray(new Predicate[] {});
			cq.where( // Sis iskvietimas pradeda WHERE bloko aprasyma
					cb.and(predicateArray) // sitas kvietimas ima predikatus
											// (palyginimo israiskas)
											// ir visas jas sujungia AND
											// jungtuku
			/**
			 * Pvz, jei perduodame predikata "salary > 5" ir predikata
			 * "name = 'Vardenis'", rezultatas bus: salary > 5 AND name =
			 * 'Vardenis' Kiek bus perduota elementu - tiek ir bus ju sujungta.
			 * Musu atveju i sarasa predikatas patenka tik tada, kai parametras
			 * yra ne null.
			 */
			);
			TypedQuery<Book> q = entityManager.createQuery(cq);
			// Sitoje vietoje turime toki sukonstruota mazdaug toki JPQL query:
			// (Reiksmes sudejau del vaizdumo, tikram sql'e bus klaustukai...)
			// taip atrodys uzklausa, su salyga, kad visi parametrai buvo ne
			// null
			// jei kazkas null - tiesiog tos AND dalies nebus.
			/**
			 * SELECT b FROM Author a JOIN a.books b LEFT JOIN a.tags t WHERE
			 * (lower(a.name) like lower('%reiksme%') OR lower(a.lastname) like
			 * lower('%reiksme%')) AND (b.releaseDate BETWEEN '2001-01-01' and
			 * '2002-01-01') AND (b.title LIKE '%titleReiksme%') AND (t.tag =
			 * 'premium')
			 **/
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Demo kaip formuoti tiesiai SQL WARNING: netestuota, cia tik koncepcija.
	 * 
	 */
	@Override
	public List<Book> findBooks2(String nameOrLastname, Integer year, String titleFragment, String tag) {
		String jpql = "SELECT b FROM Author a JOIN a.books b LEFT JOIN a.tags t ";
		String whereClause = "";
		if (nameOrLastname != null) {
			if (!whereClause.isEmpty())
				whereClause += " AND ";
			whereClause += "(lower(a.name) like lower(:name) OR lower(a.lastname) like lower(:name2))";
		}

		if (year != null) {
			if (!whereClause.isEmpty())
				whereClause += " AND ";
			whereClause += "(b.releaseDate BETWEEN :since and :till)";
		}
		if (titleFragment != null) {
			if (!whereClause.isEmpty())
				whereClause += " AND ";
			whereClause += "(b.title LIKE :title)";
		}
		if (tag != null) {
			if (!whereClause.isEmpty())
				whereClause += " AND ";
			whereClause += "t.tag = :tag)";
		}
		if (!whereClause.isEmpty())
			whereClause = "WHERE  " + whereClause;
		jpql += whereClause;

		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Book> q = entityManager.createQuery(jpql, Book.class);
			// ir t.t. - visus parametrus sudedam priklausomai nuo to ar jie
			// itraukti i uzklausa.
			if (titleFragment != null)
				q.setParameter("title", likeClause(titleFragment));
			if (nameOrLastname != null) {
				q.setParameter("name", likeClause(nameOrLastname));
				q.setParameter("name2", likeClause(nameOrLastname));
			}
			if (year != null) {
				Date fromDate = buildFromDate(year);

				Date tillDate = buildTillDate(year);
				q.setParameter("since", fromDate);
				q.setParameter("till", tillDate);
			}
			if (tag != null) {
				q.setParameter("tag", tag);
			}
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	private Date buildTillDate(Integer year) {
		Instant till = LocalDateTime.of(year + 1, 1, 1, 0, 0).toInstant(ZoneOffset.UTC);
		Date tillDate = Date.from(till);
		return tillDate;
	}

	private Date buildFromDate(Integer year) {
		Instant since = LocalDateTime.of(year, 1, 1, 0, 0).toInstant(ZoneOffset.UTC);
		Date fromDate = Date.from(since);
		return fromDate;
	}

	private String likeClause(String field) {
		return "%" + field + "%";
	}

}
