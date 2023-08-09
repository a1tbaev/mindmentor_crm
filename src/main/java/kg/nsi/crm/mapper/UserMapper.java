package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.UserDto;
import kg.nsi.crm.entity.User;

public class UserMapper {

    public static UserDto entityToDto(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
