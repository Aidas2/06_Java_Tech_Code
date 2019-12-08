package lt.svs.services;

import java.util.List;
import java.util.stream.Collectors;

import lt.svs.dto.CreateCustomerDTO;
import lt.svs.dto.ReturnCustomerDTO;
import lt.svs.entities.Customer;
import lt.svs.entities.Inventor;
import lt.svs.entities.Report;
import lt.svs.repositories.InventorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.svs.dto.ReturnInventorDTO;
import lt.svs.repositories.CustomerRepository;
import lt.svs.repositories.ReportRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InventorRepository inventorRepository;

    @Autowired
    private ReportRepository reportRepository;

    public CustomerService(
            CustomerRepository customerRepository,
            InventorRepository inventorRepository, ReportRepository reportRepository) {
        super();
        this.customerRepository = customerRepository;
        this.inventorRepository = inventorRepository;
        this.reportRepository = reportRepository;
    }

    //GET ALL ------------------------------------------------------------
    @Transactional(readOnly = true)
    public List<ReturnCustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                                .stream()
                                .map((cust) -> new ReturnCustomerDTO(
                                        cust.getId(),
                                        cust.getName(),
                                        cust.getSurname(),
                                        cust.getBirthDate(),
                                        cust.getPhoneNumber(),
                                        cust.getType()
                                        //cust.getInventorsList(),
                                        //cust.getReportsList()
                                ))
                                .collect(Collectors.toList());
    }

    //GET BY TITLE ------------------------------------------------------------
    @Transactional(readOnly = true)
    public ReturnCustomerDTO findCustomerByName(String name) {
        Customer currentCustomer = customerRepository.findCustomerByName(name);
        return new ReturnCustomerDTO(
                currentCustomer.getId(),
                currentCustomer.getName(),
                currentCustomer.getSurname(),
                currentCustomer.getBirthDate(),
                currentCustomer.getPhoneNumber(),
                currentCustomer.getType());
                //currentCustomer.getInventorsList(),
                //currentCustomer.getReportsList());
    }

    //CREATE ------------------------------------------------------------
    @Transactional
    public void createCustomer(CreateCustomerDTO createCustomerDTO) {

		Customer newCustomer = new Customer(
				createCustomerDTO.getName(),
				createCustomerDTO.getSurname(),
				createCustomerDTO.getBirthDate(),
				createCustomerDTO.getPhoneNumber(),
				createCustomerDTO.getType());
              //createCustomerDTO.getInventorsList(),
              //createCustomerDTO.getReportsList());
		customerRepository.save(newCustomer);
    }

    //UPDATE ------------------------------------------------------------
    @Transactional
    public void updateCustomer(String name, CreateCustomerDTO createCustomerDTO) {
        Customer customerToUpdate = customerRepository.findCustomerByName(name);

        customerToUpdate.setName(createCustomerDTO.getName());
        customerToUpdate.setSurname(createCustomerDTO.getSurname());
        customerToUpdate.setBirthDate(createCustomerDTO.getBirthDate());
        customerToUpdate.setPhoneNumber(createCustomerDTO.getPhoneNumber());
        customerToUpdate.setType(createCustomerDTO.getType());
        //customerToUpdate.setInventorsList(createCustomerDTO.getInventorsList());
        //customerToUpdate.setReportsList(createCustomerDTO.getReportsList());
        customerRepository.save(customerToUpdate);
    }

    // DELETE ------------------------------------------------------------
    @Transactional
    public void deleteCustomer(String name) {
        customerRepository.deleteCustomerByName(name);
    }


    // ASSIGN ------------------------------------------------------------
    @Transactional
    public void addInventoryToCustomer(String nameOfCustomer, String titleOfInventory) {
        Customer customer = customerRepository.findCustomerByName(nameOfCustomer);
        Inventor inventor = inventorRepository.findInventorByTitle(titleOfInventory);
        if (customer != null) {
            customer.getInventorsList().add(inventor);
        }
    }

    @Transactional
    public void addReportToCustomer(String nameOfCustomer, String titleOfReport) {
        Customer customer = customerRepository.findCustomerByName(nameOfCustomer);
        Report report = reportRepository.findReportByTitle(titleOfReport);
        if (customer != null) {
            customer.getReportsList().add(report);
        }
    }

    // DE-ASSIGN ------------------------------------------------------------
    @Transactional
    public void removeInventoryFromCustomer(String nameOfCustomer, String titleOfInventory) {
        Customer customer = customerRepository.findCustomerByName(nameOfCustomer);
        Inventor inventor = inventorRepository.findInventorByTitle(titleOfInventory);
        if (customer != null) {
            customer.getInventorsList().remove(inventor);
        }
    }

    @Transactional
    public void removeReportFromCustomer(String nameOfCustomer, String titleOfReport) {
        Customer customer = customerRepository.findCustomerByName(nameOfCustomer);
        Report report = reportRepository.findReportByTitle(titleOfReport);
        if (customer != null) {
            customer.getReportsList().remove(report);
        }
    }

    //GET ALL INVENTORS FOR CURRENT CUSTOMER
    @Transactional
    public List<ReturnInventorDTO> getAllInventorsForCustomer (String nameOfCustomer) {
        Customer customer = customerRepository.findCustomerByName(nameOfCustomer);
        if(customer != null) {
            return customer.getInventorsList().stream()
                    .map(inventor -> new ReturnInventorDTO(
                            inventor.getId(),
                            inventor.getTitle(),
                            inventor.getWeight(),
                            inventor.getNumberOfSector(),
                            inventor.getPlacementDate()
                    )).collect(Collectors.toList());
        }
        return null;
    }

    //GET ALL REPORTS FOR CURRENT CUSTOMER
    @Transactional
    public List<Report> getAllReportsForCustomer (String nameOfCustomer) {
        Customer customer = customerRepository.findCustomerByName(nameOfCustomer);
        if(customer != null) {
            return customer.getReportsList().stream()
                    .map(report -> new Report(
                            report.getId(),
                            report.getTitle()
                    )).collect(Collectors.toList());
        }
        return null;
    }


}
