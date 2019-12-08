package lt.sventes.country;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getCountrys() {
		System.out.println("----------------------" + countryRepository.findAll().get(0).getCountryDetails());
		return countryRepository.findAll();
	}
	
	@Transactional
	public void createCountry(Country country) {
		countryRepository.save(country);	
	}

	@Transactional
	public void deleteCountry(long id) {
		countryRepository.deleteCountryById(id);
	}
	
	@Transactional
	public void updateCountry(Country countryToUpdate) {
		countryRepository.save(countryToUpdate);
	}

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
}
