package lt.sventes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.sventes.dto.CreateCountryDTO;
import lt.sventes.dto.ReturnCountryDTO;
import lt.sventes.entities.Country;
import lt.sventes.repositories.CountryRepository;
//klase skirta igyvendinti verslo logika
@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;		
	}

	
	//GET ALL ------------------------------------------------------------
	@Transactional(readOnly = true)  //readOnly reikalinga tam kad nebutu pakeiciami duomeys
	public List <ReturnCountryDTO> getAllCountries() {
		return countryRepository.findAll()
				.stream()
				.map((country) -> new ReturnCountryDTO(
						country.getId(),
						country.getTitle(),
						country.getImageOfFlag(),
						country.getPresident(),
						country.getArea(),
						country.getPopulation()
						//country.getHolidaysList()
						))
				.collect(Collectors.toList());
	}
	
	//GET BY TITLE ------------------------------------------------------------
	@Transactional(readOnly = true)
	public ReturnCountryDTO findCountryByTitle(String title) {
		Country countryToGet = countryRepository.findCountryByTitle(title);
//		version 1:
//		ReturnCountryDTO countryToController = new ReturnCountryDTO (
//				countryToGet.getId(),
//				countryToGet.getTitle(),
//				countryToGet.getImageOfFlag(),
//				countryToGet.getPresident(),
//				countryToGet.getArea(),
//				countryToGet.getPopulation(),
//				countryToGet.getHolidaysList()
//				);
//		return countryToController;
		//version 2:
		return new ReturnCountryDTO (
				countryToGet.getId(),
				countryToGet.getTitle(),
				countryToGet.getImageOfFlag(),
				countryToGet.getPresident(),
				countryToGet.getArea(),
				countryToGet.getPopulation());
				//countryToGet.getHolidaysList());
	}
	
	//CREATE ------------------------------------------------------------
	@Transactional
	public void createCountry(CreateCountryDTO createCountryDTO) {
//		version 1:
		Country newCountry = new Country (
				createCountryDTO.getTitle(),
				createCountryDTO.getImageOfFlag(),
				createCountryDTO.getPresident(),
				createCountryDTO.getArea(),
				createCountryDTO.getPopulation());
				//createCountryDTO.getHolidaysList());
		countryRepository.save(newCountry);
//		version 2:
//		Country newCountry = new Country();
//		newCountry.setTitle(createCountryDTO.getTitle());
//		newCountry.setImageOfFlag(createCountryDTO.getImageOfFlag());
//		newCountry.setPresident(createCountryDTO.getPresident());
//		newCountry.setArea(createCountryDTO.getArea());
//		newCountry.setPopulation(createCountryDTO.getPopulation());
//		newCountry.setHolidaysList(createCountryDTO.getHolidaysList());
//
//		countryRepository.save(newCountry);
	}
	
	//UPDATE ------------------------------------------------------------
	@Transactional
	public void updateCountry(String title, CreateCountryDTO createCountryDTO) {
		Country countryToUpdate = countryRepository.findCountryByTitle(title);

		countryToUpdate.setTitle(createCountryDTO.getTitle());
		countryToUpdate.setImageOfFlag(createCountryDTO.getImageOfFlag());
		countryToUpdate.setPresident(createCountryDTO.getPresident());
		countryToUpdate.setArea(createCountryDTO.getArea());
		countryToUpdate.setPopulation(createCountryDTO.getPopulation());
		//countryToUpdate.setHolidaysList(createCountryDTO.getHolidaysList());

		countryRepository.save(countryToUpdate);
	}
	
	// DELETE ------------------------------------------------------------
	@Transactional
	public void deleteCountry(String title) {
		countryRepository.deleteCountryByTitle(title);
	}


}
