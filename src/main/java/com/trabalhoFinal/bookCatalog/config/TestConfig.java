package com.trabalhoFinal.bookCatalog.config;

import java.text.SimpleDateFormat;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.trabalhoFinal.bookCatalog.entities.User;
import com.trabalhoFinal.bookCatalog.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public void run(String... args) throws Exception {
		
		User u = new User(1L, "Maria", "maria@gamil.com", null, "999999999", "123456");
		
		userRepository.save(u);
	}
}
