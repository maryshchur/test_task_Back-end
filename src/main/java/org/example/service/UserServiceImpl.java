package org.example.service;

import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.exception.CustomException;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        ;
    }

    @Override
    public void save(UserDto user) {
        userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
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
