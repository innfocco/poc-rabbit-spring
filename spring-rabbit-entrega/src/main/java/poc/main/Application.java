package poc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "poc" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}