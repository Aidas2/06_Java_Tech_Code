
package lt.sventes.holiday;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.sventes.country.CreateCountryCommand;
import lt.sventes.country.Country;
import lt.sventes.country.CountryService;

@RestController
@Api(value = "holiday")
@RequestMapping(value = "/api/users/{user}/holiday-countrys")
public class HolidayController {

	private final HolidayService holidayService; // pridedame DAO

	// konstruktorius
	@Autowired
		public HolidayController(HolidayService holidayService) {
			this.holidayService = holidayService;
		}
	
//--------------------------------------------------------------------	
	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(path = "/api/users/{user}/holiday-countrys", method = RequestMethod.GET)
	@ApiOperation(value = "Get holiday of user", notes = "Returns user's holiday")
	public List<Holiday> getHoliday(@ApiParam(value = "User", required = true) @Valid @PathVariable final String user) {
		return holidayService.getHoliday();// skaitome per DAO
	}

//--------------------------------------------------------------------	
	@RequestMapping(path = "/api/users/{user}/holiday-countrys", method = RequestMethod.POST)
	@ApiOperation(value = "Add country to user's holiday", notes = "Adds country to user's holiday")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCountryToHoliday(@ApiParam(value = "User", required = true) @Valid @PathVariable final String user,
			@ApiParam(value = "Country", required = true) @Valid @RequestBody final CreateHolidayCommand cmd) {
		holidayService.addCountryToHoliday(new Holiday(cmd.getTitle(), cmd.getDescription(), cmd.getImage(), cmd.getTypeOfHoliday(), cmd.isRiseOfFlag()));
		System.out.println(cmd);
	}
//--------------------------------------------------------------------		

	
//--------------------------------------------------------------------	
	@RequestMapping(path = "/api/users/{user}/holiday-countrys/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCountryFromHoliday(@ApiParam(value = "User", required = true) @Valid @PathVariable final String user,
									@ApiParam(value = "Country id", required = true) @Valid @PathVariable final long id) {
		holidayService.deleteCountryFromHoliday(id);
		System.out.println("Deleting country: " + id);
	}

	
}