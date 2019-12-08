package lt.egzaminas.mappers;

import lt.egzaminas.entities.Item;
import lt.egzaminas.dtos.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {

    public ItemDto mapToDto(Item item) {
        ItemDto itemDto = new ItemDto();
        BeanUtils.copyProperties(item, itemDto);
        itemDto.setItemId(item.getId());
        itemDto.setUserId(item.getUser().getId());
        return itemDto;
    }

    public Item mapToEntity(ItemDto itemDto) {
        Item item = new Item();
        BeanUtils.copyProperties(itemDto, item);
        return item;
    }
}
