package com.api.apitipocambio.model;

import javax.persistence.Column;
import java.math.BigDecimal;

public class TipoCambioRequest {

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private String monedaOrigen;

    @Column(nullable = false)
    private String monedaDestino;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
}
