package fi.tuomas.chassis.msspringbootstarter;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import fi.tuomas.chassis.exceptionhandlers.advice.GeneralControllerAdvice;
import fi.tuomas.chassis.loggingapi.aspect.LoggingAspect;
import fi.tuomas.chassis.loggingapi.interceptor.AuditInterceptor;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Slf4j
class MsSpringBootStarterApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper json;

	@Autowired
	private AuditInterceptor auditInterceptor;

	@Autowired
	private LoggingAspect loggingAspect;

	@Autowired
	private GeneralControllerAdvice generalControllerAdvice;

	@Test
	void contextLoads() {
	}

	@Test
	void controllerWorks() throws Exception {
		TestDto dto = TestDto.builder().number(2).build();
		mvc.perform(MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json.writeValueAsString(dto)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();
	}

	@Test
	void validationAndExceptionHandlerWorks() throws Exception {
		TestDto dto = TestDto.builder().number(1).build();
		String response = mvc.perform(MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json.writeValueAsString(dto)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andReturn().getResponse().getContentAsString();

		assertThat(response).isEqualTo("Number of errors: 1");
	}

}
