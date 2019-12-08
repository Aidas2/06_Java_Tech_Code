package lt.sventes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.sventes.dto.CreateHolidayDTO;
import lt.sventes.dto.ReturnHolidayDTO;
import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;
import lt.sventes.repositories.CountryRepository;
import lt.sventes.repositories.HolidayRepository;

@Service
public class HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public HolidayService(HolidayRepository holidayRepository, CountryRepository countryRepository) {
		super();
		this.holidayRepository = holidayRepository;
		this.countryRepository = countryRepository;
	}

	//GET ALL ------------------------------------------------------------
	@Transactional(readOnly = true)
		public List<ReturnHolidayDTO> getAllHolidays() {
		return holidayRepository.findAll()
				.stream()
				.map((holiday) -> new ReturnHolidayDTO(
						holiday.getTitle(),
						holiday.getDescription(),
						holiday.getImageOfHoliday(),
						holiday.getType(),
						holiday.isFlagRaised()
						))
				.collect(Collectors.toList());
	}
	
	//GET BY TITLE ------------------------------------------------------------
	@Transactional(readOnly = true)
	public ReturnHolidayDTO findHolidayByTitle(String title) {
		Holiday currentHoliday = holidayRepository.findHolidayByTitle(title);
		//variantas 1:
		
		//variantas 2:
		return new ReturnHolidayDTO (
				currentHoliday.getTitle(),
				currentHoliday.getDescription(),
				currentHoliday.getImageOfHoliday(),
				currentHoliday.getType(),
				currentHoliday.isFlagRaised() );
	}
	
	//CREATE ------------------------------------------------------------
	@Transactional
	public void createHoliday (CreateHolidayDTO createHolidayDTO) {
		Holiday newHoliday = new Holiday(
				createHolidayDTO.getTitle(),
				createHolidayDTO.getDescription(),
				createHolidayDTO.getImageOfHoliday(),
				createHolidayDTO.getType(),
				createHolidayDTO.isFlagRaised() );
		holidayRepository.save(newHoliday);
	}
	
	//UPDATE ------------------------------------------------------------
	@Transactional	
	public void updateHoliday (CreateHolidayDTO createHolidayDTO) {
		Holiday holidayToUpdate = holidayRepository.findHolidayByTitle(createHolidayDTO.getTitle());
		holidayToUpdate.setTitle(createHolidayDTO.getTitle());
		holidayToUpdate.setDescription(createHolidayDTO.getDescription());
		holidayToUpdate.setImageOfHoliday(createHolidayDTO.getImageOfHoliday());
		holidayToUpdate.setType(createHolidayDTO.getType());
		holidayToUpdate.isFlagRaised();
		holidayRepository.save(holidayToUpdate);
	}
	
	// DELETE ------------------------------------------------------------
	//(metodas aprašytas JPA repositorijoje)
	@Transactional
	public void deleteHoliday (String title) {
		holidayRepository.deleteHolidayByTitle(title);	
	}
	
	// PUT ------------------------------------------------------------
	@Transactional
	public void addCountryToHoliday(String titleOfHoliday, String titleOfCountry) {
		Country country = countryRepository.findCountryByTitle(titleOfCountry);
		Holiday holiday = holidayRepository.findHolidayByTitle(titleOfHoliday);
		// kaip toliau ???
	}
	
}
