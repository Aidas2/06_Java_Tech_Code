package lt.sventes.holiday;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.sventes.country.Country;
import lt.sventes.country.CountryRepository;

@Service
public class HolidayService {
	@Autowired
	private HolidayRepository holidayRepository;

	public List<Holiday> getHoliday() {
		return holidayRepository.findAll();
	}

	public void addCountryToHoliday(Holiday holiday) {
		holidayRepository.save(holiday);
	}

	public void deleteCountryFromHoliday(long id) {
		holidayRepository.delete(new Holiday(id, "", "", "", "", false));
	}

}
