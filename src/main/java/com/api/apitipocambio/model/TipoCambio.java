package com.api.apitipocambio.model;;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TIPOCAMBIO")
public class TipoCambio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MONEDAORIGEN")
    private String monedaOrigen;
    @Column(name = "MONEDADESTINO")
    private String monedaDestino;
    @Column(name = "CAMBIO")
    private BigDecimal cambio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }
}
