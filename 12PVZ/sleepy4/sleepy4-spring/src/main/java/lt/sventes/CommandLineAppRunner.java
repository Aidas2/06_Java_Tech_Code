package lt.sventes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;
import lt.sventes.enums.HolidayType;
import lt.sventes.repositories.CountryRepository;
import lt.sventes.repositories.HolidayRepository;
import lt.sventes.repositories.YearsRepository;

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
    private HolidayRepository holidayRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private YearsRepository yearsRepository;

    public CommandLineAppRunner(
            HolidayRepository holidayRepository,
            CountryRepository countryRepository,
            YearsRepository yearsRepository) {
        this.holidayRepository = holidayRepository;
        this.countryRepository = countryRepository;
        this.yearsRepository = yearsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.warn("Deleting all information from in-memory database");
        holidayRepository.deleteAllInBatch();
        countryRepository.deleteAllInBatch();
        yearsRepository.deleteAllInBatch();

        List<Holiday> holidays = Arrays.asList(
                new Holiday("Velykos", "Pavasarinė atgimimo šventė", HolidayType.PUBLIC, "absent1",
                            TRUE,
                            new Date(2017, 7, 17)
                        , 100, 200, Collections.emptySet(), Collections.emptySet()),
                new Holiday("Joninės", "Ilgiausia diena, trumpiausia naktis",
                            HolidayType.NATIONAL_RELIGIOUS,
                            "absent2", TRUE,
                            new Date(2018, 8, 18)
                        , 102, 202, Collections.emptySet(), Collections.emptySet()),
                new Holiday("Kalėdos", "Gimtadienis ir dovanos", HolidayType.MEMORIAL, "absent3",
                            TRUE,
                            new Date(2019, 06, 23)
                        , 103, 203, Collections.emptySet(), Collections.emptySet())
        );

        holidayRepository.saveAll(holidays);
        logger.info("Creating new holidays => {}", holidays.toString());
//
//
        List<Country> countries = Arrays.asList(
                new Country("Lietuva", "absent4", "Nauseda", 1000.5, 3000000L,
                            Collections.emptySet()),
                new Country("Latvija", "absent5", "Janis", 999.5, 2000000L,
                            Collections.emptySet()),
                new Country("Estija", "absent6", "Kiuliamaja", 888.5, 2500000L,
                            Collections.emptySet())
        );


        countryRepository.saveAll(countries);
        logger.info("Creating new countries => {}", countries.toString());
    }
}
