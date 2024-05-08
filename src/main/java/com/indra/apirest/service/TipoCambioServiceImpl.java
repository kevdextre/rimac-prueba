package com.indra.apirest.service;
import com.indra.apirest.model.TipoCambio;
import com.indra.apirest.repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;
    @Autowired
    public TipoCambioServiceImpl(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    public TipoCambio obtenerTipoCambio(String monedaOrigen, String monedaDestino) {
        return tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
    }

    public boolean actualizarTipoCambio(String monedaOrigen, String monedaDestino, double nuevoValorTipoCambio) {
        TipoCambio tipoCambio = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
        if (tipoCambio == null) {
            return false;
        }
        tipoCambio.setValorTipoCambio(nuevoValorTipoCambio);
        tipoCambioRepository.save(tipoCambio);
        return true;
    }
}
