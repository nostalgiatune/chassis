package fi.tuomas.chassis.baseentity;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import fi.tuomas.chassis.baseentity.AuditableTest.TestContext;
import fi.tuomas.chassis.baseentity.config.EnableAuditing;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TestEntityRepository.class,
        TestContext.class
})
class AuditableTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    void testAuditable() {
        TestEntity testEntity = TestEntity.builder().number(2).build();
        testEntity.setCreatedDate(LocalDateTime.now());
        testEntity = testEntityRepository.save(testEntity);
        assertThat(testEntity.getCreatedBy()).isEqualTo("test");
    }

    @TestConfiguration
    @EnableJpaRepositories
    @EnableAutoConfiguration
    @EnableAuditing
    static class TestContext {

        @Bean
        AuditorAware<String> auditorProvider() {
            return new AuditorAware<String>() {
                @Override
                public Optional<String> getCurrentAuditor() {
                    return Optional.of("test");
                }
            };
        }
    }
}