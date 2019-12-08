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
	
	//Ar tikrai reikalingas sis konstruktorius ir getteriai-setteriai ?
/*	@Autowired
	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;		
	}
	
	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
*/
	
	//GET ALL ------------------------------------------------------------
	//pastaba: map'inant "country" yra bet koks laisvai pasirenkmas terminas, jis yra tik kaip "elementas is elementu"
	@Transactional(readOnly = true)  //readOnly reikalinga tam kad nebutu pakeiciami duomeys
	public List <ReturnCountryDTO> getAllCountries() {
		return countryRepository.findAll()
				.stream()
				.map((country) -> new ReturnCountryDTO(
						country.getTitle(),
						country.getImageOfFlag(),
						country.getPresident()
						))
				.collect(Collectors.toList());
	}
	
	//GET BY TITLE ------------------------------------------------------------
	@Transactional(readOnly = true)
	public ReturnCountryDTO findCountryByTitle(String title) {
		Country currentCountry = countryRepository.findCountryByTitle(title);
//		variantas 1:
//		ReturnCountryDTO countryToController = new ReturnCountryDTO (
//				currentCountry.getTitle(),
//				currentCountry.getImageOfFlag(),
//				currentCountry.getPresident()
//				);
//		return countryToController;
		//variantas 2:
		return new ReturnCountryDTO (
				currentCountry.getTitle(),
				currentCountry.getImageOfFlag(),
				currentCountry.getPresident());
	}
	
	//CREATE ------------------------------------------------------------
	@Transactional
	public void createCountry(CreateCountryDTO createCountryDTO) {
//		variantas 1:
//		Country newCountry = new Country (
//				createCountryDTO.getTitle(),
//				createCountryDTO.getImageOfFlag(),
//				createCountryDTO.getPresident());
//		countryRepository.save(newCountry);
//		variantas 2:		
		countryRepository.save(new Country (
				createCountryDTO.getTitle(),
				createCountryDTO.getImageOfFlag(),
				createCountryDTO.getPresident()
				));
	}
	
	//UPDATE ------------------------------------------------------------
	@Transactional	
//	variantas 1:		//pakeicia duomenis, bet title visada tas pats t.y. keicia tik visus kitus duomenis, bet ne ta pagal kuri identifikuoja.
	public void updateCountry(CreateCountryDTO createCountryDTO) {
		Country countryToUpdate = countryRepository.findCountryByTitle(createCountryDTO.getTitle());
		countryToUpdate.setTitle(createCountryDTO.getTitle());
		countryToUpdate.setImageOfFlag(createCountryDTO.getImageOfFlag());
		countryToUpdate.setPresident(createCountryDTO.getPresident());
		countryRepository.save(countryToUpdate);
	}
//	variantas 2:	//nera jokios paieskos pagal id ar title, dar klausimas ar paeis ...  //P.S. Nepaejo t.y. ne updatina, o sukuria nauja irasa.
//	public void updateCountry(String title, CreateCountryDTO createCountryDTO) {
//		Country updatedCountry = (new Country (
//				createCountryDTO.getTitle(),
//				createCountryDTO.getImageOfFlag(),
//				createCountryDTO.getPresident()
//				));
//		updatedCountry.setTitle(title);
//		countryRepository.save(updatedCountry);
//	}
	
	// DELETE ------------------------------------------------------------
	//(metodas aprašytas JPA repositorijoje)
	@Transactional
	public void deleteCountry(String title) {
		countryRepository.deleteCountryByTitle(title);
	}


}
