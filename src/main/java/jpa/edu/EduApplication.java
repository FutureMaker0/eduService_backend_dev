package jpa.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EduApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduApplication.class, args);
	}

//	@Bean
//	Hibernate5JakartaModule hibernate5JakartaModule() {
//		return new Hibernate5JakartaModule();
//	}

}
