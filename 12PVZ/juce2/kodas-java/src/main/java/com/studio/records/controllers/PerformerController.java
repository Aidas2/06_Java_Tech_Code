package com.studio.records.controllers;

import com.studio.records.dto.PerformerGetDTO;
import com.studio.records.dto.PerformerPutDTO;
import com.studio.records.dto.SongGetDTO;
import com.studio.records.services.PerformerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performers")
public class PerformerController {

    @Autowired
    private PerformerService performerService;

    public PerformerController(PerformerService performerService) {
        this.performerService = performerService;
    }

    @GetMapping
    @ApiOperation(value = "Get all performers")
    public List<PerformerGetDTO> findAllPerformers() {
        return performerService.findAll();
    }

    @GetMapping("/{title}")
    @ApiOperation(value = "Get performer by title")
    public PerformerGetDTO findPerformerByTitle(@PathVariable final String title) {
        return performerService.findByTitle(title);
    }

    @DeleteMapping("/{title}")
    @ApiOperation(value = "Delete performer by title")
    public void deletePerformerByTitle(@PathVariable final String title) {
        performerService.deleteByTitle(title);
    }

    @PostMapping
    @ApiOperation(value = "Add new performer")
    public void save(@RequestBody final PerformerPutDTO putDTO){
        performerService.savePerformer(putDTO);
    }

    @GetMapping("/{title}/songs")
    @ApiOperation(value = "Get all songs")
    public List<SongGetDTO> getAllSongs(@PathVariable final String title){
        return performerService.getAllSongs(title);
    }


    @PutMapping("/{title}")
    @ApiOperation(value = "Update performer")
    public void updatePerformer(@PathVariable final String title, @RequestBody PerformerPutDTO putDTO){
        performerService.updatePerformer(title, putDTO);
    }

}
