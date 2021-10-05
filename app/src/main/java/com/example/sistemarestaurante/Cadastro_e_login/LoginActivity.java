package com.example.sistemarestaurante.Cadastro_e_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sistemarestaurante.R;

public class LoginActivity extends AppCompatActivity {

    //XML
    private TextView textViewCadastrase;
    private EditText editTextEmail, editTextSenha;
    private Button buttonEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //configurações iniciais
        textViewCadastrase = findViewById(R.id.textViewCadastrese);
        editTextEmail = findViewById(R.id.editTextEmailLogin);
        editTextSenha = findViewById(R.id.editTextSenhaLogin);
        buttonEntrar = findViewById(R.id.buttonEntrar);

        //abre a tela de cadastro
        textViewCadastrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CadastroActivity.class);
                startActivity(i);
            }
        });
    }
}