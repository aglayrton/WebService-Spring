package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webservice.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
