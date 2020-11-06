package com.example.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.Categoria;
import com.example.webservice.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> listarCategorias(){
		List<Categoria> categorias = service.listarTodos();
		return ResponseEntity.ok().body(categorias);
	} 
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> categoria(@PathVariable("id") Long id) {
		Categoria categoria = service.findByCategoria(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	
}
