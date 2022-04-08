package fi.tuomas.chassis.baseentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import fi.tuomas.chassis.validationapi.annotation.ValidEvenNumber;

@Entity
@Builder
public class TestEntity extends Auditable {

    @Id
    private long id;

    @ValidEvenNumber
    private int number;
}
