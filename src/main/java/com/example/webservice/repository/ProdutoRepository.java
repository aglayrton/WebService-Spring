package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webservice.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
