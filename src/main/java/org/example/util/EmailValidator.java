package org.example.util;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserRepository userRepository;

    @Autowired
    public EmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        System.out.println("UniqueEmail");
        System.out.println(userRepository.existsUserByEmail(email.trim().toLowerCase()) );
        return userRepository.existsUserByEmail(email.trim().toLowerCase()) ? true : false;
    }
}
