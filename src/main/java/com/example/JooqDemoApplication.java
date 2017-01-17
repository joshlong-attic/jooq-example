package com.example;

import org.jooq.DSLContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JooqDemoApplication {

	@Bean
	CommandLineRunner demo(DSLContext context) {
		return args -> {

			context.


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(JooqDemoApplication.class, args);
	}
}
