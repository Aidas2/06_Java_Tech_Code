package infobalt.bluOrangeApp.entities.repositories;

import java.util.List;

import infobalt.bluOrangeApp.entities.Train;


public interface TrainRepository {
	
	public void saveOrUpdateTrain(Train newTrain);
	public List<Train> findAllTrains();
	public void deleteTrain(Train train);
	public void deleteByNumber(Long trainNumber);
	public Train findTrainByNumber(Long trainNumber);
}
