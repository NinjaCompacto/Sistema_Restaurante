package com.example.sistemarestaurante.Funcoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sistemarestaurante.Activitys.CadastroBebidaActivity;
import com.example.sistemarestaurante.Cadastro_e_login.LoginActivity;
import com.example.sistemarestaurante.Firebase.ConfiguracaoFirebase;
import com.example.sistemarestaurante.Activitys.MudarBebidaStatusActivity;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class BarActivity extends AppCompatActivity {

    //XML
    private FloatingActionButton fabBar;

    //firebase
    private FirebaseAuth auth = ConfiguracaoFirebase.getAuth();

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

    //infla menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSair:
                auth.signOut();
                Intent i = new Intent(BarActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.menuStatus:
                Intent i1 = new Intent(BarActivity.this, MudarBebidaStatusActivity.class);
                startActivity(i1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}