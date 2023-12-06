package com.api.apitipocambio.Util;

public class Query {

    public static final String consultarTipoCambio= "select p from TIPOCAMBIO  p where p.monedaOrigen = :monedaOrigen and p.monedaDestino = :monedaDestino";
}
