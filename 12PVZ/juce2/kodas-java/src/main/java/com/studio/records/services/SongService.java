package com.studio.records.services;

import com.studio.records.dto.SongGetDTO;
import com.studio.records.dto.SongPutDTO;
import com.studio.records.entities.Performer;
import com.studio.records.entities.Song;
import com.studio.records.repositories.PerformerRepo;
import com.studio.records.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepo songRepo;
    @Autowired
    private PerformerRepo performerRepo;

    public SongService(SongRepo songRepo, PerformerRepo performerRepo) {
        this.songRepo = songRepo;
        this.performerRepo = performerRepo;
    }

    @Transactional(readOnly = true)
    public List<SongGetDTO> getAllSongs() {
        return songRepo.findAll().stream().map(song ->
                new SongGetDTO(song.getId() ,song.getTitle(), song.getAlbum(), song.getLength(),song.getMp3())).collect(Collectors.toList());
    }

    @Transactional
    public SongGetDTO getById(Long id) {
        Song song = songRepo.findById(id).orElse(null);
        if (song != null) {
            return new SongGetDTO(song.getId() ,song.getTitle(), song.getAlbum(), song.getLength(),song.getMp3());
        }
        return null;
    }

    @Transactional
    public void saveSong(SongPutDTO songDTO) {
        Song song = new Song();
        song.setTitle(songDTO.getTitle());
        song.setAlbum(songDTO.getAlbum());
        song.setLength(songDTO.getLength());
        song.setMp3(songDTO.getMp3());
        song.setPerformers(Collections.emptySet());
        songRepo.save(song);
    }

    @Transactional
    public void deleteSongById(Long id) {
        songRepo.deleteById(id);
    }

    @Transactional
    public void addSongToPerformer(long song_id, String performer_id) {
        Performer performer = performerRepo.findByTitle(performer_id);
        Song song = songRepo.getOne(song_id);
        if(performer != null){
            performer.getSongs().add(song);
        }
    }

    @Transactional
    public void updateSong(long id, SongPutDTO songPutDTO) {
        Song song = songRepo.findById(id).orElse(null);
        if (song != null){
            song.setTitle(songPutDTO.getTitle());
            song.setLength(songPutDTO.getLength());
            song.setMp3(songPutDTO.getMp3());
            song.setAlbum(songPutDTO.getAlbum());
        }
    }
}
