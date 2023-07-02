package com.global.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class GlobalHealthCareManagemenWithSpringBootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalHealthCareManagemenWithSpringBootAngularApplication.class, args);
		System.out.println("WELCOME TO GLOBAL HEALTH CARE MANAGEMENT SYSTEM");
	}

}
