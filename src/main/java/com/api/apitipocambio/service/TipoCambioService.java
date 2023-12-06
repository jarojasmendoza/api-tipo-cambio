package com.api.apitipocambio.service;


import com.api.apitipocambio.model.TipoCambio;
import com.api.apitipocambio.model.TipoCambioRequest;
import com.api.apitipocambio.model.TipoCambioResponse;
import reactor.core.publisher.Mono;

public interface TipoCambioService {


    Mono<TipoCambioResponse> realizarCambio(TipoCambioRequest request);

    Mono<TipoCambio> actualizarTipoCambio(Long id, TipoCambioRequest request);

    Mono<TipoCambio> buscarTipoCambioPorId(Long id);
}
