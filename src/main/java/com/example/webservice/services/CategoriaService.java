package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webservice.repository.Categoria;
import com.example.webservice.repository.CategoriaRepositorio;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositorio repository;
	
	@Transactional(readOnly = true)
	public List<Categoria> listarTodos(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Categoria findByCategoria(Long id) {
		Optional<Categoria> c = repository.findById(id);
		return c.get();
	}
	
}
