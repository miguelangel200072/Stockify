package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.stockify.adaptadores.ListaProductoAdapter;
import com.example.stockify.db.ListarProductoDB;
import com.example.stockify.entidades.Producto;

import java.util.ArrayList;

public class ListarProducto extends AppCompatActivity {
    RecyclerView listaProducto;
    ArrayList<Producto> listaArrayProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_producto);
        listaProducto = findViewById(R.id.listaProducto);
        listaProducto.setLayoutManager(new LinearLayoutManager(this));

        ListarProductoDB listarProductoDB = new ListarProductoDB(ListarProducto.this);
        listaArrayProducto = new ArrayList<>();
        ListaProductoAdapter adapter = new ListaProductoAdapter(ListarProductoDB.listarProducto());
        listaProducto.setAdapter(adapter);
    }
}