package infobalt.bluOrangeApp.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import infobalt.bluOrangeApp.entities.Van;
import infobalt.bluOrangeApp.entities.repositories.VanRepository;

public class VanRepJPA implements VanRepository {
	
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
	public void updateVan(Van van) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			if (van.getTrain() != null)
				entityManager.merge(van);
			entityManager.getTransaction().commit();
		
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(Van van) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(van);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void deleteById(Long vanId) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Van van = entityManager.find(Van.class, vanId);
			if (van != null)
				entityManager.remove(van);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public List<Van> findAllVans() {
		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Van> cq = cb.createQuery(Van.class);
			Root<Van> rootVan = cq.from(Van.class);
			cq.select(rootVan); 
			TypedQuery<Van> q = entityManager.createQuery(cq);
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Van findVanById(Long vanId) {
		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Van> vanQuery = entityManager.createQuery("SELECT v From Van v WHERE v.vanId = :vanId",
					Van.class);
			vanQuery.setParameter("vanId", vanId);

			return vanQuery.getSingleResult();
		} finally {
			entityManager.close();
		}
	}
}
