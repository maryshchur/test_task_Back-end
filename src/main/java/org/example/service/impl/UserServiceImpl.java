package org.example.service.impl;

import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.exception.CustomException;
import org.example.repository.UserRepository;
import org.example.service.FileStorageService;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private FileStorageService fileStorageService;
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserServiceImpl(FileStorageService fileStorageService,
                           UserRepository userRepository) {
        this.fileStorageService = fileStorageService;
        this.userRepository = userRepository;
        ;
    }

    @Override
    public void save(MultipartFile file, CreateUserDto user) {
        User u = modelMapper.map(user, User.class);
        u.setImageUrl(fileStorageService.saveFile(file));
        userRepository.save(u);

    }

    @Override
    public void delete(Long id) {
        String image = userRepository.getUserById(id).getImageUrl();
        try {
            userRepository.deleteById(id);
            fileStorageService.deleteFile(image);
        } catch (Exception e) {
            throw new CustomException("Due to some error user was not deleted");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(x -> modelMapper.map(x, UserDto.class)).
                collect(Collectors.toList());
    }
}
