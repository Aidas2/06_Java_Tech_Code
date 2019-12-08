package lt.sventes.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.sventes.dto.CreateHolidayDTO;
import lt.sventes.dto.ReturnCountryDTO;
import lt.sventes.dto.ReturnHolidayDTO;
import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;
import lt.sventes.entities.Year;
import lt.sventes.repositories.CountryRepository;
import lt.sventes.repositories.HolidayRepository;
import lt.sventes.repositories.YearsRepository;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private YearsRepository yearsRepository;

    public HolidayService(
            HolidayRepository holidayRepository,
            CountryRepository countryRepository, YearsRepository yearsRepository) {
        super();
        this.holidayRepository = holidayRepository;
        this.countryRepository = countryRepository;
        this.yearsRepository = yearsRepository;
    }

    //GET ALL ------------------------------------------------------------
    @Transactional(readOnly = true)
    public List<ReturnHolidayDTO> getAllHolidays() {
        return holidayRepository.findAll()
                                .stream()
                                .map((holiday) -> new ReturnHolidayDTO(
                                        holiday.getId(),
                                        holiday.getTitle(),
                                        holiday.getDescription(),
                                        holiday.getType(),
                                        holiday.getImageOfHoliday(),
                                        holiday.isFlagRaised(),
                                        holiday.getHireDate(),
                                        holiday.getDistance(),
                                        holiday.getPrice()
                                        //holiday.getCountriesList(),
                                        //holiday.getYearsList()
                                ))
                                .collect(Collectors.toList());
    }

    //GET BY TITLE ------------------------------------------------------------
    @Transactional(readOnly = true)
    public ReturnHolidayDTO findHolidayByTitle(String title) {
        Holiday currentHoliday = holidayRepository.findHolidayByTitle(title);
        //version 1:

        //version 2:
        return new ReturnHolidayDTO(
                currentHoliday.getId(),
                currentHoliday.getTitle(),
                currentHoliday.getDescription(),
                currentHoliday.getType(),
                currentHoliday.getImageOfHoliday(),
                currentHoliday.isFlagRaised(),
                currentHoliday.getHireDate(),
                currentHoliday.getDistance(),
                currentHoliday.getPrice());
                //currentHoliday.getCountriesList(),
                //currentHoliday.getYearsList());
    }

    //CREATE ------------------------------------------------------------
    @Transactional
    public void createHoliday(CreateHolidayDTO createHolidayDTO) {

        //version1 (with full constructor):
		Holiday newHoliday = new Holiday(
				createHolidayDTO.getTitle(),
				createHolidayDTO.getDescription(),
				createHolidayDTO.getType(),
				createHolidayDTO.getImageOfHoliday(),
				createHolidayDTO.isFlagRaised(),
				createHolidayDTO.getHireDate(),
				createHolidayDTO.getDistance(),
				createHolidayDTO.getPrice());
              //createHolidayDTO.getCountriesList(),
              //createHolidayDTO.getYearsList());
		holidayRepository.save(newHoliday);

        //version2 (with empty constructor):
//        Holiday newHoliday = new Holiday();
//        newHoliday.setTitle(createHolidayDTO.getTitle());
//        newHoliday.setDescription(createHolidayDTO.getDescription());
//        newHoliday.setType(createHolidayDTO.getType());
//        newHoliday.setImageOfHoliday(createHolidayDTO.getImageOfHoliday());
//        newHoliday.setFlagRaised(createHolidayDTO.isFlagRaised());
//        newHoliday.setHireDate(createHolidayDTO.getHireDate());
//        newHoliday.setDistance(createHolidayDTO.getDistance());
//        newHoliday.setPrice(createHolidayDTO.getPrice());
        //newHoliday.setCountriesList(createHolidayDTO.getCountriesList());
        //newHoliday.setYearsList(createHolidayDTO.getYearsList());

        holidayRepository.save(newHoliday);
    }

    //UPDATE ------------------------------------------------------------
    @Transactional
    public void updateHoliday(String title, CreateHolidayDTO createHolidayDTO) {
        Holiday holidayToUpdate = holidayRepository.findHolidayByTitle(title);

        holidayToUpdate.setTitle(createHolidayDTO.getTitle());
        holidayToUpdate.setDescription(createHolidayDTO.getDescription());
        holidayToUpdate.setType(createHolidayDTO.getType());
        holidayToUpdate.setImageOfHoliday(createHolidayDTO.getImageOfHoliday());
        holidayToUpdate.setFlagRaised(createHolidayDTO.isFlagRaised());
        holidayToUpdate.setHireDate(createHolidayDTO.getHireDate());
        holidayToUpdate.setDistance(createHolidayDTO.getDistance());
        holidayToUpdate.setPrice(createHolidayDTO.getPrice());
        //holidayToUpdate.setCountriesList(createHolidayDTO.getCountriesList());
        //holidayToUpdate.setYearsList(createHolidayDTO.getYearsList());

        holidayRepository.save(holidayToUpdate);
    }

    // DELETE ------------------------------------------------------------
    @Transactional
    public void deleteHoliday(String title) {
        holidayRepository.deleteHolidayByTitle(title);
    }


    // ASSIGN ------------------------------------------------------------
    @Transactional
    public void addCountryToHoliday(String titleOfHoliday, String titleOfCountry) {
        Holiday holiday = holidayRepository.findHolidayByTitle(titleOfHoliday);
        Country country = countryRepository.findCountryByTitle(titleOfCountry);
        if (holiday != null) {
            holiday.getCountriesList().add(country);
        }
    }

    @Transactional
    public void addYearToHoliday(String titleOfHoliday, Integer titleOfYear) {
        Holiday holiday = holidayRepository.findHolidayByTitle(titleOfHoliday);
        Year year = yearsRepository.findYearByYear(titleOfYear);
        if (holiday != null) {
            holiday.getYearsList().add(year);
        }
    }

    // DE-ASSIGN ------------------------------------------------------------
    @Transactional
    public void removeCountryFromHoliday(String titleOfHoliday, String titleOfCountry) {
        Holiday holiday = holidayRepository.findHolidayByTitle(titleOfHoliday);
        Country country = countryRepository.findCountryByTitle(titleOfCountry);
        if (holiday != null) {
            holiday.getCountriesList().remove(country);
        }
    }

    @Transactional
    public void removeYearFromHoliday(String titleOfHoliday, Integer titleOfYear) {
        Holiday holiday = holidayRepository.findHolidayByTitle(titleOfHoliday);
        Year year = yearsRepository.findYearByYear(titleOfYear);
        if (holiday != null) {
            holiday.getYearsList().remove(year);
        }
    }

    //GET ALL COUNTRIES FOR CURRENT HOLIDAY
    @Transactional
    public List<ReturnCountryDTO> getAllCountriesForHoliday (String title) {
        Holiday holiday = holidayRepository.findHolidayByTitle(title);
        if(holiday != null) {
            return holiday.getCountriesList().stream()
                    .map(country -> new ReturnCountryDTO(
                            country.getId(),
                            country.getTitle(),
                            country.getImageOfFlag(),
                            country.getPresident(),
                            country.getArea(),
                            country.getPopulation()
                    )).collect(Collectors.toList());
        }
        return null;
    }

    //GET ALL YEARS FOR CURRENT HOLIDAY
    @Transactional
    public List<Year> getAllYearsForHoliday (String title) {
        Holiday holiday = holidayRepository.findHolidayByTitle(title);
        if(holiday != null) {
            return holiday.getYearsList().stream()
                    .map(year -> new Year(
                            //year.getId(),
                            year.getYear(),
                            year.getMonth(),
                            year.getDay(),
                            year.getZodiac()
                    )).collect(Collectors.toList());
        }
        return null;
    }


}
