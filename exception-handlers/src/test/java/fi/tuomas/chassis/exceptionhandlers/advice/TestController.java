package fi.tuomas.chassis.exceptionhandlers.advice;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @PostMapping
    public String test(@Valid @RequestBody TestDto testDto) {
        return "ok";
    }
}
