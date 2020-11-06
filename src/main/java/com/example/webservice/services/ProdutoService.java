package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webservice.model.Produto;
import com.example.webservice.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Produto> listarTodos(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Produto findByProduto(Long id) {
		Optional<Produto> c = repository.findById(id);
		return c.get();
	}
	
}
