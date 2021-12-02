package com.example.sistemarestaurante.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemarestaurante.Activitys.PedidoPratoActivity;
import com.example.sistemarestaurante.Firebase.ConfiguracaoFirebase;
import com.example.sistemarestaurante.Model.Mesa;
import com.example.sistemarestaurante.Model.Pedido;
import com.example.sistemarestaurante.Model.PratoPedido;
import com.example.sistemarestaurante.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class ListaPratoPedidosAdapter  extends RecyclerView.Adapter<ListaPratoPedidosAdapter.MyViewHolder> {

    private List<Pedido> pedidos;
    private Context context;
    private String textinfo;

    private DatabaseReference databaseReference = ConfiguracaoFirebase.getDatabaseReference();
    private DatabaseReference mesaref ;

    public ListaPratoPedidosAdapter(List<Pedido> pedidos,Context c) {
        this.context = c;
        this.pedidos = pedidos;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemlista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_pratos_pedidos_cozinha,parent,false);
        return new MyViewHolder(itemlista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        textinfo = null;
        Pedido pedido = pedidos.get(position);
        holder.textPedido.setText("Pedido: Mesa" + pedido.getNumeroMesa());


        //configurando status incial
        if (pedido.getComidaStauts().contains("preparando")){
            holder.textStatus.setTextColor(Color.YELLOW);
            holder.textStatus.setText("Status: Preparando");
        }
        if (pedido.getComidaStauts().contains("em aberto")){
            holder.textStatus.setTextColor(Color.RED);
            holder.textStatus.setText("Status: Em Aberto");
        }
        if (pedido.getComidaStauts().contains("pronto")){
            holder.textStatus.setTextColor(Color.RED);
            holder.textStatus.setText("Status: Pronto");
        }

        //configurando texto de informações do pedido
        for (PratoPedido pratoPedido : pedido.getComida()){
            if (textinfo == null) {
                textinfo = pratoPedido.getPrato().getNomePrato();
            }
            else {
                textinfo = textinfo + ", " + pratoPedido.getPrato().getNomePrato();
            }
        }
        holder.textinfoPrato.setText(textinfo);



    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textPedido, textStatus,textinfoPrato;
        Button buttonPreparando, buttonPronto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textinfoPrato = itemView.findViewById(R.id.textInfoPrato);
            textPedido = itemView.findViewById(R.id.textPedidoMesaCozinha);
            textStatus= itemView.findViewById(R.id.textStatusPratoCozinha);

        }
    }
}
