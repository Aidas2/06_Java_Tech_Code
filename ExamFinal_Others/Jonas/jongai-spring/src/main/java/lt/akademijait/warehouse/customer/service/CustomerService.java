package lt.akademijait.warehouse.customer.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
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
import lt.akademijait.warehouse.customer.model.Customer;
import lt.akademijait.warehouse.customer.model.CustomerData;
import lt.akademijait.warehouse.customer.model.CustomerType;
import lt.akademijait.warehouse.inventory.model.Inventory;
import lt.akademijait.warehouse.inventory.service.InventoryRepository;
import lt.akademijait.warehouse.security.payload.ApiResponse;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	//@Autowired
	private InventoryRepository inventoryRepository;

	// Visų klientų nuskaitymas
	@Transactional(readOnly = true)
	public List<CustomerData> getFullListOfCustomers() {
		return customerRepository.findAll().stream()
				.map((customer) -> 
				new CustomerData(customer.getCustomerCode(),
						customer.getFirstName(),
						customer.getLastName(),
						customer.getBirthday(),
						customer.getPhoneNumber(),
						customer.getCustomerType().toString()
								// holiday.getCountries()
				)).collect(Collectors.toList());
	}
	
	
	
	// Visų švenčių nuskaitymas su datos lauku
	/*@Transactional(readOnly = true)
	public List<CustomerData> getFullListOfHolidaysWithDate() {		
		return customerRepository.findAll().stream()
				.map((holiday) -> 
				new CustomerData(holiday.getCode(),
								holiday.getTitle(),
								holiday.getDescription(),
								holiday.getImage(),
								replaceToString(holiday.getType()),
								holiday.isFlag(),
								holiday.getCountries(),
								holiday.getSimpleDate()
				)).collect(Collectors.toList());
	}*/
		
	/*public String replaceToString(CustomerType typeToModify) {
		String modifiedType = typeToModify.toString();
		return modifiedType;
	}*/

	// Vieno kliento nuskaitymas
	@Transactional(readOnly = true)
	public CustomerData findOneCustomerByCustomercode(String customerCode) {
		//Holiday currentHoliday = holidayRepository.findHolidayByTitle(title);			
			
		Customer currentCustomer = customerRepository.findByCustomerCode(customerCode);
		CustomerData customerToController = new CustomerData(currentCustomer.getCustomerCode(),
				currentCustomer.getFirstName(), currentCustomer.getLastName(),
				currentCustomer.getBirthday(), currentCustomer.getPhoneNumber(),
				currentCustomer.getCustomerType().toString());
		/*System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("Suformuotas objektas yra - " + customerToController);
		System.out.println("Suformuotas objektas yra - " + customerToController.getTitle());
		System.out.println("Suformuotas objektas yra - " + customerToController.getDescription());
		System.out.println("Suformuotas objektas yra - " + customerToController.getSimpleDate());
		System.out.println("Suformuotas objektas yra - " + customerToController.getCountries());
		System.out.println("#########################################################");
		System.out.println("#########################################################");
		System.out.println("#########################################################");*/
		
		return customerToController;
	}

	// Naujo kliento  sukūrimas
	/*@Transactional
	public ResponseEntity<?> createHoliday(String title, String description, String image, String type, boolean flag,
			List<Country> countries) {

		// Patikrinu ar tokiu pavadinimu šventė jau egzistuoja
		if (holidayRepository.existsByTitle(title)) {
			return new ResponseEntity<>(new ApiResponse(false, "Holiday with such title already exists"),
					HttpStatus.BAD_REQUEST);
		}

		//1.Sugeneruoju atsitiktinę eilutę iš 7 simbolių
		String code = RandomStringUtils.random(7, true, true);
		//2.Modifikuoju title, kad jame nebūtų tarpų
		String modifiedTitle = title.replaceAll("\\s+","");
		//3.Sugeneruoju galutinį lauką code
		code += "_" + modifiedTitle;
		Holiday newHoliday = new Holiday(code, title, description, image, type, flag, countries);
		Holiday result = holidayRepository.save(newHoliday);
		log.info("A new holiday (" + title + ") has been created");
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/holidays/{code}")
				.buildAndExpand(result.getCode()).toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "Holiday created successfully"));
	}*/
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Naujos kliento su DATA sukūrimas
	@Transactional
	public ResponseEntity<?> createCustomer(String firstName, String lastName, LocalDate birthday, String phoneNumber,
			String customerType) {

		// TO DO  padaryti tikrinimą ar toks klientas jau yra
		// Patikrinu ar tokiu pavadinimu šventė jau egzistuoja
		/*if (customerRepository.existsByTitle(title)) {
			return new ResponseEntity<>(new ApiResponse(false, "Holiday with such title already exists"),
					HttpStatus.BAD_REQUEST);
		}*/
		
		if (customerRepository.existsByFirstNameAndLastNameAndBirthday(firstName, lastName, birthday)) {
			return new ResponseEntity<>(new ApiResponse(false, "Klientas su tokiu vardu, pavarde ir gimtadieniu jau egzistuoja"),
					HttpStatus.BAD_REQUEST);
		}
		
		
		
		//1.Sugeneruoju atsitiktinę eilutę iš 7 simbolių
		String randomCode = RandomStringUtils.random(7, true, true);
		//2.Modifikuoju title, kad jame nebūtų tarpų
		//String modifiedTitle = title.replaceAll("\\s+","");
		//3.Sugeneruoju galutinį lauką code
		String customerCode = randomCode + "_" + lastName;
		Customer newCustomer = new Customer(customerCode, firstName, lastName, birthday, phoneNumber,
				CustomerType.valueOf(customerType), new ArrayList<Inventory>());
		Customer result = customerRepository.save(newCustomer);
		log.info("A new customer (" + firstName + " " + lastName + ") has been created");
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/holidays/{code}")
				.buildAndExpand(result.getCustomerCode()).toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "Customer created successfully"));
	}
		
		////////////////////////////////////////////////////////////////////////////////////

	// Esamo kliento duomenų pakeitimas
	@Transactional
	public void updateCustomer(String customerCode, String firstName, String lastName, LocalDate birthday, String phoneNumber,
			String customerType) {
		// Reikia gautą šventės tipą patikrinti ar jis turi savyje simbolių "-" ir juos pakeisti į "_"
		/*String modifiedType = type.replaceAll("-", "_");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("ModifiedType = " + modifiedType);*/
		
		//Holiday holidayToUpdate = holidayRepository.findHolidayByTitle(currentTitle);
		Customer customerToUpdate = customerRepository.findByCustomerCode(customerCode);
		customerToUpdate.setFirstName(firstName);
		customerToUpdate.setLastName(lastName);
		customerToUpdate.setBirthday(birthday);
		customerToUpdate.setCustomerType(CustomerType.valueOf(customerType));
		customerRepository.save(customerToUpdate);
		log.info("Customer (" + firstName + " " + lastName + ") has been updated");
	}

	// Esamo kliento ištrynimas (metodas aprašytas Repositorijoje)
	@Transactional
	public void deleteCustomer(String customerCode) {
		//holidayRepository.deleteHolidayByTitle(title);
		Customer customerToDelete = customerRepository.findByCustomerCode(customerCode);
		customerRepository.deleteByCustomerCode(customerCode);;
		log.info("Customer (" + customerToDelete.getFirstName() + " " + customerToDelete.getLastName() + ") has been deleted");
	}

	
	
	
	///////////////////////////////////////////////////////////////////////
	
	// Čia eina surištų duomenų apdirbimo kodas
	
	
	
	// Vieno kliento inventoriaus nuskaitymas
	@Transactional(readOnly = true)
	public List<String> getCustomerInventories(String customerCode) {
		Customer currentCustomer = customerRepository.findByCustomerCode(customerCode);
		//Holiday currentHoliday = holidayRepository.findHolidayByTitle(holidayTitle);

		return currentCustomer.getInventories().stream().map((inventory) -> inventory.getInventoryTitle()).collect(Collectors.toList());

	}

	// Inventoriaus priskyrimas klientui
	@Transactional
	public void addInventoryToCustomer(String customerCode, List<String> inventoryList) {
		Customer currentCustomer = customerRepository.findByCustomerCode(customerCode);
		List<Inventory> alreadyAddedInventoryList = currentCustomer.getInventories();
		List<String> alreadyAddedInventoryStringList = alreadyAddedInventoryList.stream()
				.map((inventory) -> inventory.getInventoryTitle()).collect(Collectors.toList());
		for (String inventory : inventoryList) {
			if (!alreadyAddedInventoryStringList.contains(inventory)) {
				Inventory inventoryToAdd = inventoryRepository.findByInventoryTitle(inventory);
				currentCustomer.addInventory(inventoryToAdd);
				log.info("Inventory (" + inventoryToAdd.getInventoryTitle() + ") was added to customer (" +
				currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ")");
			}
		}
		customerRepository.save(currentCustomer);
		return;
	}

	// Šalių pašalinimas iš šventės
	/*@Transactional
	public void removeCountryFromHoliday(String code, List<String> countryList) {

		//Holiday currentHoliday = holidayRepository.findHolidayByTitle(title);
		Customer currentHoliday = customerRepository.findHolidayByCode(code);
		List<Inventory> alreadyAddedCountryList = currentHoliday.getCountries();
		List<String> alreadyAddedCountryStringList = alreadyAddedCountryList.stream()
				.map((country) -> country.getTitle()).collect(Collectors.toList());
		for (String country : countryList) {
			if (alreadyAddedCountryStringList.contains(country)) {
				Inventory countryToRemove = countryRepository.findCountryByTitle(country);
				currentHoliday.removeCountry(countryToRemove);
				log.info("Country (" + countryToRemove.getTitle() + ") was removed from holiday ("
						+ currentHoliday.getTitle() + ")");
			}
		}
		customerRepository.save(currentHoliday);
	}*/
}
