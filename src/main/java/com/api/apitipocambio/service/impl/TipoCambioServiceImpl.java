package com.api.apitipocambio.service.impl;



import com.api.apitipocambio.exception.TipoCambioNotFoundException;
import com.api.apitipocambio.model.TipoCambio;
import com.api.apitipocambio.model.TipoCambioRequest;
import com.api.apitipocambio.model.TipoCambioResponse;
import com.api.apitipocambio.repository.TipoCambioRepository;
import com.api.apitipocambio.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;



@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;


    @Autowired
    public TipoCambioServiceImpl(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    @Override
    public Mono<TipoCambioResponse> realizarCambio(TipoCambioRequest request) {
        return Mono.fromSupplier(() -> {
            TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();

            // Realiza la búsqueda del tipo de cambio en la base de datos
            TipoCambio tipoCambio = tipoCambioRepository.buscarTipoCambio(request.getMonedaOrigen(), request.getMonedaDestino());

            if (tipoCambio != null) {
                tipoCambioResponse.setMonto(request.getMonto());
                tipoCambioResponse.setMontoTipoCambio(request.getMonto().multiply(tipoCambio.getCambio()));
                tipoCambioResponse.setMonedaOrigen(tipoCambio.getMonedaOrigen());
                tipoCambioResponse.setMonedaDestino(tipoCambio.getMonedaDestino());
                tipoCambioResponse.setTipoCambio(tipoCambio.getCambio());
            } else {
                // Si tipoCambio es null, significa que no se encontró un tipo de cambio
                throw new TipoCambioNotFoundException("Tipo de cambio no encontrado");
            }

            return tipoCambioResponse;
        });
    }

    @Override
    public Mono<TipoCambio> actualizarTipoCambio(Long id, TipoCambioRequest request) {
        return Mono
                .fromSupplier(() -> tipoCambioRepository.findById(id))  // Convertir Optional a Mono
                .flatMap(optionalTipoCambio -> {
                    if (optionalTipoCambio.isPresent()) {
                        TipoCambio existingTipoCambio = optionalTipoCambio.get();

                        existingTipoCambio.setMonedaOrigen(request.getMonedaOrigen());
                        existingTipoCambio.setMonedaDestino(request.getMonedaDestino());
                        existingTipoCambio.setCambio(request.getMonto());

                        return Mono.fromCallable(() -> tipoCambioRepository.save(existingTipoCambio));
                    } else {
                        return Mono.error(new TipoCambioNotFoundException("Tipo de cambio no encontrado con ID: " + id));
                    }
                });
    }

    @Override
    public Mono<TipoCambio> buscarTipoCambioPorId(Long id) {
        return Mono.defer(() -> {
            TipoCambio existingTipoCambio = tipoCambioRepository.findById(id).orElse(null);
            if (existingTipoCambio != null) {
                return Mono.just(existingTipoCambio);
            } else {
                return Mono.error(new TipoCambioNotFoundException("Tipo de cambio no encontrado con ID: " + id));
            }
        });
    }


}
