package com.tipo.cambio.api.service;

import com.tipo.cambio.api.client.TipoCambioClient;
import com.tipo.cambio.api.model.TipoCambioClientResponse;
import com.tipo.cambio.api.model.TipoCambioEntity;
import com.tipo.cambio.api.model.TipoCambioRequest;
import com.tipo.cambio.api.model.TipoCambioResponse;

import com.tipo.cambio.api.repository.TipoCambioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TipoCambioService {
    private final TipoCambioRepository repository;
    private final TipoCambioClient tipoCambioClient;

    public TipoCambioService(TipoCambioRepository repository, TipoCambioClient tipoCambioClient) {
        this.repository = repository;
        this.tipoCambioClient = tipoCambioClient;
    }

    public Mono<TipoCambioResponse> realizarCambio(TipoCambioRequest request) {
        return Mono.fromCallable(() -> tipoCambioClient.getCambioApi(request.getMonedaOrigen()))
                .flatMap(cambioApi -> {
                    TipoCambioEntity tipoCambioEntity = new TipoCambioEntity();
                    tipoCambioEntity.setMonto(request.getMonto());
                    tipoCambioEntity.setMontoCambio(realizarCambio(request.getMonto(), cambioApi.getRates().get(request.getMonedaDestino())));
                    tipoCambioEntity.setMonedaOrigen(request.getMonedaOrigen());
                    tipoCambioEntity.setMonedaDestino(request.getMonedaDestino());
                    tipoCambioEntity.setTipoCambio(cambioApi.getRates().get(request.getMonedaDestino()).doubleValue());

                    return Mono.fromCallable(() -> repository.save(tipoCambioEntity));
                })
                .map(tipoCambioEntity -> {
                    TipoCambioResponse response = new TipoCambioResponse();
                    response.setMonto(tipoCambioEntity.getMonto());
                    response.setMontoCambio(tipoCambioEntity.getMontoCambio());
                    response.setMonedaOrigen(tipoCambioEntity.getMonedaOrigen());
                    response.setMonedaDestino(tipoCambioEntity.getMonedaDestino());
                    response.setTipoCambio(tipoCambioEntity.getTipoCambio());
                    return response;
                });
    }

    public Flux<TipoCambioResponse> listarCambios() {
        List<TipoCambioEntity> listaCambios = repository.findAll();
        return Flux.fromIterable(listaCambios)
                .map(tipoCambio -> {
                        TipoCambioResponse response = new TipoCambioResponse();
                        response.setMonto(tipoCambio.getMonto());
                        response.setMontoCambio(tipoCambio.getMontoCambio());
                        response.setMonedaOrigen(tipoCambio.getMonedaOrigen());
                        response.setMonedaDestino(tipoCambio.getMonedaDestino());
                        response.setTipoCambio(tipoCambio.getTipoCambio());
                    return response;
                });
    }


    public double realizarCambio(double montoOriginal, BigDecimal tipoCambio) {
        BigDecimal montoOriginalBigDecimal = BigDecimal.valueOf(montoOriginal);
        BigDecimal montoConvertidoBigDecimal = montoOriginalBigDecimal.multiply(tipoCambio);
        return montoConvertidoBigDecimal.doubleValue();
    }
}
