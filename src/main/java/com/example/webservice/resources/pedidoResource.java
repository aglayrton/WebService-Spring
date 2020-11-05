package com.example.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.Pedido;
import com.example.webservice.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Pedido>> pedidos(){
		List<Pedido> pedidos = service.listarTodos();
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Pedido> pedido(@PathVariable("id") Long id){
		Pedido pedido = service.findByPedido(id);
		return ResponseEntity.ok().body(pedido);
	}
}
