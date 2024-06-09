package com.user_management_systems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UserManagementSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemsApplication.class, args);
	}

}
