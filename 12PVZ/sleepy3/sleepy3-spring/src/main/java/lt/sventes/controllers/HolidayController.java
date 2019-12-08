package lt.sventes.controllers;

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
import lt.sventes.dto.CreateHolidayDTO;
import lt.sventes.dto.ReturnHolidayDTO;
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
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all holidays", notes="Returns all holidays")
    public List<ReturnHolidayDTO> getHolidayList() {
    	return holidayService.getAllHolidays();
    } 
    
    //READ BY TITLE ------------------------------------------------------------
    @RequestMapping(value="/{title}", method=RequestMethod.GET)
    @ApiOperation(value = "Get holiday info", notes="Returns holiday info")
    public ReturnHolidayDTO getHolidayByTitle(
    		@ApiParam(value = "Holiday title", required = true) @Valid @PathVariable final String title) {
    	return holidayService.findHolidayByTitle(title);
    }
    
    //CREATE ------------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new holiday", notes="Creates new holiday")
	public void createHoliday(
			@ApiParam(value = "Holiday data", required = true) @Valid @RequestBody final CreateHolidayDTO createHolidayDTO) {
    	holidayService.createHoliday(createHolidayDTO);
    }
	   
    //DELETE ------------------------------------------------------------
    @RequestMapping(path="/{title}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@CrossOrigin // kas cia ?
    @ApiOperation(value="Delete holiday", notes="Deletes selected holiday")
    public void deleteHoliday(@PathVariable final String title) {
    	holidayService.deleteHoliday(title);
    }
	
    //UPDATE ------------------------------------------------------------
    @RequestMapping(path="/{title}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update holiday info", notes="Updates holiday by title")
	public void updateHoliday(
			@ApiParam(value = "Holiday data", required = true) @Valid @RequestBody CreateHolidayDTO createHolidayDTO,
			@ApiParam(value = "Holiday title", required = true) @PathVariable final String title) {
    	holidayService.createHoliday(createHolidayDTO);
    }
	   
    //ASSIGN COUNTRY ------------------------------------------------------------
    @RequestMapping(path="/{title}/country/{title}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Assign country to holiday")
    public void addCountryToHoliday(
    		@ApiParam(value = "Holiday title", required = true) @PathVariable final String titleOfHoliday,
    		@ApiParam(value = "Country title", required = true) @PathVariable final String titleOfCountry) {
    	holidayService.addCountryToHoliday(titleOfHoliday, titleOfCountry);
    }
	
	
}