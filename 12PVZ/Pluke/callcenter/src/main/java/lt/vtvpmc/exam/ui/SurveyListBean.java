package lt.vtvpmc.exam.ui;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import lt.vtvpmc.exam.entities.Client;
import lt.vtvpmc.exam.entities.Survey;

public class SurveyListBean {
	
	static final Logger logger = LoggerFactory.getLogger(SurveyListBean.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
    public void removeSurvey(Survey survey) {
		Client client = survey.getClient();
		client.getSurveys().remove(survey);
		entityManager.persist(findClientById(client.getId()));
        entityManager.remove(entityManager.merge(survey));
        logger.info("Survey removed");
    }
	
	@Transactional(readOnly = true)
    public List<Survey> getAllSurvey() {
        Query q = entityManager.createQuery("select s from Survey s");
        logger.info("All surveys returned");
        return q.getResultList();
    }
	
	@Transactional
	public List<Survey> findAllSurveysByClient(Client client) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Survey> cq = cb.createQuery(Survey.class);
            Root<Survey> root = cq.from(Survey.class);
            cq.select(root);
            cq.where(cb.equal(root.get("client"), client));
            TypedQuery<Survey> q = entityManager.createQuery(cq);
            logger.info("Client's survey returend");
            return q.getResultList();
        } finally {
            entityManager.close();
        }
	}
	
	@Transactional(readOnly = true)
    public List<Survey> getSurveyByClient(Client client) {
        Query q = entityManager.createQuery("select s from Survey s where s.client=:client");
        q.setParameter("client", client);
        logger.info("Client's survey returend");
        return q.getResultList();
    }
	
	@Transactional
	public Double findAverageAnswer() {
		Query q = entityManager.createQuery("select avg(value) from Survey s where s.surveyDate =(select max(surveyDate) from Survey s2 where s2.id=s.id)");
		logger.info("Average of all latest answers counted");
		return (Double) q.getSingleResult();
	}
	
	public void updateGrowl() {
        Long surveyCount = Long.valueOf(getAllSurvey().size());
        if (surveyCount == null || surveyCount == 0) {
            FacesMessage warningMessage = new FacesMessage("There are no surveys done for this customer yet");
            FacesContext.getCurrentInstance().addMessage(null, warningMessage);
        }
    }
	
	private Client findClientById(Long id) {
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Client> cq = cb.createQuery(Client.class);
			Root<Client> root = cq.from(Client.class);
			cq.where(cb.equal(root.get("id"), id));
			TypedQuery<Client> q = entityManager.createQuery(cq);
			return q.getSingleResult();
		} finally {
			entityManager.close();
		}
	}
	

}
