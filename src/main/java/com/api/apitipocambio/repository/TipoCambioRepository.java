package com.api.apitipocambio.repository;

import com.api.apitipocambio.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends  JpaRepository<TipoCambio, Long> {
    @Query("SELECT tc FROM TipoCambio tc WHERE tc.monedaOrigen = :monedaOrigen AND tc.monedaDestino = :monedaDestino")
    TipoCambio buscarTipoCambio(@Param("monedaOrigen") String monedaOrigen, @Param("monedaDestino") String monedaDestino);
}
