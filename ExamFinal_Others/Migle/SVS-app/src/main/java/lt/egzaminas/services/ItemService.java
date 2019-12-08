package lt.egzaminas.services;

import lt.egzaminas.entities.Item;
import lt.egzaminas.entities.User;
import lt.egzaminas.mappers.ItemMapper;
import lt.egzaminas.repositories.ItemRepository;
import lt.egzaminas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.egzaminas.dtos.*;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Transactional(readOnly = true)
    public List<ItemDto> getAll() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @Transactional
    public ItemDto getById(String id) {
        return itemMapper.mapToDto(itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found")));
    }

    @Transactional
    public void create(ItemDto itemDto) {
        User user = userRepository.findById(itemDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Item item = itemMapper.mapToEntity(itemDto);
        item.setUser(user);
        item.setStoringDt(new Date());
        user.getItems().add(item);
        itemRepository.save(item);
    }

    @Transactional
    public void delete(String id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        item.getUser().getItems().remove(item);
        itemRepository.delete(item);
    }

    @Transactional
    public void update(String id, ItemDto itemDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        Item updatedItem = new Item();
        updatedItem = itemMapper.mapToEntity(itemDto);
        updatedItem.setUser(item.getUser());
        updatedItem.setId(id);
        itemRepository.save(updatedItem);
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
