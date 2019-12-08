package lt.svs.services;

import java.util.List;
import java.util.stream.Collectors;

import lt.svs.dto.CreateInventorDTO;
import lt.svs.dto.ReturnInventorDTO;
import lt.svs.entities.Inventor;
import lt.svs.repositories.InventorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventorService {
	
	@Autowired
	private InventorRepository inventorRepository;

	@Autowired
	public InventorService(InventorRepository inventorRepository) {
		super();
		this.inventorRepository = inventorRepository;
	}

	
	//GET ALL ------------------------------------------------------------
	@Transactional(readOnly = true)
	public List <ReturnInventorDTO> getAllInventors() {
		return inventorRepository.findAll()
				.stream()
				.map((inventor) -> new ReturnInventorDTO(
						inventor.getId(),
						inventor.getTitle(),
						inventor.getWeight(),
						inventor.getNumberOfSector(),
						inventor.getPlacementDate()
						//inventor.getCustomersList()
						))
				.collect(Collectors.toList());
	}
	
	//GET BY TITLE ------------------------------------------------------------
	@Transactional(readOnly = true)
	public ReturnInventorDTO findCInventorByTitle(String title) {
		Inventor inventorToGet = inventorRepository.findInventorByTitle(title);
		return new ReturnInventorDTO(
				inventorToGet.getId(),
				inventorToGet.getTitle(),
				inventorToGet.getWeight(),
				inventorToGet.getNumberOfSector(),
				inventorToGet.getPlacementDate());
				//inventorToGet.getCustomersList());
	}
	
	//CREATE ------------------------------------------------------------
	@Transactional
	public void createInventor(CreateInventorDTO createInventorDTO) {
		Inventor newInventor = new Inventor(
				createInventorDTO.getTitle(),
				createInventorDTO.getWeight(),
				createInventorDTO.getNumberOfSector(),
				createInventorDTO.getPlacementDate());
				//createInventorDTO.getCustomersList());
		inventorRepository.save(newInventor);
	}
	
	//UPDATE ------------------------------------------------------------
	@Transactional
	public void updateInventor(String title, CreateInventorDTO createInventorDTO) {
		Inventor inventorToUpdate = inventorRepository.findInventorByTitle(title);

		inventorToUpdate.setTitle(createInventorDTO.getTitle());
		inventorToUpdate.setWeight(createInventorDTO.getWeight());
		inventorToUpdate.setNumberOfSector(createInventorDTO.getNumberOfSector());
		inventorToUpdate.setPlacementDate(createInventorDTO.getPlacementDate());
		//inventorToUpdate.setCustomersList(createInventorDTO.getCustomersList());

		inventorRepository.save(inventorToUpdate);
	}
	
	// DELETE ------------------------------------------------------------
	@Transactional
	public void deleteInventor(String title) {
		inventorRepository.deleteInventorByTitle(title);
	}


}
