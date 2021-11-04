package com.example.sistemarestaurante.Model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {

    private String nomeGarçom;
    private List<PratoPedido> comida;
    private List<BebidaPedida> bebida;

    public List<BebidaPedida> getBebida() {
        return bebida;
    }

    public void setBebida(List<BebidaPedida> bebida) {
        this.bebida = bebida;
    }

    public List<PratoPedido> getComida() {
        return comida;
    }

    public void setComida(List<PratoPedido> comida) {
        this.comida = comida;
    }


    public String getNomeGarçom() {
        return nomeGarçom;
    }

    public void setNomeGarçom(String nomeGarçom) {
        this.nomeGarçom = nomeGarçom;
    }
}
