package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootGlobalExceptionHandler {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootGlobalExceptionHandler.class, args);
	}
}
