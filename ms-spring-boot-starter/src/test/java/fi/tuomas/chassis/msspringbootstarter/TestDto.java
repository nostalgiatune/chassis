package fi.tuomas.chassis.msspringbootstarter;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import fi.tuomas.chassis.validationapi.annotation.ValidEvenNumber;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDto implements Serializable {

    @ValidEvenNumber
    private int number;
}
