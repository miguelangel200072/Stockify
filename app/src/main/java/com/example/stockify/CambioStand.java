package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stockify.db.CambioSProductoDB;
import com.example.stockify.db.MostrarStandDB;

public class CambioStand extends AppCompatActivity {
    Button btnCambio, btnScan, button;
    TextView tvStand;
    EditText etStandNuevo, etArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_stand);
        btnCambio = findViewById(R.id.btnCambio);
        btnScan = findViewById(R.id.btnScan);
        tvStand = findViewById(R.id.tvStand);
        etStandNuevo = findViewById(R.id.etStandNuevo);
        etArt = findViewById(R.id.etArt);
        button = findViewById(R.id.button);


        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostrarStandDB.mostrarStand(etArt, tvStand);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CambioSProductoDB cambioSProductoDB = new CambioSProductoDB(CambioStand.this);
                cambioSProductoDB.cambioSProducto(etArt.getText().toString(), etStandNuevo.getText().toString());
            }
        });
    }
}