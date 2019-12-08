package lt.egzaminas.mappers;

import lt.egzaminas.dtos.UserDto;
import lt.egzaminas.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserMapper {

    public UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setItemCount(user.getItems().size());
        userDto.setUserId(user.getId());
        return userDto;
    }

    public User mapToEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setDateOfBirth(new Date(userDto.getBirthYear(), userDto.getBirthMonth(), userDto.getBirthDay()));
        return user;
    }
}
