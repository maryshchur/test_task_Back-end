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
        modelMapper.typeMap(User.class, UserDto.class).setPostConverter(context ->
        {
            UserDto userDto = context.getDestination();
            System.out.println(context.getSource());
            System.out.println(context.getSource().getImageUrl());
            System.out.println(userDto);
            System.out.println("modelMapperdddddddddddddddddddddddddddd");
            userDto.setImageUrl("http://localhost:8090/images/" + context.getSource().getImageUrl());
            return userDto;
        });
        return modelMapper;
    }
}
