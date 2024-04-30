package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAddressApplication.class, args);
		System.out.println("application started on port 6060....");
	}

}
