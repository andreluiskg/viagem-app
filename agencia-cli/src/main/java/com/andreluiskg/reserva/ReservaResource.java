package com.andreluiskg.reserva;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.andreluiskg.cliente.Cliente;
import com.andreluiskg.cliente.ClienteService;

@Path("/reserva-cli")
public class ReservaResource {

	@Inject
	@RestClient
	ReservaService reservaService;

	@Inject
	@RestClient
	ClienteService clienteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("newReserva")
	public String newReserva() {
		Cliente cliente = clienteService.findById(3);
//		Cliente cliente = Cliente.of(2, "Maria");
		Reserva reserva = Reserva.of(cliente);
		
		return reservaService.newReserva(reserva);
	}

}
