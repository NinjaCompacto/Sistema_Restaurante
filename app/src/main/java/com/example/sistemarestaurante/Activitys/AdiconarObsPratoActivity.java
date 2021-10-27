package com.example.sistemarestaurante.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.sistemarestaurante.Model.Mesa;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdiconarObsPratoActivity extends AppCompatActivity {

    //XML
    private RecyclerView recyclerObsPratos;
    private FloatingActionButton fabObsPratos;

    //Model
    private Mesa mesa;


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
        }

        //FAZER ADAPTER DO OBS

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerObsPratos.setHasFixedSize(true);
        recyclerObsPratos.setLayoutManager(layoutManager);
       // recyclerObsPratos.setAdapter();
    }
}