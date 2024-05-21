package com.tipo.cambio.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class TipoCambioClientResponse {
    private String base_code;
    private Map<String, BigDecimal> rates;
}
