package com.example.sistemarestaurante.Funcoes;

import android.content.Intent;
import android.os.Bundle;

import com.example.sistemarestaurante.Activitys.CadastroPratoActicity;
import com.example.sistemarestaurante.Activitys.MudarPratoStatusActivity;
import com.example.sistemarestaurante.Cadastro_e_login.LoginActivity;
import com.example.sistemarestaurante.Firebase.ConfiguracaoFirebase;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class CozinhaActivity extends AppCompatActivity {

    //XML
    private FloatingActionButton fab;

    //Firebase
    private FirebaseAuth auth = ConfiguracaoFirebase.getAuth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cozinha);

        //configurações iniciais
        fab = findViewById(R.id.fabBar);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CozinhaActivity.this, CadastroPratoActicity.class);
                startActivity(i);
            }
        });

    }

    //infla menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucozinha,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //tratamento para opção selecionada do menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSair:
                auth.signOut();
                Intent i = new Intent(CozinhaActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.menuStatus:
                Intent istatus = new Intent(CozinhaActivity.this , MudarPratoStatusActivity.class);
                startActivity(istatus);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}