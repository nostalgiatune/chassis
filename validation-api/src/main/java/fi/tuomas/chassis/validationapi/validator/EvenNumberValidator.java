package fi.tuomas.chassis.validationapi.validator;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import fi.tuomas.chassis.validationapi.annotation.ValidEvenNumber;

public class EvenNumberValidator implements ConstraintValidator<ValidEvenNumber, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return Objects.nonNull(value) && value % 2 == 0;
    }
}
