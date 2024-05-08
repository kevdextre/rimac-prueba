package com.indra.apirest.controller;
import com.indra.apirest.model.TipoCambio;
import com.indra.apirest.model.TipoCambioRequest;
import com.indra.apirest.model.TipoCambioResponse;
import com.indra.apirest.service.TipoCambioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @GetMapping("/tipo-cambio")
    public ResponseEntity<TipoCambioResponse> aplicarTipoCambio(
            @RequestParam("monto") double monto,
            @RequestParam("monedaOrigen") String monedaOrigen,
            @RequestParam("monedaDestino") String monedaDestino) {
        TipoCambio tipoCambio = tipoCambioService.obtenerTipoCambio(monedaOrigen, monedaDestino);
        if (tipoCambio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        double montoConTipoCambio = monto * tipoCambio.getValorTipoCambio();
        TipoCambioResponse response = new TipoCambioResponse();
        response.setMonto(monto);
        response.setMontoConTipoCambio(montoConTipoCambio);
        response.setMonedaOrigen(monedaOrigen);
        response.setMonedaDestino(monedaDestino);
        response.setTipoCambio(tipoCambio.getValorTipoCambio());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/tipo-cambio")
    public ResponseEntity<String> actualizarTipoCambio(@RequestBody TipoCambioRequest request) {
        boolean actualizacionExitosa = tipoCambioService.actualizarTipoCambio(request.getMonedaOrigen(), request.getMonedaDestino(), request.getNuevoValorTipoCambio());
        if (actualizacionExitosa) {
            return ResponseEntity.ok("Tipo de cambio actualizado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el tipo de cambio");
        }
    }
}