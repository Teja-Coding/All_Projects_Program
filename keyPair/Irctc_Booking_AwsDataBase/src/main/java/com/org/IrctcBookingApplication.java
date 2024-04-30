package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrctcBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcBookingApplication.class, args);
		System.out.println("Irctc application Started port 8080.....");
	}

}
