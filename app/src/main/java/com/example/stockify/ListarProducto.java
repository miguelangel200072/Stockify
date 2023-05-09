package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stockify.adaptadores.ListaProductoAdapter;
import com.example.stockify.db.ListarProductoDB;
import com.example.stockify.entidades.Producto;

import java.util.ArrayList;

public class ListarProducto extends AppCompatActivity {
    RecyclerView listaProducto;
    Button btnBuscar;
    EditText etArt;
    ArrayList<Producto> listaArrayProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_producto);
        listaProducto = findViewById(R.id.listaProducto);
        etArt = findViewById(R.id.etArt);
        btnBuscar = findViewById(R.id.btnBuscar);
        listaProducto.setLayoutManager(new LinearLayoutManager(this));

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo;
                codigo = etArt.getText().toString();
                ListarProductoDB listarProductoDB = new ListarProductoDB(ListarProducto.this);
                listaArrayProducto = new ArrayList<>();
                ListaProductoAdapter adapter = new ListaProductoAdapter(ListarProductoDB.listarProducto(codigo));
                listaProducto.setAdapter(adapter);
            }
        });

    }
}