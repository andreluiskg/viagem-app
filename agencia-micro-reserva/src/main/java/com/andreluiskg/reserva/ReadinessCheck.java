package com.andreluiskg.reserva;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {

		if (Reserva.listAll() == null) {
			return HealthCheckResponse.down("agencia-micro-reserva is not ready");
		} else {
			return HealthCheckResponse.up("agencia-micro-reserva is ready");
		}

	}

}
