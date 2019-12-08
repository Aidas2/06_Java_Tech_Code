package it.akademija.springapp.controller;

import it.akademija.springapp.dto.inventory.InventoryGetDTO;
import it.akademija.springapp.dto.inventory.InventoryPostDTO;
import it.akademija.springapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inv")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/sectorCount")
    public List<String> getSectorCount(){
        return inventoryService.getSectorCount();
    }

    @GetMapping("/{id}")
    public InventoryGetDTO getById(@PathVariable String id){
        return inventoryService.getById(id);
    }

    @GetMapping("/{id}/inventory")
    public List<InventoryGetDTO> get(@PathVariable String id){
        return inventoryService.findAll();
    }

//    @GetMapping("/list")
//    public List<UserListDTO> getUserList(){
//        return userService.getUserList();
//    }

//    @GetMapping()
//    public UserPageGetCommand getPagedList(
//            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
//            @RequestParam(value = "pageLimit", required = false) Integer pageLimit
//            ){
//        return userService.getPagedList(pageNumber, pageLimit);
//    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateById(@RequestBody final InventoryPostDTO userDTO, @PathVariable String id){
        return inventoryService.update(id, userDTO);
    }

    // All put mapping
    @PutMapping("/{id}")
    public ResponseEntity<?> add(@RequestBody final InventoryPostDTO dto, @PathVariable String id){
        return inventoryService.add(dto, id);
    }

//    @PutMapping("{username}/{project_id}")
//    public ResponseEntity<?> addProject(@PathVariable String username, @PathVariable String project_id){
//        return userService.addProject(username, project_id);
//    }
//
//    // All delete mapping
//    @DeleteMapping("{username}/{project_id}")
//    public ResponseEntity<?> removeProject(@PathVariable String username, @PathVariable String project_id){
//        return userService.removeProject(username, project_id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        return inventoryService.deleteById(id);
    }
}
