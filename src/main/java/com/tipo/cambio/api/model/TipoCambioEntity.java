package com.tipo.cambio.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "tipo_cambio")
@Getter
@Setter
public class TipoCambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double monto;
    private double montoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
}
