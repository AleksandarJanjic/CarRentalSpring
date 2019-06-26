package com.janja.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.janja")
public class CarRentalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalSpringApplication.class, args);
	}

}

