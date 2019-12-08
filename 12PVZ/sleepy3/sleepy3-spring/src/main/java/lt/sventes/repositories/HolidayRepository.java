package lt.sventes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.entities.Holiday;

public interface HolidayRepository extends JpaRepository <Holiday, Long> {
	Holiday findHolidayByTitle(String title);
	void deleteHolidayByTitle(String title);
}
