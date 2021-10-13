package com.example.sistemarestaurante.Model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String NomeCliente;
    private Pedido pedido;

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        NomeCliente = nomeCliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
