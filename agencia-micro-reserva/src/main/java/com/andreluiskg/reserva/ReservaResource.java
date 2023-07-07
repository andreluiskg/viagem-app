package com.andreluiskg.reserva;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/reserva")
public class ReservaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> get() {
		return Reserva.listAll();
	}

	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reserva newReserva(Reserva reserva) {
		reserva.id = null;
		reserva.persist();

		return reserva;
	}

//	@Inject
//	@RestClient
//	ReservaService reservaService;
//
//	@Inject
//	@RestClient
//	ClienteService clienteService;
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("newReserva")
//	public String newReserva() {
//		Cliente cliente = clienteService.findById(3);
////		Cliente cliente = Cliente.of(2, "Maria");
//		Reserva reserva = Reserva.of(cliente);
//		
//		return reservaService.newReserva(reserva);
//	}

}
