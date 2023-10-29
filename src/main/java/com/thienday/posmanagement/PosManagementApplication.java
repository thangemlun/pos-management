package com.thienday.posmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.thienday.posmanagement"})
public class PosManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosManagementApplication.class, args);
	}

}
