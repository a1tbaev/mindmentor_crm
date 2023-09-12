package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.UserDto;
import kg.nsi.crm.entity.User;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.UserMapper;
import kg.nsi.crm.repository.UserRepository;
import kg.nsi.crm.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUserById(Long userId) {
        return UserMapper.entityToDto(getUserEntityById(userId));
    }

    @Override
    public User getUserEntityById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(String.format("User with id %s is not found!", userId)));
    }
}
