package poc.main;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import poc.amqp.Receiver;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "poc" })
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        try {
			context.getBean(Receiver.class).receive();
		} catch (BeansException | IOException e) {
			e.printStackTrace();
		}
	}
}