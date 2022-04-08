package fi.tuomas.chassis.validationapi.validator;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.Test;
import fi.tuomas.chassis.validationapi.annotation.ValidEvenNumber;

class EvenNumberValidatorTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testEvenNumber() {
        EvenNumberValidatorTestDto dto = EvenNumberValidatorTestDto.builder().value(2).build();
        Set<ConstraintViolation<EvenNumberValidatorTestDto>> violations = validator.validate(dto);
        assertThat(violations).isEmpty();
    }

    @Test
    void testOddNumber() {
        EvenNumberValidatorTestDto dto = EvenNumberValidatorTestDto.builder().value(1).build();
        Set<ConstraintViolation<EvenNumberValidatorTestDto>> violations = validator.validate(dto);
        assertThat(violations).isNotEmpty();
        assertThat(violations).anyMatch(v -> ValidEvenNumber.MESSAGE.equalsIgnoreCase(v.getMessage()));
    }
}