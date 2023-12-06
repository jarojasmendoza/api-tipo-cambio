package com.api.apitipocambio.exception;

public class TipoCambioNotFoundException extends RuntimeException {

    public TipoCambioNotFoundException(String message) {
        super(message);
    }

    public TipoCambioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}