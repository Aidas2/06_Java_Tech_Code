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
import lt.sventes.dto.CreateCountryDTO;
import lt.sventes.dto.ReturnCountryDTO;
import lt.sventes.services.CountryService;

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
    @GetMapping
    @ApiOperation(value = "Get all countries", notes="Returns all countries")
    public List<ReturnCountryDTO> getCountryList() {
    	return countryService.getAllCountries();
    }
      
    //READ BY TITLE
    @GetMapping("/{title}")
    @ApiOperation(value = "Get country info", notes="Returns country info")
    public ReturnCountryDTO getCountryByTitle(
    		@ApiParam(value = "Country title", required = true)
            /*@Valid*/
            @PathVariable final String title) {
    	return countryService.findCountryByTitle(title);
    }
    
    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add new country", notes="Adds new country")
    public void createCountry(
    		@ApiParam(value = "Country title", required = true)
            /*@Valid*/
            @RequestBody final CreateCountryDTO createCountryDTO) {
    			countryService.createCountry(createCountryDTO);
    		} 
    
    //DELETE
    @DeleteMapping("/delete/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete country", notes = "Deletes selected country")
    public void deleteCountry (
            @ApiParam(value = "Country title", required = true)
            @PathVariable final String title) {
    	countryService.deleteCountry(title);
    }
    
    
    //UPDATE
    @PutMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update country info", notes="Updates country by title")
    public void updateCountry (
    		@ApiParam(value = "Country data", required = true)
            /*@Valid*/
            @RequestBody CreateCountryDTO createCountryDTO,
    		@ApiParam(value = "Country title", required = true)
            @PathVariable final String title) {
    	countryService.updateCountry(title, createCountryDTO);
    }
    
}
