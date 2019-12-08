package lt.svs.controllers;

import java.util.List;

import lt.svs.dto.CreateCustomerDTO;
import lt.svs.entities.Report;
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
import lt.svs.dto.ReturnInventorDTO;
import lt.svs.dto.ReturnCustomerDTO;
import lt.svs.services.CustomerService;

@RestController
@Api(value = "customers")
@RequestMapping(value = "api/customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
    //READ ------------------------------------------------------------
    @GetMapping
    @ApiOperation(value = "Get all customers", notes="Returns all customers")
    public List<ReturnCustomerDTO> getCustomerList() {
    	return customerService.getAllCustomers();
    } 
    
    //READ BY NAME ------------------------------------------------------------
    @GetMapping("/{name}")
    @ApiOperation(value = "Get customer info", notes="Returns customer info")
    public ReturnCustomerDTO getCustomerByName(
    		@ApiParam(value = "Customer name", required = true)
            /*@Valid*/
            @PathVariable final String name) {
    	return customerService.findCustomerByName(name);
    }
    
    //CREATE ------------------------------------------------------------
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new customer", notes="Creates new customer")
	public void createCustomer(
			@ApiParam(value = "Customer data", required = true)
            /*@Valid*/
            @RequestBody final CreateCustomerDTO createCustomerDTO) {
    	customerService.createCustomer(createCustomerDTO);
    }
	   
    //DELETE ------------------------------------------------------------
    @DeleteMapping("/delete/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@CrossOrigin
    @ApiOperation(value="Delete customer", notes="Deletes selected customer")
    public void deleteCustomer(
            @ApiParam(value = "Customer name", required = true)
            @PathVariable final String name) {
    	customerService.deleteCustomer(name);
    }
	
    //UPDATE ------------------------------------------------------------
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update customer info", notes="Updates customer by name")
	public void updateCustomer(
			@ApiParam(value = "Customer data", required = true)
            /*@Valid*/
            @RequestBody CreateCustomerDTO createCustomerDTO,
			@ApiParam(value = "Customer name", required = true)
            @PathVariable final String name) {
    	customerService.updateCustomer(name, createCustomerDTO);
    }
	   
    //ASSIGN INVENTOR ------------------------------------------------------------
    @PutMapping("/{nameOfCustomer}/inventors/{titleOfInventor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Assign Inventor to a customer")
    public void addInventorToCustomer(
    		@ApiParam(value = "Customer name", required = true)
            @PathVariable final String nameOfCustomer,
    		@ApiParam(value = "Inventor title", required = true)
            @PathVariable final String titleOfInventor) {
    	customerService.addInventoryToCustomer(nameOfCustomer, titleOfInventor);
    }

    //ASSIGN REPORT ------------------------------------------------------------
    @PutMapping("/{nameOfCustomer}/reports/{titleOfReport}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Assign report to a customer")
    public void addReportToCustomery(
            @ApiParam(value = "Customer name", required = true)
            @PathVariable final String nameOfCustomer,
            @ApiParam(value = "Report title", required = true)
            @PathVariable final String titleOfReport) {
        customerService.addReportToCustomer(nameOfCustomer, titleOfReport);
    }

    //DE-ASSIGN INVENTOR ------------------------------------------------------------
    @DeleteMapping("/{nameOfCustomer}/inventors/{titleOfInventor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="De-Assign Inventor from a customer")
    public void removeInventorFromCustomer(
            @ApiParam(value = "Customer name", required = true)
            @PathVariable final String nameOfCustomer,
            @ApiParam(value = "Inventor title", required = true)
            @PathVariable final String titleOfInventor) {
        customerService.removeInventoryFromCustomer(nameOfCustomer, titleOfInventor);
    }

    //DE-ASSIGN REPORT ------------------------------------------------------------
    @DeleteMapping("/{nameOfCustomer}/reports/{titleOfReport}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="De-Assign report from a customer")
    public void removeReportFromCustomery(
            @ApiParam(value = "Customer name", required = true)
            @PathVariable final String nameOfCustomer,
            @ApiParam(value = "Report title", required = true)
            @PathVariable final String titleOfReport) {
        customerService.removeReportFromCustomer(nameOfCustomer, titleOfReport);
    }

    //GET ALL INVENTORS FOR CURRENT CUSTOMER -------------------------------------------------------
    @GetMapping("/{name}/inventors")
    @ApiOperation(value="Get all inventors for current customer")
    public List<ReturnInventorDTO> getAllInventors(@PathVariable final String name) {
	    return customerService.getAllInventorsForCustomer(name);
    }

    //GET ALL REPORTS FOR CURRENT HOLIDAY ----------------------------------------------------------
    @GetMapping("/{name}/reports")
    @ApiOperation(value="Get all reports for current customer")
    public List<Report> getAllReports(@PathVariable final String name) {
	    return customerService.getAllReportsForCustomer(name);
    }
	
}