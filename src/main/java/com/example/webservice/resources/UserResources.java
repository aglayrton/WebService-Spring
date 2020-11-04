package com.example.webservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.User;

//controladores rest

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	//retorna respostas de requisições web
	@GetMapping
	public ResponseEntity<User> findAllUsuarios(){
		User usuario = new User(1L, "Aglayrton", "aglayrtonjuliao@gmail.com", "92131997", "123456789");
		//.ok retorna a resposta com sucesso - .body retorna o corpo da resposta
		return ResponseEntity.ok().body(usuario);
	}
}
