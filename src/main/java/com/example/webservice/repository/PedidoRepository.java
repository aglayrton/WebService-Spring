package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webservice.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
