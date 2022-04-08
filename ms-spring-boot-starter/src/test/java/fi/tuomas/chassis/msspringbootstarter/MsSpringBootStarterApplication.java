package fi.tuomas.chassis.msspringbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fi.tuomas.chassis.baseentity.config.EnableAuditing;

@SpringBootApplication
@EnableAuditing
public class MsSpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringBootStarterApplication.class, args);
	}

}
