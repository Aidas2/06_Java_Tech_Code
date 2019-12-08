package infobalt.bluOrangeApp.beansai;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import infobalt.bluOrangeApp.entities.Train;
import infobalt.bluOrangeApp.entities.repositories.TrainRepository;


public class TrainBean {
	public static final String NAV_SHOW_ADD_VAN = "show-add-van";
	public static final String NAV_LIST_TRAINS = "list-trains";
	
	static final Logger log = LoggerFactory.getLogger(TrainBean.class);
	
	private String colorIn = "fieldIn";
	private String colorOut = "fieldOut";
	private String textColor = "textColor";
	
	private TrainRepository trainRepo;
	
	@Valid
	private Train newTrain;
	
	public void init() {
		newTrain = new Train();
	}
	
	public void editTrain(Train train) {
		this.newTrain = train;
	}
	
	public String addNewTrain() {
		trainRepo.saveOrUpdateTrain(newTrain);
		newTrain = new Train(); 
		
		return NAV_LIST_TRAINS;
	}
	
	public String deleteSelectedTrain(Long trainNumber) {
		System.out.println(trainNumber);
		if (trainNumber == null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Train being deleted is null?"));
		}
		else {
			if (trainNumber != null){
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "You are deleting " + trainNumber + " train"));
			}
			trainRepo.deleteByNumber(trainNumber);
		}
		return NAV_LIST_TRAINS;
	}
	
	public TrainRepository getTrainRepo() {
		return trainRepo;
	}

	public void setTrainRepo(TrainRepository trainRepo) {
		this.trainRepo = trainRepo;
	}

	public Train getNewTrain() {
		return newTrain;
	}

	public void setNewTrain(Train newTrain) {
		this.newTrain = newTrain;
	}
	
	public String showAddVanPage(Train train) {
		log.debug("Will store selected train for later access in Add new Merhcandise form: {}", train);
		this.newTrain = train;
		return NAV_SHOW_ADD_VAN;
	}

	public String getColorIn() {
		return colorIn;
	}

	public void setColorIn(String colorIn) {
		this.colorIn = colorIn;
	}

	public String getColorOut() {
		return colorOut;
	}

	public void setColorOut(String colorOut) {
		this.colorOut = colorOut;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
}
