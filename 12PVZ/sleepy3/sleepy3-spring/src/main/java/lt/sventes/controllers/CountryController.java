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
import lt.sventes.dto.CreateCountryDTO;
import lt.sventes.dto.ReturnCountryDTO;
import lt.sventes.services.CountryService;
// klase skirta bendravimui tarp backendo ir frontendo
@RestController
@Api(value = "countries")
@RequestMapping(value = "api/countries") //sis kelias turi sutapti su frontendu (Reactu) !!!
public class CountryController {

	
	private CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
		
    //READ
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all countries", notes="Returns all countries")
    public List<ReturnCountryDTO> getCountryList() {
    	return countryService.getAllCountries();
    }
      
    //READ BY TITLE
    @RequestMapping(path = "/{title}", method=RequestMethod.GET) //sis kelias prisideda prie pradinio (25 eilute) !!!
    @ApiOperation(value = "Get country info", notes="Returns country info")
    public ReturnCountryDTO getCountryByTitle(
    		@ApiParam(value = "Country title", required = true) @Valid @PathVariable final String title) {
    	return countryService.findCountryByTitle(title);
    }
    
    //CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add new country", notes="Adds new country")
    public void createCountry(
    		@ApiParam(value = "Country data", required = true) @Valid @RequestBody final CreateCountryDTO createCountryDTO) {  		 
    			countryService.createCountry(createCountryDTO);
    		} 
    
    //DELETE
    @RequestMapping(path="/{title}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete country", notes = "Deletes selected contry")
    public void deleteCountry (@PathVariable final String title) {
    	countryService.deleteCountry(title);
    }
    
    
    //UPDATE
    @RequestMapping(path="/{title}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update country info", notes="Updates country by title")
    public void updateCountry (
    		@ApiParam(value = "Country data", required = true) @Valid @RequestBody CreateCountryDTO createCountryDTO,
    		@ApiParam(value = "Country title", required = true) @PathVariable final String title) {
    	//countryService.updateCountry(title, createCountryDTO); //variantas 1
    	countryService.updateCountry(createCountryDTO); //variantas 2
    }
    
}
