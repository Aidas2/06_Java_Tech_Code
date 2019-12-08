package it.akademija.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.akademija.model.User;

@Repository(value="repoUserDao")
public class DBUserDAO implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> getUsers() {
		return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
	}

	public void createUser(User user) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!iš ");
		entityManager.persist(user);
	}

	public void deleteUser(String username) {
		User user = entityManager.createQuery("SELECT u from User u where username = :un", User.class)
				.setParameter("un", username).getSingleResult();
		if (entityManager.contains(user)) {
			entityManager.remove(user);
		} else {
			entityManager.remove(entityManager.merge(user));
		}
	}
}
