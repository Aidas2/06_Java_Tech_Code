package lt.akademijait.warehouse.inventory.service;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.akademijait.warehouse.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	Inventory findByInventoryCode(String inventoryCode);
	void deleteByInventoryCode(String inventoryCode);
	
	//Šitas metodas naudojamas, kad surasti šalį pagal pavadinimą,
	//kai vartotojas iš galimų šalių renkasi, kokias šalis priskirti šventei
	Inventory findByInventoryTitle(String inventoryTitle);
	boolean existsByInventoryTitle(String inventoryTitle);

}
