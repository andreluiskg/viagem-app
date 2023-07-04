package com.andreluiskg.reserva;

import com.andreluiskg.cliente.Cliente;

public class Reserva {
	
	private Cliente cliente;
	
	public Reserva() {
		
	}

	private Reserva(Cliente cliente) {
		this.cliente=cliente;
	}
	
	public static Reserva of(Cliente cliente) {
		return new Reserva(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
