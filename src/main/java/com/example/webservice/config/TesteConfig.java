package com.example.webservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webservice.model.User;
import com.example.webservice.repository.UserRepository;

@Configuration
@Profile("test") //tem que ser igualzinho que tem la no profile do application.properties
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository repository;
	
	
	//tudo vai ser executado quando a aplicação for executada
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		repository.saveAll(Arrays.asList(u1, u2)); //O comando salva uma lista
	}
	
}
