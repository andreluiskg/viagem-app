package com.andreluiskg.reserva;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.andreluiskg.cliente.Cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reserva-cli")
public class ReservaResource {
	
	@Inject
	@RestClient
	ReservaService reservaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String newReserva() {
		
		Cliente cliente = Cliente.of("Remoto");

		return reservaService.newReserva(cliente);
	}

}
