package com.andreluiskg.reserva;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class LivenessCheck implements HealthCheck{

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.up("agencia-micro-reserva is alive");
	}

}
