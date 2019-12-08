package lt.vtvpmc.exam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Survey implements Serializable {
	
	private static final long serialVersionUID = 5583853763074630122L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
    private Long id;
	
	@Column (name = "question")
	private String question;
	
	@Column (name = "client_evaluation")
	private int value;
	
	@Column (name = "survey_date")
	@Temporal(TemporalType.DATE)
    private Date surveyDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Survey(){
	}

	public Survey(Client client, Date surveyDate, String question, int value) {
		this.client = client;
		this.surveyDate = surveyDate;
		this.question = question;
		this.value = value;
	}
	
	@Override
    public String toString() {
        return ("survey id: " + id + " answered by: " + client.getFirstName() + " " + client.getLastName()
        		+ " evaluation is " + value);
    }

}
