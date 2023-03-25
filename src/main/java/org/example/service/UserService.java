package org.example.service;

import org.example.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(UserDto person);

    void delete(Long id);

    List<UserDto> getAllUsers();
}
