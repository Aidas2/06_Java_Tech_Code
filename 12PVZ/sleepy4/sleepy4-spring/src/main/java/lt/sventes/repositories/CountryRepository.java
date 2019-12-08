package lt.sventes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;

public interface CountryRepository extends JpaRepository <Country, Long> {
	//variantas 1:
	//@Query("SELECT c FROM Country c WHERE c.title=:title AND c.description=:des")
	//Country findCountryByTitle(@Param("title") String title, @Param("des") String des);
	//variantas 2:
	Country findCountryByTitle(String title);
	void deleteCountryByTitle(String title);

}
