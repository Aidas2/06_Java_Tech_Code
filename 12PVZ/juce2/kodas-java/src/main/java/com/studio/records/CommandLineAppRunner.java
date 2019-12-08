package com.studio.records;

import com.studio.records.configs.Category;
import com.studio.records.entities.RecordStudio;
import com.studio.records.entities.Performer;
import com.studio.records.repositories.PerformerRepo;
import com.studio.records.repositories.SongRepo;
import com.studio.records.repositories.RecordStudioRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(CommandLineAppRunner.class);

    @Autowired
    private RecordStudioRepo recordStudioRepo;
    @Autowired
    private PerformerRepo performerRepo;
    @Autowired
    private SongRepo songRepo;

    public CommandLineAppRunner(RecordStudioRepo recordStudioRepo, PerformerRepo performerRepo, SongRepo songRepo) {
        this.recordStudioRepo = recordStudioRepo;
        this.performerRepo = performerRepo;
        this.songRepo = songRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.warn("Deleting all information from in-memory database");
        recordStudioRepo.deleteAllInBatch();
        performerRepo.deleteAllInBatch();
        songRepo.deleteAllInBatch();




        List<Performer> performers = Arrays.asList(
                new Performer("Queen","Freddy","Mercury", "Rock", "Uk", new Date(), null,Collections.emptySet(),Collections.emptySet()),
                new Performer("Linkin Park","Chester","Bennington", "Rock", "USA", new Date(), null,Collections.emptySet(),Collections.emptySet()));
        performerRepo.saveAll(performers);
        logger.info("Creating new performers => {}", performers.toString());
//
//
        List<RecordStudio> recordStudios = Arrays.asList(
                new RecordStudio("My home", "null", Category.Home, 20.0,Collections.emptySet()),
                new RecordStudio("Banginis", "null", Category.Live, 25.0,Collections.emptySet()),
                new RecordStudio("Inside My Car", "null", Category.Live,10.2, Collections.emptySet()),
                new RecordStudio("Youtube", "null",Category.Live ,1009.9, Collections.emptySet())
        );
        logger.info("Creating new record studios => {}", recordStudios.toString());
        recordStudioRepo.saveAll(recordStudios);


    }
}
