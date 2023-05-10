package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stockify.db.MostrarStandDB;

public class CambioStand extends AppCompatActivity {
    Button btnCambio, btnScan;
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


        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostrarStandDB.mostrarStand(etArt, tvStand);
            }
        });
    }
}