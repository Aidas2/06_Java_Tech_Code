package it.akademija.springapp.service;

import it.akademija.springapp.config.ApiResponse;
import it.akademija.springapp.dto.inventory.InventoryGetDTO;
import it.akademija.springapp.dto.inventory.InventoryPostDTO;
import it.akademija.springapp.dto.user.UserGetDTO;
import it.akademija.springapp.dto.user.UserGetPageDTO;
import it.akademija.springapp.dto.user.UserPostDTO;
import it.akademija.springapp.entity.Inventory;
import it.akademija.springapp.entity.User;
import it.akademija.springapp.repository.InventoryRepository;
import it.akademija.springapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public ResponseEntity<?> add(UserPostDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        if(userRepository.existsByFirstNameAndLastNameAndDob(
                userDTO.getFirstName(), userDTO.getLastName(), userDTO.getDob()))
        {
            return new ResponseEntity<>(new ApiResponse(false, "User is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
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
    public ResponseEntity<?> update(String id, UserPostDTO userDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);
        return ResponseEntity.ok("User updated");
    }

    @Transactional
    public List<UserGetDTO> findAll() {
        return userRepository.findAll().stream().map(userEntity -> {
            UserGetDTO userGetDTO = new UserGetDTO();
            BeanUtils.copyProperties(userEntity, userGetDTO);
            return userGetDTO;
        }).collect(Collectors.toList());
    }

    @Transactional
    public List<InventoryGetDTO> getInventory(String id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }
        return user.getInventories().stream().map(inventory -> {
            InventoryGetDTO dto = new InventoryGetDTO();
            BeanUtils.copyProperties(inventory, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public UserGetDTO getById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            UserGetDTO userGetDTO = new UserGetDTO();
            BeanUtils.copyProperties(user, userGetDTO);
            return userGetDTO;
        }
        return null;
    }

    @Transactional
    public UserGetPageDTO getAll(Integer pageNumber, Integer pageLimit) {
        Pageable pageable;
        if(pageNumber != null && pageLimit != null){
            pageable = PageRequest.of(pageNumber, pageLimit);
        } else {
            pageable = PageRequest.of(0, Integer.MAX_VALUE);
        }
        Pageable page2 = PageRequest.of(0, Integer.MAX_VALUE);
        Page<User> pagedUsers = userRepository.findAll(page2);
        List<UserGetDTO> userList = pagedUsers.stream().map(user -> {
            UserGetDTO dto = new UserGetDTO();
            BeanUtils.copyProperties(user, dto);
            dto.setInventoryCount(user.getInventories().size());
            return dto;
        }).collect(Collectors.toList());
        return new UserGetPageDTO(userList,pagedUsers.getTotalElements(), pagedUsers.getTotalPages());
    }

    @Transactional
    public ResponseEntity<?> addInventory(String id, InventoryPostDTO dto) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(dto, inventory);
        inventoryRepository.save(inventory);
        user.getInventories().add(inventory);
        userRepository.save(user);
        return ResponseEntity.ok("Added");

    }

    @Transactional
    public ResponseEntity<?> deleteItem(String userId, String itemId) {
        User user = userRepository.findById(userId).orElse(null);
        Inventory inventory = inventoryRepository.findById(itemId).orElse(null);
        if(user == null || inventory == null) {
            return ResponseEntity.notFound().build();
        }
        user.getInventories().remove(inventory);
        inventoryRepository.delete(inventory);

        return ResponseEntity.ok("Removed");
    }

//    @Transactional
//    public List<ProjectGetDTO> getUserProject(String username) {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            return new ArrayList<ProjectGetDTO>();
//        }
//        return user.getProjects().stream().map(projectEntity -> {
//            ProjectGetDTO dto = new ProjectGetDTO();
//            BeanUtils.copyProperties(projectEntity, dto);
//            return dto;
//        }).collect(Collectors.toList());
//    }
//
//    @Transactional
//    public ResponseEntity<?> addProject(String username, String project_id) {
//        User user = userRepository.findByUsername(username);
//        ProjectEntity project = projectRepository.findById(project_id).orElse(null);
//        if (user != null && project != null) {
//            if (!user.getProjects().contains(project)) {
//                user.getProjects().add(project);
//                project.getUsers().add(user);
//                userRepository.save(user);
//                projectRepository.save(project);
//                return ResponseEntity.ok("Project added successfully");
//            }
//            return ResponseEntity.status(400).body("Project already exists");
//        }
//        return ResponseEntity.status(404).body("Error adding project to user");
//    }
//
//    @Transactional
//    public ResponseEntity<?> removeProject(String username, String project_id) {
//        User user = userRepository.findByUsername(username);
//        ProjectEntity project = projectRepository.findById(project_id).orElse(null);
//        if (user != null && project != null) {
//            user.getProjects().remove(project);
//            return ResponseEntity.ok("Removed");
//        }
//        return ResponseEntity.status(404).body("Error");
//    }
//
//    @Transactional
//    public List<UserListDTO> getUserList() {
//        return userRepository.getUserList();
//    }
//
//    @Transactional
//    public UserPageGetCommand getPagedList(Integer pageNumber, Integer pageLimit) {
//        Pageable pageable;
//        if(pageNumber != null && pageLimit != null){
//            pageable = PageRequest.of(pageNumber, pageLimit);
//        } else {
//            pageable = PageRequest.of(0, Integer.MAX_VALUE);
//        }
//        Page<User> pagedUsers = userRepository.findAll(pageable);
//        List<UserGetDTO> userList = pagedUsers.stream().map(userEntity -> {
//            UserGetDTO dto = new UserGetDTO();
//            BeanUtils.copyProperties(userEntity, dto);
//            return dto;
//        }).collect(Collectors.toList());
//        return new UserPageGetCommand(userList, pagedUsers.getTotalElements(), pagedUsers.getTotalPages());
//    }
}
