package com.example.sistemarestaurante.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.sistemarestaurante.Adapters.ObsBebidaAdapter;
import com.example.sistemarestaurante.Model.BebidaPedida;
import com.example.sistemarestaurante.Model.Mesa;
import com.example.sistemarestaurante.Model.Pedido;
import com.example.sistemarestaurante.Model.Usuario;
import com.example.sistemarestaurante.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AdicionarObsBebidaActivity extends AppCompatActivity {

    //XML
    private RecyclerView recyclerObsPratos;
    private FloatingActionButton fabObsBebidas;
    private ObsBebidaAdapter obsBebidaAdapter ;

    //Model
    private Mesa mesa;
    private Pedido pedido;
    private List<BebidaPedida>  bebidaPedidas;
    private List<BebidaPedida>  bebidaPedidascomObs;
    private Pedido pedidosAtualizado = new Pedido();
    private Usuario garçom;
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiconar_obs_prato);

        recyclerObsPratos = findViewById(R.id.recyclerObsPratos);
        fabObsBebidas = findViewById(R.id.fabObsPratos);

        if (getIntent().getExtras() != null) {
            bebidaPedidas = (List<BebidaPedida>) getIntent().getExtras().getSerializable("bebidas");
            mesa = (Mesa) getIntent().getExtras().getSerializable("mesa");
            pedido = (Pedido) getIntent().getExtras().getSerializable("pedido");
        }


        obsBebidaAdapter = new ObsBebidaAdapter(bebidaPedidas,getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerObsPratos.setHasFixedSize(true);
        recyclerObsPratos.setLayoutManager(layoutManager);
        recyclerObsPratos.setAdapter(obsBebidaAdapter);
        fabObsBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    bebidaPedidascomObs = obsBebidaAdapter.getBebidaPedidascomObs();
                    if (mesa.getPedidos() == null) {
                        pedido.setBebida(bebidaPedidascomObs);
                        pedidos.add(pedido);
                    }
                    else {
                        pedidos = mesa.getPedidos();
                        pedido.setBebida(bebidaPedidascomObs);
                        pedidos.add(pedido);
                    }
                    mesa.setPedidos(pedidos);
                    mesa.salvarmesa();
                    finish();

            }
        });
    }
}