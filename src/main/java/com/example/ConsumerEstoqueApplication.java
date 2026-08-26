package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerEstoqueApplication {

	public static void main(String[] args) {
		System.setProperty("spring.amqp.deserialization.trust.all", "true");
		SpringApplication.run(ConsumerEstoqueApplication.class, args);
	}

}
