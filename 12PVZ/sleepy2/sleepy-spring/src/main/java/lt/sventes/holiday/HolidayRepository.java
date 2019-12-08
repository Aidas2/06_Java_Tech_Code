package lt.sventes.holiday;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.country.Country;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
