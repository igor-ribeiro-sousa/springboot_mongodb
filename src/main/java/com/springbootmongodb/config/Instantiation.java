package com.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springbootmongodb.domain.User;
import com.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User igor  = new User(null, "Igor Sousa", "sousa@gmail.com");
		User virna = new User(null, "Virna Sousa", "sousa@gmail.com");
		User mirna = new User(null, "Mirna Sousa", "sousa@gmail.com");
		User pateta = new User(null, "Pateta Sousa", "sousa@gmail.com");
		
		userRepository.saveAll(Arrays.asList(igor, virna, mirna, pateta));

	}

}
