package com.example.rest;

import com.example.rest.Models.Role;
import com.example.rest.Models.User;
import com.example.rest.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
 		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Fred Clause", "fred", "1234", new ArrayList<>()));
			userService.addRoleToUser("john", "ROLE_ADMIN");
			userService.addRoleToUser("fred", "ROLE_USER");
		};
	}

}
