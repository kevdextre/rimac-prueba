package com.indra.apirest.model;

public class TipoCambioRequest {

    private String monedaOrigen;
    private String monedaDestino;
    private double nuevoValorTipoCambio;

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

    public double getNuevoValorTipoCambio() {
        return nuevoValorTipoCambio;
    }

    public void setNuevoValorTipoCambio(double nuevoValorTipoCambio) {
        this.nuevoValorTipoCambio = nuevoValorTipoCambio;
    }
}
