package by.kish.mano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ManoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManoApplication.class, args);
	}
}
