package com.example.sistemarestaurante.Activitys;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemarestaurante.Adapters.PratoPedidosAdapter;
import com.example.sistemarestaurante.Firebase.ConfiguracaoFirebase;
import com.example.sistemarestaurante.Model.Mesa;
import com.example.sistemarestaurante.Model.Prato;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FazerPedidosPratoActivity extends AppCompatActivity {

    //XML
    private RecyclerView recyclerPratos;
    private FloatingActionButton fab;
    private TextView textInfoMesaSelecionada;

    //model
    private Mesa mesaSelecionada;
    private List<Prato> listaPratos = new ArrayList<>();
    private PratoPedidosAdapter pratoPedidosAdapter;

    //firebase
    private  DatabaseReference databaseReference = ConfiguracaoFirebase.getDatabaseReference();
    private  DatabaseReference pratosref;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_pedidos_prato);

        recyclerPratos = findViewById(R.id.recyclerPratos);
        textInfoMesaSelecionada = findViewById(R.id.textInfoMesa);

        if(getIntent().getExtras() != null){
            mesaSelecionada = (Mesa)  getIntent().getExtras().getSerializable("mesa");
            textInfoMesaSelecionada.setText("Mesa: "+ mesaSelecionada.getNumeroMesa() +"   Nome Cliente: " + mesaSelecionada.getNomeCliente() );

        }

        recuperarpratos();

        //configurando adapter
        pratoPedidosAdapter = new PratoPedidosAdapter(listaPratos,getApplicationContext());
        //configurando recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPratos.setLayoutManager(layoutManager);
        recyclerPratos.setHasFixedSize(true);
        recyclerPratos.setAdapter(pratoPedidosAdapter);



    }

    @Override
    protected void onStop() {
        super.onStop();
        pratosref.removeEventListener(valueEventListener);
    }

    public void recuperarpratos () {
        pratosref = databaseReference.child("pratos");
        valueEventListener = pratosref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaPratos.clear();
                for (DataSnapshot dados : snapshot.getChildren()) {
                    if (dados.getValue(Prato.class).getIsDisponivel().contains("true")){
                         listaPratos.add(dados.getValue(Prato.class));
                    }
                    if (dados.getValue(Prato.class).getIsDisponivel().contains("false") && listaPratos.contains(dados.getValue(Prato.class)) ){
                        listaPratos.remove(dados.getValue(Prato.class));
                    }
                    pratoPedidosAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}