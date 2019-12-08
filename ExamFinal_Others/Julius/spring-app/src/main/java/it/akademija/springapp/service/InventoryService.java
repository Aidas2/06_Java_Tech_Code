package it.akademija.springapp.service;


import it.akademija.springapp.dto.inventory.InventoryGetDTO;
import it.akademija.springapp.dto.inventory.InventoryPostDTO;
import it.akademija.springapp.entity.Inventory;
import it.akademija.springapp.entity.User;
import it.akademija.springapp.repository.InventoryRepository;
import it.akademija.springapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> add(InventoryPostDTO dto, String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(dto, inventory);
        inventoryRepository.save(inventory);
        user.getInventories().add(inventory);
        return ResponseEntity.ok(user);
    }

    @Transactional
    public ResponseEntity<?> deleteById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.status(404).body("User bot found");
        }
        userRepository.delete(user);
        return ResponseEntity.ok("User deleted");
    }

    @Transactional
    public ResponseEntity<?> update(String id, InventoryPostDTO dto) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory == null) {
            return ResponseEntity.status(404).body("Inventory not found");
        }
        BeanUtils.copyProperties(dto, inventory);
        inventoryRepository.save(inventory);
        return ResponseEntity.ok("Inventory updated");
    }

    @Transactional
    public List<InventoryGetDTO> findAll() {
        return inventoryRepository.findAll().stream().map(inventory -> {
            InventoryGetDTO dto = new InventoryGetDTO();
            BeanUtils.copyProperties(inventory, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public InventoryGetDTO getById(String id) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory != null) {
            InventoryGetDTO dto = new InventoryGetDTO();
            BeanUtils.copyProperties(inventory, dto);
            return dto;
        }
        return null;
    }

    @Transactional
    public List<String> getSectorCount() {
       return inventoryRepository.getSectorCount();
    }
}
