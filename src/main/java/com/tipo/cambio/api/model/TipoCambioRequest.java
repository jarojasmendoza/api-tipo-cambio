package com.tipo.cambio.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCambioRequest {
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;
}
