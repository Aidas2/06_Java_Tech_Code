
package lt.vtvpmc.exam.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lt.vtvpmc.exam.entities.Client;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


public class ClientListBean {
	
	static final Logger logger = LoggerFactory.getLogger(ClientListBean.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    private BarChartModel barModel;
    
    @Transactional(readOnly = true)
    public List<Client> getClientList() {
        Query q = entityManager.createQuery("select c from Client c");
        logger.info("All client list returned");
        return q.getResultList();
    }
    
    @Transactional
    public String removeClient(Client client) {
        entityManager.remove(entityManager.merge(client));
        logger.info("Client removed");
        return "main";
    }
    
    @Transactional
    public List<Client> getCriticsList(){
    	Query q = entityManager.createQuery ("select client from Survey s where s.surveyDate =(select max(surveyDate) from Survey s2 where s2.id=s.id) and s.value <=6");
    	logger.info("Critics list returend");
    	return q.getResultList();
    }
    
    @Transactional
    public List<Client> getNeutralList(){
    	Query q = entityManager.createQuery ("select client from Survey s where s.surveyDate =(select max(surveyDate) from Survey s2 where s2.id=s.id) and s.value between 7 and 8");
    	logger.info("Neutrals list returend");
    	return q.getResultList();
    }
    
    @Transactional
    public List<Client> getPromotersList(){
    	Query q = entityManager.createQuery ("select client from Survey s where s.surveyDate =(select max(surveyDate) from Survey s2 where s2.id=s.id) and s.value between 9 and 10");
    	logger.info("Promoters list returend");
    	return q.getResultList();
    }
    
    public void updateGrowl() {
        Long clientCount = Long.valueOf(getClientList().size());
        if (clientCount < 2) {
            FacesMessage warningMessage = new FacesMessage("At least 2 customers are required");
            FacesContext.getCurrentInstance().addMessage(null, warningMessage);
        }
    }

	public BarChartModel getBarModel() {
		createChartBar();
		return barModel;
	}
	
	private void createChartBar() {
        createBarModel();
        logger.info("Bar chart model created");
	}

	 private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	 
	        ChartSeries critics = new ChartSeries();
	        critics.setLabel("Critics");
	        critics.set("critics", getCriticsList().size());
	       
	 
	        ChartSeries neutrals = new ChartSeries();
	        neutrals.setLabel("Neutrals");
	        neutrals.set("neutrals", getNeutralList().size());
	        
	        ChartSeries promoters = new ChartSeries();
	        promoters.setLabel("Promoters");
	        promoters.set("promoters", getPromotersList().size());
	        
	 
	        model.addSeries(critics);
	        model.addSeries(neutrals);
	        model.addSeries(promoters);
	         
	        return model;
	    }
	 
	 private void createBarModel() {
	        barModel = initBarModel();
	         
	        barModel.setTitle("Customers type chart");
	        barModel.setLegendPosition("ne");
	         
	        Axis xAxis = barModel.getAxis(AxisType.X);
	        xAxis.setLabel("Type");
	         
	        Axis yAxis = barModel.getAxis(AxisType.Y);
	        yAxis.setLabel("Number of answers");
	        yAxis.setMin(0);
	        yAxis.setMax(20);
	    }
	     
    
}
