package kg.nsi.crm.service;

import kg.nsi.crm.dto.UserDto;
import kg.nsi.crm.entity.User;

public interface UserService {

    UserDto getUserById(Long userId);
    User getUserEntityById(Long userId);
    // more methods
}
