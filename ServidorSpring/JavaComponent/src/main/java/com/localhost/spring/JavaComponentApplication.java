package com.localhost.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaComponentApplication.class, args);
		System.out.println("Spring Boot funcionando!");
	}

}
