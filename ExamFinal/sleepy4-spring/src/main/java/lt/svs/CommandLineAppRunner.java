package lt.svs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lt.svs.entities.Customer;
import lt.svs.entities.Inventor;
import lt.svs.enums.CustomerType;
import lt.svs.repositories.InventorRepository;
import lt.svs.repositories.CustomerRepository;
import lt.svs.repositories.ReportRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;

@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(CommandLineAppRunner.class);

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InventorRepository inventorRepository;
    @Autowired
    private ReportRepository reportRepository;

    public CommandLineAppRunner(
            CustomerRepository customerRepository,
            InventorRepository inventorRepository,
            ReportRepository reportRepository) {
        this.customerRepository = customerRepository;
        this.inventorRepository = inventorRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.warn("Deleting all information from in-memory database");
        customerRepository.deleteAllInBatch();
        inventorRepository.deleteAllInBatch();
        reportRepository.deleteAllInBatch();

        List<Customer> customers = Arrays.asList(
                new Customer("Jon", "Snow",new Date(1985, 8, 18), "+37064726287",
                        CustomerType.USUAL, Collections.emptySet(), Collections.emptySet()),
                new Customer("Tyrion", "Lannister",new Date(1976, 5, 23), "+37064726288",
                            CustomerType.USUAL, Collections.emptySet(), Collections.emptySet()),
                new Customer("Daenerys", "Targaryen",new Date(1995, 4, 15), "+37064726289",
                        CustomerType.LOYAL, Collections.emptySet(), Collections.emptySet())
        );

        customerRepository.saveAll(customers);
        logger.info("Creating new customers => {}", customers.toString());
//
//
        List<Inventor> inventors = Arrays.asList(
                new Inventor("Sword", 10.5, 5, new Date(2019, 4, 18), Collections.emptySet()),
                new Inventor("Crown", 2.5, 10, new Date(2019, 5, 18), Collections.emptySet()),
                new Inventor("Dragon", 10000.5, 40, new Date(2019, 6, 25), Collections.emptySet())
        );


        inventorRepository.saveAll(inventors);
        logger.info("Creating new countries => {}", inventors.toString());
    }
}
