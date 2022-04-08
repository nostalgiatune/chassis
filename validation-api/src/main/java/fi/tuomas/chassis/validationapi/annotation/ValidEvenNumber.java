package fi.tuomas.chassis.validationapi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import fi.tuomas.chassis.validationapi.validator.EvenNumberValidator;

@Documented
@Constraint(validatedBy = {EvenNumberValidator.class})
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEvenNumber {

    public static final String MESSAGE = "Value is not even number";

    String message() default MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
