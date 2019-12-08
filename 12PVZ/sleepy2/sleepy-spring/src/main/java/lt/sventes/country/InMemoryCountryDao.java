package lt.sventes.country;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import lt.sventes.user.User;

@Repository
public class InMemoryCountryDao implements CountryDao{
	
	private final List<Country> countrys = new CopyOnWriteArrayList<>();

	@Override
	public List<Country> getCountrys() {
		return Collections.unmodifiableList(countrys);
		
	}

	@Override
	public void createCountry(Country country) {
		countrys.add(country);
		
	}

	@Override
	public void deleteCountry(String title) {
		for (Country currentCountry : countrys) {
			if (title.equals(currentCountry.getTitle())) {
				countrys.remove(currentCountry);
				break;
			}
		}
		
	}
	
	@Override
	public void updateCountry(long id, Country countryToUpdate) {
		for (int i = 0; i < countrys.size(); i++) {
			if(id == countrys.get(i).getId()) {
				countrys.set(i, countryToUpdate);
			}
		}
	}
	
}
