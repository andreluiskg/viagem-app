package com.andreluiskg.cliente;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cliente-cli")
public class ClienteResource {

	@Inject
	@RestClient
	ClienteService clienteService;

	@GET
	@Path("findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente findById(@QueryParam("id") long id) {
		return clienteService.findById(id);
	}

	@GET
	@Path("newCliente")
	public String newCliente() {
		Cliente cliente1 = Cliente.of(81, "Remoto1");
		clienteService.newCliente(cliente1);
		Cliente cliente2 = Cliente.of(82, "Remoto2");
		clienteService.newCliente(cliente2);
		Cliente cliente3 = Cliente.of(83, "Remoto3");
		clienteService.newCliente(cliente3);
		Cliente cliente4 = Cliente.of(84, "Remoto4");
		clienteService.newCliente(cliente4);
		return cliente1.getNome() + "//" + cliente2.getNome() + "//" + cliente3.getNome() + "//" + cliente4.getNome();
	}

}
