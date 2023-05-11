package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockify.adaptadores.ListaProductoAdapter;
import com.example.stockify.db.ListarProductoAllDB;
import com.example.stockify.db.ListarProductoDB;
import com.example.stockify.entidades.Producto;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class ListarProducto extends AppCompatActivity {
    RecyclerView listaProducto;
    Button btnBuscar, btnScan, btnAll;
    EditText etArt;
    ArrayList<Producto> listaArrayProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_producto);
        listaProducto = findViewById(R.id.listaProducto);
        etArt = findViewById(R.id.etArt);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnScan = findViewById(R.id.btnScan);
        btnAll = findViewById(R.id.btnAll);
        listaProducto.setLayoutManager(new LinearLayoutManager(this));

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrador = new IntentIntegrator(ListarProducto.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Stockify");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
            }
        });


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
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListarProductoAllDB listarProductoAllDB =new ListarProductoAllDB(ListarProducto.this);
                listaArrayProducto = new ArrayList<>();
                ListaProductoAdapter adapter = new ListaProductoAdapter(ListarProductoAllDB.listarProducto());
                listaProducto.setAdapter(adapter);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                etArt.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}