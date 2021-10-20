package com.example.sistemarestaurante.Model;

import java.util.List;

public class Pedido {

    private String nomeGarçom;
    private List<PratoPedido> prato;
    private List<Bebida> bebida;
    private String obs;

    public List<PratoPedido> getPrato() {
        return prato;
    }

    public void setPrato(List<PratoPedido> prato) {
        this.prato = prato;
    }

    public List<Bebida> getBebida() {
        return bebida;
    }

    public void setBebida(List<Bebida> bebida) {
        this.bebida = bebida;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNomeGarçom() {
        return nomeGarçom;
    }

    public void setNomeGarçom(String nomeGarçom) {
        this.nomeGarçom = nomeGarçom;
    }
}
