package com.example.sistemarestaurante.Model;

public class PratoPedido {
    private Prato prato;
    private String Quantidade;

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String quantidade) {
        Quantidade = quantidade;
    }
}

