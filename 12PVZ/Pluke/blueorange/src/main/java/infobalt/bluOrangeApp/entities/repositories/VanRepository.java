package infobalt.bluOrangeApp.entities.repositories;
import java.util.List;

import infobalt.bluOrangeApp.entities.Van;

public interface VanRepository {
	
	public void updateVan(Van van);
	public void delete(Van van);
	public void deleteById(Long vanId);
	public List<Van> findAllVans();
	public Van findVanById(Long vanId);
}
