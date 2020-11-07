package com.example.webservice.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.webservice.model.enuns.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// versão 8 do java essa classe é melhor que o date
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant registro;

	// ENUM
	private int statusDoPedido;

	// Muito pedidos para 1 cliente
	@ManyToOne
	@JoinColumn(name = "cliente_id") // chave estrangeira
	private User cliente;

	//pelo id acessao o pedido
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> items = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL) 
	private Pagamentos pagamento;
	
	/* ==============================CONSTRUTORES===================================*/

	public Pedido(Long id, Instant registro, PedidoStatus pedidoStatus, User cliente) {
		this.id = id;
		this.registro = registro;
		setStatusDoPedido(pedidoStatus);
		this.cliente = cliente;
	}

	public Pedido() {
	}

	/*=============================GETTERS E SETTERS==========================*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getRegistro() {
		return registro;
	}

	public void setRegistro(Instant registro) {
		this.registro = registro;
	}

	public PedidoStatus getStatusDoPedido() {
		//conversão
		return PedidoStatus.valueOf(statusDoPedido);
	}

	public void setStatusDoPedido(PedidoStatus statusDoPedido) {
		if(statusDoPedido != null) {
			this.statusDoPedido = statusDoPedido.getCodigo();
		}
	}
	
	public Pagamentos getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamentos pagamento) {
		this.pagamento = pagamento;
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemPedido> getItems() {
		return items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((registro == null) ? 0 : registro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		return true;
	}

}
