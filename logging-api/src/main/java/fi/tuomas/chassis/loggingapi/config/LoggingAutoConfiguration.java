package fi.tuomas.chassis.loggingapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import fi.tuomas.chassis.loggingapi.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAutoConfiguration {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
