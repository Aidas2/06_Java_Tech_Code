package lt.sventes.repositories;

import lt.sventes.entities.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearsRepository extends JpaRepository <Year, Integer> {
    Year findYearByYear (Integer year);
    void deleteYearByYear(Integer year);
}
