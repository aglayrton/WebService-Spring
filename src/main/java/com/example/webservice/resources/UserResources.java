package com.example.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.User;
import com.example.webservice.services.UserService;

//controladores rest

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	//retorna respostas de requisições web
	@GetMapping
	public ResponseEntity<List<User>> findAllUsuarios(){
		List<User> list = service.findAll();
		//.ok retorna a resposta com sucesso - .body retorna o corpo da resposta
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> buscarPorId(@PathVariable("id") Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
