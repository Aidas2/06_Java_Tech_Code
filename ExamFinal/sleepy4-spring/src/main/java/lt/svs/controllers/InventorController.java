package lt.svs.controllers;

import java.util.List;

import lt.svs.dto.CreateInventorDTO;
import lt.svs.dto.ReturnInventorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.svs.services.InventorService;

@RestController
@Api(value = "inventors")
@RequestMapping(value = "api/inventors") //sis kelias turi sutapti su frontendu (Reactu) !!!
public class InventorController {

	
	private InventorService inventorService;

	@Autowired
	public InventorController(InventorService inventorService) {
		super();
		this.inventorService = inventorService;
	}
		
    //READ
    @GetMapping
    @ApiOperation(value = "Get all inventors", notes="Returns all inventors")
    public List<ReturnInventorDTO> getInventorList() {
    	return inventorService.getAllInventors();
    }
      
    //READ BY TITLE
    @GetMapping("/{title}")
    @ApiOperation(value = "Get inventor info", notes="Returns inventor info")
    public ReturnInventorDTO getInventorByTitle(
    		@ApiParam(value = "Inventor title", required = true)
            /*@Valid*/
            @PathVariable final String title) {
    	return inventorService.findCInventorByTitle(title);
    }
    
    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add new inventor", notes="Adds new inventor")
    public void createInventor(
    		@ApiParam(value = "Inventor title", required = true)
            /*@Valid*/
            @RequestBody final CreateInventorDTO createInventorDTO) {
    			inventorService.createInventor(createInventorDTO);
    		} 
    
    //DELETE
    @DeleteMapping("/delete/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete inventor", notes = "Deletes selected inventor")
    public void deleteInventor (
            @ApiParam(value = "Inventor title", required = true)
            @PathVariable final String title) {
    	inventorService.deleteInventor(title);
    }
    
    
    //UPDATE
    @PutMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update inventor info", notes="Updates inventor by title")
    public void updateInventor (
    		@ApiParam(value = "Inventor data", required = true)
            /*@Valid*/
            @RequestBody CreateInventorDTO createInventorDTO,
    		@ApiParam(value = "Inventor title", required = true)
            @PathVariable final String title) {
    	inventorService.updateInventor(title, createInventorDTO);
    }
    
}
