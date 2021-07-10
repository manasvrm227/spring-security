package com.shrinkme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class EmployeePortalApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalApplication.class, args);
		System.out.println("boot application started.");
	}
}
