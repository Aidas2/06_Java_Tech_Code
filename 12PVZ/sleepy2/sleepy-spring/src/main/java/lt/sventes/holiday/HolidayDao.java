package lt.sventes.holiday;

import java.util.List;

import lt.sventes.country.Country;

public interface HolidayDao {
	
	List<Holiday> getHoliday();

	void createHoliday(Holiday holiday);

	void deleteHoliday(String title);
}
