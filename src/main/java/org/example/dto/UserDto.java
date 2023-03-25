package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public String imageUrl;

    @NotBlank
    @Email
    private String email;

    @Column
    private String location;

    @NotBlank
    private String phone;

    private boolean status;

}
