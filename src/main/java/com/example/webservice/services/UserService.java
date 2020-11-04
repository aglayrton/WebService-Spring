package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.model.User;
import com.example.webservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	//retorna todos
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get(); //
	}
}
