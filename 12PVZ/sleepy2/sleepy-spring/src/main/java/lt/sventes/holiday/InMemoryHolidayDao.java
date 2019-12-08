package lt.sventes.holiday;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryHolidayDao implements HolidayDao{
	
	private final List<Holiday> holidays = new CopyOnWriteArrayList<>();

	@Override
	public List<Holiday> getHoliday() {
		return Collections.unmodifiableList(holidays);
	}
	
	@Override
	public void createHoliday(Holiday holiday) {
		holidays.add(holiday);
	}

	@Override
	public void deleteHoliday(String title) {
		// TODO Auto-generated method stub
		for (Holiday currentHoliday : holidays) {
			if (title.equals(currentHoliday.getTitle())) {
				holidays.remove(currentHoliday);
				break;
			}
		}
	}
}
