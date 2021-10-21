package com.example.sistemarestaurante.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sistemarestaurante.Model.Prato;
import com.example.sistemarestaurante.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PratoPedidosAdapter extends RecyclerView.Adapter<PratoPedidosAdapter.MyViewHolderPratos> {

    private List<Prato> pratos;
    private Context context;

    public PratoPedidosAdapter(List<Prato> pratoslist, Context c) {
        this.pratos = pratoslist;
        this.context = c;
    }

    @NonNull
    @Override
    public MyViewHolderPratos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemlista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_prato_pedidos,parent,false);
        return new MyViewHolderPratos(itemlista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPratos holder, int position) {
        Prato prato = pratos.get(position);
        holder.textNomePrato.setText(prato.getNomePrato());
        holder.textValorPrato.setText("R$ " + prato.getValor());

        if (prato.getFoto() != null){
            Glide.with(context).load(prato.getFoto()).into(holder.circleImagePrato);
        }

    }

    @Override
    public int getItemCount() {
        return pratos.size();
    }

    public class MyViewHolderPratos extends RecyclerView.ViewHolder{
        TextView textQuantidade,textNomePrato,textValorPrato;
        CircleImageView circleImagePrato;
        public MyViewHolderPratos(@NonNull View itemView) {
            super(itemView);
            textQuantidade = itemView.findViewById(R.id.textQuantidadePrato);
            textNomePrato = itemView.findViewById(R.id.textNomePrato);
            textValorPrato = itemView.findViewById(R.id.textValorPrato);
            circleImagePrato = itemView.findViewById(R.id.circleImagePrato);
        }
    }
}