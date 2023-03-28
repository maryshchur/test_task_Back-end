package org.example.util;

import org.example.constants.ValidationErrorConstants;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface UniquePhone {
    String message() default ValidationErrorConstants.PHONE_NOT_UNIQUE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
