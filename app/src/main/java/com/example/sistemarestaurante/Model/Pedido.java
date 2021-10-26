package com.example.sistemarestaurante.Model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {

    private String nomeGarçom;
    private List<PratoPedido> comida;
    private List<Bebida> bebida;
    private String obs;

    public List<PratoPedido> getComida() {
        return comida;
    }

    public void setComida(List<PratoPedido> comida) {
        this.comida = comida;
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
