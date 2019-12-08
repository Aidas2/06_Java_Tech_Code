package lt.egzaminas.services;

import lt.egzaminas.dtos.ItemDto;
import lt.egzaminas.dtos.UserDto;
import lt.egzaminas.entities.User;
import lt.egzaminas.enums.UserType;
import lt.egzaminas.mappers.ItemMapper;
import lt.egzaminas.mappers.UserMapper;
import lt.egzaminas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto getById(String id) {
        return userMapper.mapToDto(userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found")));
    }

    @Transactional(readOnly = true)
    public List<ItemDto> getAllItems(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getItems()
                .stream()
                .map(itemMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(UserDto userDto) {
        User user = userMapper.mapToEntity(userDto);
        user.setUserType(UserType.valueOf(userDto.getUserType()));
        userRepository.save(userMapper.mapToEntity(userDto));
    }

    @Transactional
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(String id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        User updatedUser = userMapper.mapToEntity(userDto);
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
