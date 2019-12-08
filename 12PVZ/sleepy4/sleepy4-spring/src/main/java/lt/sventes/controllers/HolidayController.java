package lt.sventes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.sventes.dto.CreateHolidayDTO;
import lt.sventes.dto.ReturnCountryDTO;
import lt.sventes.dto.ReturnHolidayDTO;
import lt.sventes.entities.Year;
import lt.sventes.services.HolidayService;

@RestController
@Api(value = "holidays")
@RequestMapping(value = "api/holidays")
public class HolidayController {

	private HolidayService holidayService;

	@Autowired
	public HolidayController(HolidayService holidayService) {
		super();
		this.holidayService = holidayService;
	}
	
    //READ ------------------------------------------------------------
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    @ApiOperation(value = "Get all holidays", notes="Returns all holidays")
    public List<ReturnHolidayDTO> getHolidayList() {
    	return holidayService.getAllHolidays();
    } 
    
    //READ BY TITLE ------------------------------------------------------------
    //@RequestMapping(value="/{title}", method=RequestMethod.GET)
    @GetMapping("/{title}")
    @ApiOperation(value = "Get holiday info", notes="Returns holiday info")
    public ReturnHolidayDTO getHolidayByTitle(
    		@ApiParam(value = "Holiday title", required = true)
            /*@Valid*/
            @PathVariable final String title) {
    	return holidayService.findHolidayByTitle(title);
    }
    
    //CREATE ------------------------------------------------------------
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new holiday", notes="Creates new holiday")
	public void createHoliday(
			@ApiParam(value = "Holiday data", required = true)
            /*@Valid*/
            @RequestBody final CreateHolidayDTO createHolidayDTO) {
    	holidayService.createHoliday(createHolidayDTO);
    }
	   
    //DELETE ------------------------------------------------------------
    //@RequestMapping(path="/delete/{title}", method=RequestMethod.DELETE)
    @DeleteMapping("/delete/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@CrossOrigin // kas cia ?
    @ApiOperation(value="Delete holiday", notes="Deletes selected holiday")
    public void deleteHoliday(
            @ApiParam(value = "Holiday title", required = true)
            @PathVariable final String title) {
    	holidayService.deleteHoliday(title);
    }
	
    //UPDATE ------------------------------------------------------------
    //@RequestMapping(path="/{title}", method=RequestMethod.PUT)
    @PutMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update holiday info", notes="Updates holiday by title")
	public void updateHoliday(
			@ApiParam(value = "Holiday data", required = true)
            /*@Valid*/
            @RequestBody CreateHolidayDTO createHolidayDTO,
			@ApiParam(value = "Holiday title", required = true)
            @PathVariable final String title) {
    	holidayService.updateHoliday(title, createHolidayDTO);
    }
	   
    //ASSIGN COUNTRY ------------------------------------------------------------
    //@RequestMapping(path="/{titleOfHoliday}/{titleOfCountry}", method=RequestMethod.PUT)
    @PutMapping("/{titleOfHoliday}/countries/{titleOfCountry}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Assign country to a holiday")
    public void addCountryToHoliday(
    		@ApiParam(value = "Holiday title", required = true)
            @PathVariable final String titleOfHoliday,
    		@ApiParam(value = "Country title", required = true)
            @PathVariable final String titleOfCountry) {
    	holidayService.addCountryToHoliday(titleOfHoliday, titleOfCountry);
    }

    //ASSIGN YEAR ------------------------------------------------------------
    //@RequestMapping(path="/{titleOfHoliday}/{titleOfYear}", method=RequestMethod.PUT)
    @PutMapping("/{titleOfHoliday}/years/{titleOfYear}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Assign year to a holiday")
    public void addYearToHoliday(
            @ApiParam(value = "Holiday title", required = true)
            @PathVariable final String titleOfHoliday,
            @ApiParam(value = "Year title", required = true)
            @PathVariable final Integer titleOfYear) {
        holidayService.addYearToHoliday(titleOfHoliday, titleOfYear);
    }

    //DE-ASSIGN COUNTRY ------------------------------------------------------------
    //@RequestMapping(path="/{titleOfHoliday}/{titleOfCountry}", method=RequestMethod.DELETE)
    @DeleteMapping("/{titleOfHoliday}/countries/{titleOfCountry}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="De-assign country from a holiday")
    public void removeCountryFromHoliday(
            @ApiParam(value = "Holiday title", required = true)
            @PathVariable final String titleOfHoliday,
            @ApiParam(value = "Country title", required = true)
            @PathVariable final String titleOfCountry) {
        holidayService.removeCountryFromHoliday(titleOfHoliday, titleOfCountry);
    }

    //DE-ASSIGN YEAR ------------------------------------------------------------
    //@RequestMapping(path="/{titleOfHoliday}/{titleOfYear}", method=RequestMethod.DELETE)
    @DeleteMapping("/{titleOfHoliday}/years/{titleOfYear}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="De-assign year from a holiday")
    public void removeYearFromHoliday(
            @ApiParam(value = "Holiday title", required = true)
            @PathVariable final String titleOfHoliday,
            @ApiParam(value = "Year title", required = true)
            @PathVariable final Integer titleOfYear) {
        holidayService.removeYearFromHoliday(titleOfHoliday, titleOfYear);
    }

    //GET ALL COUNTRIES FOR CURRENT HOLIDAY -------------------------------------------------------
    @GetMapping("/{title}/countries")
    @ApiOperation(value="Get all countries for current holiday")
    public List<ReturnCountryDTO> getAllCountries(@PathVariable final String title) {
	    return holidayService.getAllCountriesForHoliday(title);
    }

    //GET ALL YEARS FOR CURRENT HOLIDAY ----------------------------------------------------------
    @GetMapping("/{title}/years")
    @ApiOperation(value="Get all years for current holiday")
    public List<Year> getAllYears(@PathVariable final String title) {
	    return holidayService.getAllYearsForHoliday(title);
    }
	
}