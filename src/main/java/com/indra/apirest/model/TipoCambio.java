package com.indra.apirest.model;

import com.indra.apirest.service.TipoCambioService;
import jakarta.persistence.*;

@Entity
@Table(name = "tipocambio")
public class TipoCambio {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String monedaOrigen;
    private String monedaDestino;
    private double valorTipoCambio;

    public TipoCambio(){

    }
    public TipoCambio(double monto, double montoConTipoCambio, String monedaOrigen, String monedaDestino, double valorTipoCambio) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getValorTipoCambio() {
        return valorTipoCambio;
    }

    public void setValorTipoCambio(double valorTipoCambio) {
        this.valorTipoCambio = valorTipoCambio;
    }


}
