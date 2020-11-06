package com.example.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.Produto;
import com.example.webservice.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> listarProdutos(){
		List<Produto> Produtos = service.listarTodos();
		return ResponseEntity.ok().body(Produtos);
	} 
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> produto(@PathVariable("id") Long id) {
		Produto Produto = service.findByProduto(id);
		return ResponseEntity.ok().body(Produto);
	}
	
	
}
