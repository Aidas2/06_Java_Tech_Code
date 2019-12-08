package com.studio.records.controllers;

import com.studio.records.dto.PerformerGetDTO;
import com.studio.records.dto.RecordStudioGetDTO;
import com.studio.records.dto.RecordStudioPutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.studio.records.services.RecordStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Photos")
@RequestMapping(value = "/api/studios")
public class StudioRecordController {

    @Autowired
    private RecordStudioService recordStudioService;

    public StudioRecordController(RecordStudioService recordStudioService) {
        this.recordStudioService = recordStudioService;
    }
    //Get All Studios
    @GetMapping
    @ApiOperation(value = "Get all studios", notes = "Returns studios dto from database")
    public List<RecordStudioGetDTO> findAllStudios(){
       return recordStudioService.finadAllStudios();
    }
    //Get RecordStudio by Title
    @GetMapping(value = "/{title}")
    @ApiOperation(value = "Get studio by ititle", notes = "Returns specific studio by title")
    public RecordStudioGetDTO findByTitle(
            @PathVariable final String title){
       return recordStudioService.findByTitle(title);
    }
    //Save new studio
    @PostMapping
    @ApiOperation(value = "Save new record studio", notes = "Crates new record studio and saves to database")
    public void save(
            @RequestBody
            final RecordStudioPutDTO putDTO){
        recordStudioService.savePhoto(putDTO);
    }

    @PutMapping("/{title}")
    @ApiOperation(value = "Update existing studio")
    public void update(@PathVariable final String title, @RequestBody RecordStudioPutDTO recordStudioPutDTO){
        recordStudioService.update(title, recordStudioPutDTO);
    }

    @DeleteMapping("/{title}")
    @ApiOperation(value = "Delete studio by title")
    public void delete(@PathVariable final String title){
        recordStudioService.delete(title);
    }

    @GetMapping("/{title}/all-performers")
    @ApiOperation(value = "Get all performers for studio")
    public List<PerformerGetDTO> getAllPerformers(@PathVariable final String title){
        return recordStudioService.getAllPerformers(title);
    }

    @PutMapping("/{studio_title}/{performer_title}")
    @ApiOperation(value = "Add performer to a studio")
    public void addPerformer(@PathVariable final String studio_title, @PathVariable final String performer_title){
        recordStudioService.addPerformer(studio_title,performer_title);

    }

}
