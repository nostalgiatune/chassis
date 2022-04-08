package fi.tuomas.chassis.exceptionhandlers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import fi.tuomas.chassis.exceptionhandlers.advice.GeneralControllerAdvice;

@Configuration
public class ExceptionHandlersAutoConfiguration {

    @Bean
    public GeneralControllerAdvice generalControllerAdvice() {
        return new GeneralControllerAdvice();
    }
}
