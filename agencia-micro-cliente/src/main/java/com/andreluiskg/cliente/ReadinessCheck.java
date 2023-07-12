package com.andreluiskg.cliente;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {

		if (Cliente.listAll() == null) {
			return HealthCheckResponse.down("agencia-micro-cliente is not ready");
		} else {
			return HealthCheckResponse.up("agencia-micro-cliente is ready");
		}

	}

}
