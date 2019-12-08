package com.studio.records.services;

import com.studio.records.dto.PerformerGetDTO;
import com.studio.records.dto.PerformerPutDTO;
import com.studio.records.dto.SongGetDTO;
import com.studio.records.entities.Performer;
import com.studio.records.entities.RecordStudio;
import com.studio.records.repositories.PerformerRepo;
import com.studio.records.repositories.RecordStudioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformerService {

    @Autowired
    private RecordStudioRepo recordStudioRepo;
    @Autowired
    private PerformerRepo performerRepo;

    public PerformerService(RecordStudioRepo recordStudioRepo, PerformerRepo performerRepo) {
        this.recordStudioRepo = recordStudioRepo;
        this.performerRepo = performerRepo;
    }

    @Transactional
    public List<PerformerGetDTO> findAll() {
        return performerRepo.findAll().stream().map(performer ->
                new PerformerGetDTO(performer.getTitle(),
                        performer.getFirstName(),
                        performer.getLastName(),
                        performer.getGenre(),
                        performer.getCountry(),
                        performer.getDob(),
                        performer.getPicture())
        ).collect(Collectors.toList());
    }

    @Transactional
    public PerformerGetDTO findByTitle(String title) {
        Performer performer = performerRepo.findByTitle(title);
        if (performer != null) {
            return new PerformerGetDTO(performer.getTitle(),
                    performer.getFirstName(),
                    performer.getLastName(),
                    performer.getGenre(),
                    performer.getCountry(),
                    performer.getDob(),
                    performer.getPicture());
        }
        return null;
    }

    @Transactional
    public void deleteByTitle(String title) {
        performerRepo.deleteByTitle(title);
    }


    @Transactional
    public void savePerformer(PerformerPutDTO putDTO) {
        Performer performer = new Performer();
        performer.setTitle(putDTO.getTitle());
        performer.setFirstName(putDTO.getFirstName());
        performer.setLastName(putDTO.getLastName());
        performer.setGenre(putDTO.getGenre());
        performer.setCountry(putDTO.getCountry());
        performer.setDob(putDTO.getDob());
        performer.setPicture(putDTO.getPicture());
        performerRepo.save(performer);
    }

    @Transactional
    public List<SongGetDTO> getAllSongs(String title) {
        Performer performer = performerRepo.findByTitle(title);
        if(performer != null){
            return performer.getSongs().stream().map(song ->
                    new SongGetDTO(song.getId(),song.getTitle(),song.getAlbum(),song.getLength(),song.getMp3())
                    ).collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    public void updatePerformer(String title, PerformerPutDTO putDTO) {
        Performer performer = performerRepo.findByTitle(title);
        if(performer!= null){
            performer.setFirstName(putDTO.getFirstName());
            performer.setLastName(putDTO.getLastName());
            performer.setPicture(putDTO.getPicture());
            performer.setDob(putDTO.getDob());
            performer.setCountry(putDTO.getCountry());
            performer.setGenre(putDTO.getGenre());
        }
    }
}