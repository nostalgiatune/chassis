package fi.tuomas.chassis.loggingapi.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fi.tuomas.chassis.loggingapi.annotation.Audited;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    @Audited
    public String audited() {
        return "ok";
    }

    @GetMapping("test")
    public String notAudited() {
        return "ok";
    }
}
