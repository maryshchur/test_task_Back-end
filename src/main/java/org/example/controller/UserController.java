package org.example.controller;

import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.example.util.UniqueEmail;
import org.example.util.UniquePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:3001")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@Valid @NotEmpty @RequestParam("file") MultipartFile file,
                                 @NotBlank @Valid @RequestParam("firstName") String firstName,
                                 @NotBlank @Valid @RequestParam("lastName") String lastName,
                                 @NotBlank @Valid @Email @UniqueEmail @RequestParam("email") String email,
                                 @NotBlank @Valid @RequestParam("location") String location,
                                 @NotBlank @Valid @NumberFormat @UniquePhone @RequestParam("phone") String phone,
                                 @NotBlank @Valid @RequestParam("status") Boolean status) {
        userService.save(file, new CreateUserDto(firstName, lastName, email, location, phone, status));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

}
