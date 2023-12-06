package com.api.apitipocambio.controller;

import com.api.apitipocambio.exception.TipoCambioNotFoundException;
import com.api.apitipocambio.model.TipoCambio;
import com.api.apitipocambio.model.TipoCambioRequest;
import com.api.apitipocambio.model.TipoCambioResponse;
import com.api.apitipocambio.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {
    @Autowired
    private final TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @PostMapping("/realizar")
    public Mono<ResponseEntity<TipoCambioResponse>> realizarCambio(@RequestBody TipoCambioRequest request) {
        return tipoCambioService.realizarCambio(request)
                .map(response -> ResponseEntity.ok(response))
                .onErrorResume(TipoCambioNotFoundException.class,
                        ex -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(new TipoCambioResponse().setMensaje(ex.getMessage()))));
    }
    @PutMapping("/actualizar/{id}")
    public Mono<TipoCambio> actualizarTipoCambio(@PathVariable Long id, @RequestBody TipoCambioRequest request) {
        return tipoCambioService.actualizarTipoCambio(id, request);
    }

   @GetMapping("/buscar/{id}")
   public Mono<TipoCambio> buscarTipoCambios(@PathVariable Long id) {
       if (id <= 0) {
           return Mono.error(new IllegalArgumentException("ID debe ser mayor que cero"));
       }
       return tipoCambioService.buscarTipoCambioPorId(id)
               .onErrorResume(ex -> Mono.empty()); // o manejo de error personalizado
   }
}
