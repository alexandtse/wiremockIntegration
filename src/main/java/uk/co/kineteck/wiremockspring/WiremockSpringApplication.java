package uk.co.kineteck.wiremockspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uk.co.kineteck.wiremockspring.applicationContextInitializer.WiremockApplicationContextInitializer;

@SpringBootApplication
public class WiremockSpringApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WiremockSpringApplication.class, args);
		SpringApplication springApplication = new SpringApplication(WiremockSpringApplication.class);
		springApplication.addInitializers(new WiremockApplicationContextInitializer());
		ConfigurableApplicationContext context = springApplication.run(args);
	}

}
