package fi.tuomas.chassis.loggingapi.aspect;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import fi.tuomas.chassis.loggingapi.config.LoggingAutoConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TestBean.class,
        LoggingAutoConfiguration.class
})
class LoggingAspectTest {

    @SpyBean
    private LoggingAspect loggingAspect;

    @Autowired
    private TestBean testBean;

    @Test
    void testLoggingAspectHandlesAnnotatedMethod() throws Throwable {
        testBean.logged();
        verify(loggingAspect).log(any());
    }

    @Test
    void testLoggingAspectIgnoresUnannotatedMethod() throws Throwable {
        testBean.notLogged();
        verify(loggingAspect, never()).log(any());
    }
}