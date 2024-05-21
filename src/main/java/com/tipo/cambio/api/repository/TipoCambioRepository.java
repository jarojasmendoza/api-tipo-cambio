package com.tipo.cambio.api.repository;

import com.tipo.cambio.api.model.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambioEntity, Long> {
}
