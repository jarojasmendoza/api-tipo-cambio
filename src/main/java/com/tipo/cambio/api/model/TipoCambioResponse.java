package com.tipo.cambio.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCambioResponse {
    private double monto;
    private double montoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;


}
