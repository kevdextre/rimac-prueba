package com.indra.apirest.service;

import com.indra.apirest.model.TipoCambio;

public interface TipoCambioService {
    TipoCambio obtenerTipoCambio(String monedaOrigen, String monedaDestino);

    boolean actualizarTipoCambio(String monedaOrigen, String monedaDestino, double nuevoValorTipoCambio);
}
