package com.example.sistemarestaurante.Funcoes;

import android.content.Intent;
import android.os.Bundle;

import com.example.sistemarestaurante.Activitys.CadastroMesaActivity;
import com.example.sistemarestaurante.Cadastro_e_login.LoginActivity;
import com.example.sistemarestaurante.Firebase.ConfiguracaoFirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import com.example.sistemarestaurante.R;
import com.google.firebase.auth.FirebaseAuth;

public class GarcomActivity extends AppCompatActivity {

    //firebase
    private FirebaseAuth auth = ConfiguracaoFirebase.getAuth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garcom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menugarcom,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //tratamento para cada opção selecionada no menu
        switch (item.getItemId()){
            case R.id.menuSair:
                auth.signOut();
                Intent i = new Intent(GarcomActivity.this, LoginActivity.class);
                //retorna a tela de login e desloga usuario
                startActivity(i);
                finish();
                break;
            case R.id.menuMesa:
               Intent imesa = new Intent(GarcomActivity.this,CadastroMesaActivity.class);
               //abrir a tela de cadastro de novas mesas
               startActivity(imesa);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}