package com.indra.apirest.repository;

import com.indra.apirest.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioRepository  extends JpaRepository<TipoCambio, Long> {
    TipoCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
