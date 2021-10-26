package com.example.sistemarestaurante.Model;

import java.io.Serializable;

public class PratoPedido implements Serializable {
    private Prato prato;
    private  int quantidade;

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

