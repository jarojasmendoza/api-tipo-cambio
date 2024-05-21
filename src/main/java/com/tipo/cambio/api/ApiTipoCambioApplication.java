package com.tipo.cambio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiTipoCambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTipoCambioApplication.class, args);
	}

}
