package fi.tuomas.chassis.validationapi.validator;

import lombok.Builder;
import lombok.Value;
import fi.tuomas.chassis.validationapi.annotation.ValidEvenNumber;

@Value
@Builder
public class EvenNumberValidatorTestDto {

    @ValidEvenNumber
    int value;
}
