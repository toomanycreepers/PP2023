package com.example.ChatModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableMethodSecurity
@SpringBootApplication
public class ChatModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatModuleApplication.class, args);
	}
}
