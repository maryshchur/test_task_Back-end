package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.UniqueEmail;
import org.example.util.UniquePhone;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    @NotBlank
    private String location;

    @NotBlank
    @NumberFormat
    @UniquePhone
    private String phone;

    @NotBlank
    private boolean status;

}