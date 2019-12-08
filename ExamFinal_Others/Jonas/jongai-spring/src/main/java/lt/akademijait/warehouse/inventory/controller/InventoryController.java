package lt.akademijait.warehouse.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.warehouse.inventory.model.InventoryData;
import lt.akademijait.warehouse.inventory.service.InventoryService;

@RestController
@Api(value = "inventory")
@RequestMapping(value = "/api/inventories")
public class InventoryController {

	private final InventoryService inventoryService;

	// konstruktorius
	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	// Visų inventorių gavimas
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get inventory list", notes = "Returns list of existing inventories")
	public List<InventoryData> getInventoryList() {
		return inventoryService.getFullListOfInventory();
	}

	// vieno inventoriaus gavimas
	@RequestMapping(path = "/{inventoryCode}", method = RequestMethod.GET)
	@ApiOperation(value = "Get country", notes = "Returns selected inventory")
	public InventoryData getOneInventoryByInventoryCode(
			@ApiParam(value = "Inventory code", required = true) @PathVariable final String inventoryCode) {

		return inventoryService.findInventoryByInventoryCode(inventoryCode);
		
	}

	// naujo inventoriaus suvedimas
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new inventory", notes = "Creates new inventory with provided data")
	public ResponseEntity<?> createCountry(
			@ApiParam(value = "Country data", required = true) @Valid @RequestBody final CreateInventoryCommand cic) {

		return inventoryService.createInventory(cic.getInventoryTitle(), cic.getInventoryWeigth(), cic.getInventorySector(),
				cic.getDateOfPlacement());
	}

	// inventoriaus atnaujinimas
	@RequestMapping(path = "/{inventoryCode}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Edit inventory", notes = "Change selected inventory's data")

	public void updateCountry(
			@ApiParam(value = "Inventory code", required = true) @PathVariable final String inventoryCode,
			@ApiParam(value = "Inventory data", required = true) @Valid @RequestBody final CreateInventoryCommand cic) {

		inventoryService.updateInventory(inventoryCode, cic.getInventoryTitle(), cic.getInventoryWeigth(), cic.getInventorySector(),
				cic.getDateOfPlacement());

	}

	// inventoriaus trynimas------------------------------------------

	@RequestMapping(path = "/{inventoryCode}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete inventory", notes = "Deletes selected invenotry")

	
	public void deleteInventory(@PathVariable final String inventoryCode) {
		inventoryService.deleteInventory(inventoryCode);
		System.out.println("Deleting i: " + inventoryCode);
	}
	
	// Vienos šalies švenčių nuskaitymas
		/*@RequestMapping(path = "/{countryCode}/addedHolidays", method = RequestMethod.GET)
		@ResponseStatus(HttpStatus.OK)
		@ApiOperation(value = "Vienos šalies švenčių gavimas", notes = "Kokioms šventėms yra priskirta šalis")
		public List<String> getCountryHolidays(
				@ApiParam(value = "Holiday title", required = true)
				@PathVariable final String countryCode) {
			return countryService.getCountryHolidays(countryCode);
		}*/

}
