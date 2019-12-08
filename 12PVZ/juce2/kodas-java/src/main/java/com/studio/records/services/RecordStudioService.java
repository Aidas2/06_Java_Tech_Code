package com.studio.records.services;

import com.studio.records.dto.PerformerGetDTO;
import com.studio.records.dto.RecordStudioGetDTO;
import com.studio.records.dto.RecordStudioPutDTO;
import com.studio.records.entities.Performer;
import com.studio.records.entities.RecordStudio;
import com.studio.records.entities.Song;
import com.studio.records.repositories.PerformerRepo;
import com.studio.records.repositories.RecordStudioRepo;
import com.studio.records.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordStudioService {

    @Autowired
    private RecordStudioRepo recordStudioRepo;
    @Autowired
    private PerformerRepo performerRepo;

    public RecordStudioService(RecordStudioRepo recordStudioRepo, PerformerRepo performerRepo) {
        this.recordStudioRepo = recordStudioRepo;
        this.performerRepo = performerRepo;
    }

    @Transactional(readOnly = true)
    public List<RecordStudioGetDTO> finadAllStudios() {
        return recordStudioRepo.findAll().stream().map(studio ->
                new RecordStudioGetDTO(studio.getTitle(),studio.getLogo(),studio.getCategory(),studio.getSize())
        ).collect(Collectors.toList());
    }

    @Transactional
    public void savePhoto(RecordStudioPutDTO studio) {
        RecordStudio recordStudio = new RecordStudio(studio.getTitle(), studio.getLogo(), studio.getCategory(), studio.getSize(),Collections.emptySet());
        recordStudioRepo.save(recordStudio);
    }

    @Transactional
    public RecordStudioGetDTO findByTitle(String title) {
        RecordStudio recordStudio = recordStudioRepo.findByTitle(title);
        if(recordStudio != null){
            return new RecordStudioGetDTO(recordStudio.getTitle(), recordStudio.getLogo(), recordStudio.getCategory(), recordStudio.getSize());
        }
        else {
            return null;
        }
    }

    @Transactional
    public void delete(String title) {
        recordStudioRepo.deleteByTitle(title);
    }

    @Transactional
    public List<PerformerGetDTO> getAllPerformers(String title) {
        RecordStudio recordStudio = recordStudioRepo.findByTitle(title);
        if(recordStudio != null){
            return recordStudio.getPerformers().stream().map(performer ->
                    new PerformerGetDTO(performer.getTitle(),
                            performer.getFirstName(),
                            performer.getLastName(),
                            performer.getGenre(),
                            performer.getCountry(),
                            performer.getDob(),
                            performer.getPicture())
            ).collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    public void update(String title, RecordStudioPutDTO recordStudioPutDTO) {
        RecordStudio recordStudio = recordStudioRepo.findByTitle(title);
        if(recordStudio != null){
            recordStudio.setTitle(recordStudioPutDTO.getTitle());
            recordStudio.setCategory(recordStudioPutDTO.getCategory());
            recordStudio.setLogo(recordStudioPutDTO.getLogo());
            recordStudio.setSize(recordStudioPutDTO.getSize());
        }
    }

    @Transactional
    public void addPerformer(String studio_title, String performer_title) {
        RecordStudio recordStudio = recordStudioRepo.findByTitle(studio_title);
        Performer performer = performerRepo.findByTitle(performer_title);
        if(recordStudio != null){
            recordStudio.getPerformers().add(performer);
        }
    }
}
