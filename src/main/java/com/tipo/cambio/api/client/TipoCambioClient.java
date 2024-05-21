package com.tipo.cambio.api.client;

import com.tipo.cambio.api.model.TipoCambioClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "api-tipo-cambio", url = "https://open.er-api.com/v6/latest")
public interface TipoCambioClient {
    @GetMapping("/{moneda}")
    TipoCambioClientResponse getCambioApi(@PathVariable("moneda") String moneda);
}
