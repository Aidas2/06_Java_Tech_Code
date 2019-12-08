package lt.sventes.country;

import java.util.List;

import lt.sventes.user.User;

public interface CountryDao {
	List<Country> getCountrys();

	void createCountry(Country country);

	void deleteCountry(String title);

	//mano metodas -> pirminis (senas)
	//void updateCountry(Country country);
	
	//mano metodas produkto atnaujinimui naujas
	void updateCountry(long id, Country country);

}
