package fi.tuomas.chassis.loggingapi.interceptor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import fi.tuomas.chassis.loggingapi.config.AuditAutoConfiguration;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        AuditAutoConfiguration.class,
        TestController.class
})
class AuditInterceptorTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private AuditInterceptor auditInterceptor;

    @Test
    public void testAudited() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andReturn();

        verify(auditInterceptor).preHandle(any(), any(), any());
        verify(auditInterceptor).postHandle(any(), any(), any(), any());
    }

    @Test
    public void testNotAudited() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test"))
                .andReturn();

        // TODO: verify audit log is not produced

        verify(auditInterceptor).preHandle(any(), any(), any());
        verify(auditInterceptor).postHandle(any(), any(), any(), any());
    }
}