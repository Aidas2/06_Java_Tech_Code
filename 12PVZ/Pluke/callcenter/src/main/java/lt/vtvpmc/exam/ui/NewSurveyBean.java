package lt.vtvpmc.exam.ui;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import lt.vtvpmc.exam.entities.Client;
import lt.vtvpmc.exam.entities.Survey;

public class NewSurveyBean {
	
	static final Logger logger = LoggerFactory.getLogger(NewSurveyBean.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	private Client client;
	private Date surveyDate;
	private String question;
	private int value;
	
	@Transactional
    public String saveSurvey(Client client) {
		client = findClientById(client.getId());
		this.client = client;
        Survey survey = new Survey(client, surveyDate, question, value);
        entityManager.persist(survey);
        client.getSurveys().add(survey);
        entityManager.persist(client);
        logger.info("New survey created for the client");
        return "addSurvey";
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
