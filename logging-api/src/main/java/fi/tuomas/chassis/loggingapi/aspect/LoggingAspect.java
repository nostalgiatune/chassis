package fi.tuomas.chassis.loggingapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // TODO: property and logic
    @Value("${fi.tuomas.chassis.loggingapi.packages}")
    private String loggedTopLevelPackage;

    @Around("@annotation(fi.tuomas.chassis.loggingapi.annotation.Logged)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Invoking {} with args {}", pjp.getTarget(), pjp.getArgs());
        return pjp.proceed();
    }
}
