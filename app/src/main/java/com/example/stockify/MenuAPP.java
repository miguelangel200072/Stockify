package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuAPP extends AppCompatActivity {
    Button btnInsertar, btnBuscar, btnGenerar, btnCambio;
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        tvUser = findViewById(R.id.tvUser);
        String username = getIntent().getStringExtra("username");
        tvUser.setText(username);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnGenerar = findViewById(R.id.btnGenerar);
        btnCambio = findViewById(R.id.btnCambio);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuAPP.this, InsertarProducto.class);
                startActivity(intent);
            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuAPP.this, ListarProducto.class);
                startActivity(intent);
            }
        });
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuAPP.this, GenerarCodigo.class);
                startActivity(intent);
            }
        });
        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuAPP.this, CambioStand.class);
                String username = tvUser.getText().toString();
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}