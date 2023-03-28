package org.example.service;

import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    void save(MultipartFile file, CreateUserDto person);

    void delete(Long id);

    List<UserDto> getAllUsers();
}
