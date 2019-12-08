package infobalt.bluOrangeApp.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import infobalt.bluOrangeApp.entities.Train;
import infobalt.bluOrangeApp.entities.repositories.TrainRepository;

public class TrainRepJPA implements TrainRepository {
	static final Logger log = LoggerFactory.getLogger(TrainRepJPA.class);

	private EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}
	
	private EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	
	@Override
	public void saveOrUpdateTrain(Train newTrain) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			if (newTrain.getTrainNumber() != null)
				entityManager.merge(newTrain);
			else
				entityManager.persist(newTrain);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void deleteTrain(Train train) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			train = entityManager.merge(train);
			entityManager.remove(train);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	@Override
	public List<Train> findAllTrains() {
		EntityManager entityManager = getEntityManager();
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Train> cq = cb.createQuery(Train.class);
			Root<Train> rootTrain = cq.from(Train.class);
			cq.select(rootTrain); 
			TypedQuery<Train> q = entityManager.createQuery(cq);
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public void deleteByNumber(Long trainNumber) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Train train = entityManager.find(Train.class, trainNumber);
			if (train != null)
				entityManager.remove(train);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Train findTrainByNumber(Long trainNumber) {
		System.out.println("looking for train: " + trainNumber.toString());
		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Train> trainQuery = entityManager.createQuery("SELECT t From Train t WHERE t.trainNumber = :trainNumber",
					Train.class);
			trainQuery.setParameter("trainNumber", trainNumber);

			return trainQuery.getSingleResult();
		} finally {
			entityManager.close();
		}
	}
}
