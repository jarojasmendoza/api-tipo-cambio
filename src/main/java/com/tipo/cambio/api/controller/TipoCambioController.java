package com.tipo.cambio.api.controller;


import com.tipo.cambio.api.model.TipoCambioRequest;
import com.tipo.cambio.api.model.TipoCambioResponse;
import com.tipo.cambio.api.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class TipoCambioController {
    private final TipoCambioService tipoCambioService;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @PostMapping("/convertir")
    public ResponseEntity<Mono<TipoCambioResponse>> realizarTipoCambio(
            @RequestBody TipoCambioRequest request){

            var response = tipoCambioService.realizarCambio(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/listar")
    public ResponseEntity<Flux<TipoCambioResponse>> listarCambios(){
        var listaCambios = tipoCambioService.listarCambios();
        return ResponseEntity.ok(listaCambios);
    }
}
