package com.studio.records.controllers;

import com.studio.records.dto.SongGetDTO;
import com.studio.records.dto.SongPutDTO;
import com.studio.records.services.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Song controller")
@RequestMapping("/api/songs")
public class SongController {


    @Autowired
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    //Get All songs
    @GetMapping
    @ApiOperation(value = "Get all songs", notes = "Returns all songs from server")
    public List<SongGetDTO> getAllTag(){
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public SongGetDTO getById(
            @ApiParam(value = "id", required = true)
            @PathVariable long id){
        return songService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "Save new song")
    public void save(@RequestBody SongPutDTO song){
        songService.saveSong(song);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove song by id")
    public void deleteSongById(@ApiParam(value = "id",required = true) @PathVariable final long id){
        songService.deleteSongById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update song")
    public void updateSong(@PathVariable final long id, @RequestBody SongPutDTO songPutDTO){
        songService.updateSong(id, songPutDTO);
    }

    @PutMapping("/{song_id}/{performer_id}")
    @ApiOperation(value = "Add a song to performer")
    public void addSongToPerformer(@PathVariable final long song_id, @PathVariable final String performer_id){
        songService.addSongToPerformer(song_id,performer_id);
    }

}
