package com.example.sistemarestaurante.Funcoes;

import android.content.Intent;
import android.os.Bundle;

import com.example.sistemarestaurante.Activitys.CadastroPratoActicity;
import com.example.sistemarestaurante.Activitys.MudarPratoStatusActivity;
import com.example.sistemarestaurante.Adapters.ListaPratoPedidosAdapter;
import com.example.sistemarestaurante.Cadastro_e_login.LoginActivity;
import com.example.sistemarestaurante.Firebase.ConfiguracaoFirebase;
import com.example.sistemarestaurante.Model.Mesa;
import com.example.sistemarestaurante.Model.Pedido;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class CozinhaActivity extends AppCompatActivity {

    //model
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Pedido> pedidosFiltrado = new ArrayList<>();

    //XML
    private RecyclerView recyclerListaPratoPedidos;
    private ListaPratoPedidosAdapter listaPratoPedidosAdapter;

    //Firebase
    private FirebaseAuth auth = ConfiguracaoFirebase.getAuth();
    private DatabaseReference databaseReference = ConfiguracaoFirebase.getDatabaseReference();
    private DatabaseReference mesaref;
    private DatabaseReference pedidoref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cozinha);

        //configurações iniciais
        recyclerListaPratoPedidos = findViewById(R.id.recyclerListaPratosPedidos);


        recuperarListaPedidos();

        //configura adapter
        listaPratoPedidosAdapter = new ListaPratoPedidosAdapter(pedidosFiltrado,getApplicationContext());
        //configurarecycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerListaPratoPedidos.setLayoutManager(layoutManager);
        recyclerListaPratoPedidos.setHasFixedSize(true);
        recyclerListaPratoPedidos.setAdapter(listaPratoPedidosAdapter);




    }

    public void recuperarListaPedidos () {
        mesaref = databaseReference.child("mesas");
        mesaref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pedidosFiltrado.clear();
                pedidos.clear();
                    for (DataSnapshot dados : snapshot.getChildren()) {
                        Mesa mesa = dados.getValue(Mesa.class);
                        if (mesa.getPedidos() != null) {
                            pedidos = mesa.getPedidos();
                            for (Pedido pedido : pedidos){
                                if (!pedido.getStatus().contains("pronto") && pedido.getComida() != null){
                                    pedidosFiltrado.add(pedido);
                                    Log.i("pedidosfiltrados", pedidosFiltrado.get(0).getStatus());
                                    listaPratoPedidosAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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