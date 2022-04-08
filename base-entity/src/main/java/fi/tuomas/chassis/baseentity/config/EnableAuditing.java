package fi.tuomas.chassis.baseentity.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableJpaAuditing
@Import(DataAuditingConfiguration.class)
public @interface EnableAuditing {

}
