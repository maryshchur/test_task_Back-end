package org.example.config;

import org.example.dto.UserDto;
import org.example.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.typeMap(User.class, UserDto.class).setPreConverter(context ->
//        {
//            UserDto userDto = context.getDestination();
//            userDto.setImageUrl("http://localhost:8090/images/" + context.getSource().getImageUrl());
//            return userDto;
//        });
        return modelMapper;
    }
}
