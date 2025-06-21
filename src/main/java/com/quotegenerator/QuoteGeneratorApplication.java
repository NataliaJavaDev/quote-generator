package com.quotegenerator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class QuoteGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteGeneratorApplication.class, args);
		log.info("Spring Boot Application Started");
	}
}