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

@Target({ElementType.PARAMETER,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default ValidationErrorConstants.EMAIL_NOT_UNIQUE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
