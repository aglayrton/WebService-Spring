package com.example.webservice.model.enuns;

public enum PedidoStatus {
	
	//caso eu não coloque os valores, ele vai adiconar a cada constate dessa um valor
	//começando por 0
	
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	//
	public static PedidoStatus valueOf(int codigo) {
		for(PedidoStatus valor : PedidoStatus.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("codigo do Pedido invalido");
	}
}
