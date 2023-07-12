package com.andreluiskg.cliente;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findById")
	@Timeout(unit = ChronoUnit.SECONDS, value = 3)
	@Fallback(fallbackMethod = "fallback") // o que esta entre aspas deve ser o metodo a ser utilizado
											// deve ter a mesma assinatura
	@CircuitBreaker(requestVolumeThreshold = 4, // qtd de requisicoes que sera sua amostra
			failureRatio = .5, // percentual aceito de requisicoes com falha antes de abrir o circuito
			delay = 6000, // tempo de espera para uma nova tentativa em mili-segundos
			successThreshold = 1 // taxa de sucesso para considerar o circuito fechado
	)

	public Cliente findById(@QueryParam("id") long id);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String newCliente(Cliente cliente);

	private Cliente fallback(long id) {
		return Cliente.of(0, "");
	}

}
