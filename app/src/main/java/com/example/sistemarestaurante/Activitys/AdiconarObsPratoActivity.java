package com.example.sistemarestaurante.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sistemarestaurante.Adapters.ObsPratoAdapter;
import com.example.sistemarestaurante.Model.Mesa;
import com.example.sistemarestaurante.Model.PratoPedido;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdiconarObsPratoActivity extends AppCompatActivity {

    //XML
    private RecyclerView recyclerObsPratos;
    private FloatingActionButton fabObsPratos;
    private ObsPratoAdapter obsPratoAdapter ;

    //Model
    private Mesa mesa;
    private List<PratoPedido> pratoPedidos;
    private List<PratoPedido> pratoPedidosAtualizado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiconar_obs_prato);

        //configuração inicial
        recyclerObsPratos = findViewById(R.id.recyclerObsPratos);
        fabObsPratos = findViewById(R.id.fabObsPratos);

        //recupera extras (mesa)
        if (getIntent().getExtras() != null){
            mesa = (Mesa)getIntent().getExtras().getSerializable("mesa");
            pratoPedidos = (List<PratoPedido>) getIntent().getExtras().getSerializable("listapratos");
        }

        //recyclerview
        obsPratoAdapter = new ObsPratoAdapter(pratoPedidos,getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerObsPratos.setHasFixedSize(true);
        recyclerObsPratos.setLayoutManager(layoutManager);
        recyclerObsPratos.setAdapter(obsPratoAdapter);

        fabObsPratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (obsPratoAdapter.recuperaListaAtualizada() != null) {
                   pratoPedidosAtualizado = obsPratoAdapter.recuperaListaAtualizada();
                   //adcionar intent para fazer a msm coisa para o bar
               }

            }
        });
    }
}