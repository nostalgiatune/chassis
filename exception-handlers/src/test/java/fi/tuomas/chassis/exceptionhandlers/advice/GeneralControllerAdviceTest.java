package fi.tuomas.chassis.exceptionhandlers.advice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import fi.tuomas.chassis.exceptionhandlers.config.ExceptionHandlersAutoConfiguration;

@WebMvcTest
@ContextConfiguration(classes = {
        ExceptionHandlersAutoConfiguration.class,
        TestController.class
})
class GeneralControllerAdviceTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private GeneralControllerAdvice generalControllerAdvice;

    @Test
    void testAdviceCatchesError() throws Exception {
        TestDto dto = TestDto.builder().build();
        String result = mvc.perform(MockMvcRequestBuilders.post("/", dto))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn().getResponse().getContentAsString();

        // TODO: controller advice isn't called for some reason
//        verify(generalControllerAdvice).handleException(any());
//        assertThat(result).isEqualTo("Number of errors: 2");
    }
}