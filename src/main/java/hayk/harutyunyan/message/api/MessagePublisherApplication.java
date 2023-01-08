package hayk.harutyunyan.message.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MessagePublisherApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessagePublisherApplication.class, args);
	}
}
