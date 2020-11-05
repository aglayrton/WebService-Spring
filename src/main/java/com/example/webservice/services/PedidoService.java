package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.model.Pedido;
import com.example.webservice.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> listarTodos(){
		return repository.findAll(); 
	}
	
	public Pedido findByPedido(Long id){
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.get();
	}
}
