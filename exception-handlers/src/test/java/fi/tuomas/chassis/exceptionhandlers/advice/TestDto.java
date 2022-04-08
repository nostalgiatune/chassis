package fi.tuomas.chassis.exceptionhandlers.advice;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {

    @NotBlank
    private String foo;

    @NotBlank
    private String bar;
}
