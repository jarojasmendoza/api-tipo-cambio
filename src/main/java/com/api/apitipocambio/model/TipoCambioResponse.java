package com.api.apitipocambio.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoCambioResponse {

    private BigDecimal monto;
    private BigDecimal montoTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal tipoCambio;
    private String mensaje;


    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoTipoCambio() {
        return montoTipoCambio;
    }

    public void setMontoTipoCambio(BigDecimal montoTipoCambio) {
        this.montoTipoCambio = montoTipoCambio;
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

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public TipoCambioResponse setMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this; // Devuelve la instancia actual para permitir el encadenamiento de métodos
    }
}
