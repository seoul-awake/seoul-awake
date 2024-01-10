package com.seoulawake.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SeoulAwakeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeoulAwakeApplication.class, args);
	}
}
