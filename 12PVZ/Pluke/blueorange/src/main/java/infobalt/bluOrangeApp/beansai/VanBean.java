package infobalt.bluOrangeApp.beansai;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import infobalt.bluOrangeApp.entities.Train;
import infobalt.bluOrangeApp.entities.Van;
import infobalt.bluOrangeApp.entities.repositories.TrainRepository;
import infobalt.bluOrangeApp.entities.repositories.VanRepository;

public class VanBean {
	
	public static final String NAV_LIST_TRAINS = "list-trains";
	
	static final Logger log = LoggerFactory.getLogger(VanBean.class);
	
	private String colorIn = "fieldIn";
	private String colorOut = "fieldOut";
	private String textColor = "textColor";
	
	private VanRepository vanRepo;
	private TrainRepository trainRepo;
	private TrainBean trainBean;
	
	@Valid
	private Van newVan;
	
	@Valid
	private Train currentTrain;
	
	public void init() {
		newVan = new Van();
		currentTrain = trainBean.getNewTrain();
	}

		public Train getCurrentTrain() {
			return currentTrain;
		}

		public void setCurrentTrain(Train currentTrain) {
			this.currentTrain = currentTrain;
		}

		public VanRepository getVanRepo() {
			return vanRepo;
		}

		public void setVanRepo(VanRepository vanRepo) {
			this.vanRepo = vanRepo;
		}

		public Van getNewVan() {
			return newVan;
		}

		public void setNewVan(Van newVan) {
			this.newVan = newVan;
		}
		
		public TrainRepository getTrainRepo() {
			return trainRepo;
		}

		public void setTrainRepo(TrainRepository trainRepo) {
			this.trainRepo = trainRepo;
		}

		public TrainBean getTrainBean() {
			return trainBean;
		}

		public void setTrainBean(TrainBean trainBean) {
			this.trainBean = trainBean;
		}
		
		public String addOrUpdateVan() {
			newVan.calculateFinalPrice();
			if(newVan.getTrain() == null){
				Train train = trainBean.getNewTrain();
				log.debug("Before saving van, got Train: {}", train);
				log.debug("New van data: {}", newVan);
				newVan.setTrain(train);
				train.addVan(newVan);
				trainRepo.saveOrUpdateTrain(train);	
			}
			else {
				vanRepo.updateVan(newVan);
			}
			
			return TrainBean.NAV_SHOW_ADD_VAN;
		}
		
		public String deleteSelectedVan(Long vanId) {
			if (vanId == null){
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Item being deleted is null?"));
			}
			else {
				if (vanId != null){
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "You are deleting " + vanId + " item"));
				}
				vanRepo.deleteById(vanId);
			}
			return TrainBean.NAV_SHOW_ADD_VAN;
		}
		
		public List<Van> getTrainVans() {
			return trainRepo.findTrainByNumber(currentTrain.getTrainNumber()).getVans();
		}
		
		
		public void editVan(Van van) {
			this.newVan = van;
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
