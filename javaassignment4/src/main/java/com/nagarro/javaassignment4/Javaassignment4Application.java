package com.nagarro.javaassignment4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Javaassignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(Javaassignment4Application.class, args);
		
		
	}


}
