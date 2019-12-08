package lt.akademijait.warehouse.inventory.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import lt.akademijait.warehouse.inventory.model.Inventory;
import lt.akademijait.warehouse.inventory.model.InventoryData;
import lt.akademijait.warehouse.security.payload.ApiResponse;

@Service
@Slf4j
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	// Inventorių nuskaitymas
	@Transactional(readOnly = true)
	public List<InventoryData> getFullListOfInventory() {
		return inventoryRepository.findAll().stream()
				.map((inventory) -> new InventoryData(inventory.getInventoryCode(),
				inventory.getInventoryTitle(), inventory.getInventoryWeigth(), inventory.getInventorySector(),
				inventory.getDateOfPlacement()))
				.collect(Collectors.toList());
	}

	// Vieno inventoriaus nuskaitymas
	@Transactional(readOnly = true)
	public InventoryData findInventoryByInventoryCode(String inventoryCode) {
		Inventory currentInventory = inventoryRepository.findByInventoryCode(inventoryCode);
		InventoryData inventoryToController = new InventoryData(currentInventory.getInventoryCode(), currentInventory.getInventoryTitle(),
				currentInventory.getInventoryWeigth(), currentInventory.getInventorySector(), currentInventory.getDateOfPlacement());
		return inventoryToController;
	}

	// Naujo inventoriaus sukūrimas
	@Transactional
	public ResponseEntity<?> createInventory(String inventoryTitle, double inventoryWeigth, int inventorySector,
			LocalDate dateOfPlacement) {
		// Patikrinu ar tokiu pavadinimu šalis jau egzistuoja
		if (inventoryRepository.existsByInventoryTitle(inventoryTitle)) {
			return new ResponseEntity<>(new ApiResponse(false, "Inventory with such title already exists"),
					HttpStatus.BAD_REQUEST);
		}

		// 1.Sugeneruoju atsitiktinę eilutę iš 7 simbolių
		String InventoryCode = RandomStringUtils.random(7, true, true) + "_" + inventoryTitle.replaceAll("\\s+", "");
		Inventory newInventory = new Inventory(InventoryCode, inventoryTitle, inventoryWeigth, inventorySector, dateOfPlacement);
		Inventory result = inventoryRepository.save(newInventory);
		log.info("A new inventory (" + inventoryTitle + ") has been created");
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/inventories/{inventoryCode}")
				.buildAndExpand(result.getInventoryCode()).toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "Inventory created successfully"));
	}

	// Esamo inventoriaus duomenų pakeitimas
	@Transactional
	public void updateInventory(String inventoryCode, String inventoryTitle, double inventoryWeigth, int inventorySector,
			LocalDate dateOfPlacement) {
		
		Inventory inventoryToUpdate = inventoryRepository.findByInventoryCode(inventoryCode);
		inventoryToUpdate.setInventoryTitle(inventoryTitle);
		inventoryToUpdate.setInventoryWeigth(inventoryWeigth);
		inventoryToUpdate.setInventorySector(inventorySector);
		inventoryToUpdate.setDateOfPlacement(dateOfPlacement);
		inventoryRepository.save(inventoryToUpdate);
		log.info("Inventory (" + inventoryTitle + ") has been updated");
	}
	
	
	
	// Esamos šalies ištrynimas (metodas aprašytas Repositorijoje)
	@Transactional
	public void deleteInventory(String inventoryCode) {
		Inventory inventoryToDelete = inventoryRepository.findByInventoryCode(inventoryCode);
		inventoryRepository.deleteByInventoryCode(inventoryCode);
		log.info("Inventory (" + inventoryToDelete.getInventoryTitle() + ") has been deleted");
	}
	
	// Vienos šalies švenčių nuskaitymas
		/*@Transactional(readOnly = true)
		public List<String> getCountryHolidays(String countryCode) {
			Inventory currentCountry = countryRepository.findCountryByCountryCode(countryCode);
			
			return currentCountry.getHolidays().stream().map((holiday) -> holiday.getTitle()).collect(Collectors.toList());

		}*/

}
