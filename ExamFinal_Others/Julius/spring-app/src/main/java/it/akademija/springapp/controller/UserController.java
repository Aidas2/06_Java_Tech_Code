package it.akademija.springapp.controller;

import it.akademija.springapp.dto.inventory.InventoryGetDTO;
import it.akademija.springapp.dto.inventory.InventoryPostDTO;
import it.akademija.springapp.dto.user.UserGetDTO;
import it.akademija.springapp.dto.user.UserGetPageDTO;
import it.akademija.springapp.dto.user.UserPostDTO;
import it.akademija.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserGetDTO getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @GetMapping()
    public UserGetPageDTO getAll(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageLimit", required = false) Integer pageLimit
    ) {
        return userService.getAll(pageNumber, pageLimit);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateById(@RequestBody final UserPostDTO userDTO, @PathVariable String id) {
        return userService.update(id, userDTO);
    }

    @PutMapping()
    public ResponseEntity<?> add(@RequestBody final UserPostDTO userDTO) {
        return userService.add(userDTO);
    }

    @PutMapping("/{id}/inventory")
    public ResponseEntity<?> addInventory(@PathVariable String id, @RequestBody final InventoryPostDTO dto) {
        return userService.addInventory(id, dto);
    }

    @GetMapping("/{id}/inventory")
    public List<InventoryGetDTO> getInventory(@PathVariable String id) {
        return userService.getInventory(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByUsername(@PathVariable String id) {
        return userService.deleteById(id);
    }

    @DeleteMapping("/{userId}/inventory/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable String userId, @PathVariable String itemId) {
        return userService.deleteItem(userId, itemId);
    }

}
