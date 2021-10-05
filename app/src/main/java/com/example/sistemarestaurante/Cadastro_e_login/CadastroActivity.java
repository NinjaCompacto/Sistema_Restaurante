package com.example.sistemarestaurante.Cadastro_e_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.sistemarestaurante.R;

public class CadastroActivity extends AppCompatActivity {

    //XML
    private ImageView imageViewCadastro;
    private EditText editTextNome, editTextEmail, editTextSenha;
    private Button buttonCadastrar;
    private Spinner spinnerFuncao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //configurações iniciais
        imageViewCadastro = findViewById(R.id.imageViewCadastro);
        editTextEmail = findViewById(R.id.editTextEmailCadastro);
        editTextNome = findViewById(R.id.editTextNomeCadastro);
        editTextSenha = findViewById(R.id.editTextSenhaCadastro);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        spinnerFuncao = findViewById(R.id.spinner);

        imageViewCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}