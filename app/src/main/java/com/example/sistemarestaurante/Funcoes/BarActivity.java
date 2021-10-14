package com.example.sistemarestaurante.Funcoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sistemarestaurante.Activitys.CadastroBebidaActivity;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BarActivity extends AppCompatActivity {

    //XML
    private FloatingActionButton fabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        //configurações iniciais
        fabBar = findViewById(R.id.fabBar);

        fabBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BarActivity.this, CadastroBebidaActivity.class);
                startActivity(i);
            }
        });

    }
}