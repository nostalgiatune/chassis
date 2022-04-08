package fi.tuomas.chassis.loggingapi.aspect;

import org.springframework.stereotype.Component;
import fi.tuomas.chassis.loggingapi.annotation.Logged;

@Component
public class TestBean {

    @Logged
    public void logged() {

    }

    public void notLogged() {

    }
}
