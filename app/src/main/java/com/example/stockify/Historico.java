package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stockify.db.DatabaseHelper;
import com.example.stockify.db.ObtenerIdDB;
import com.example.stockify.db.mostrarHistoricoDB;

import java.util.ArrayList;
import java.util.HashMap;

public class Historico extends AppCompatActivity {

    // Definir una referencia a la tabla de resultados en el archivo XML del layout
    private TableLayout tablaResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        // Inflar la tabla de resultados desde el archivo XML del layout
        tablaResultados = findViewById(R.id.tlHistorico);
        EditText etArt = (EditText) findViewById(R.id.etArt);
        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);
        TextView tvUser = findViewById(R.id.tvUser);
        String username = getIntent().getStringExtra("username");
        tvUser.setText(username);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idProd = ObtenerIdDB.obtenerId(etArt, 0);
                Log.d("mostrarStand", "idProd: " + idProd);
                if (idProd == 0){
                    Toast.makeText(Historico.this, "Artículo no encontrado", Toast.LENGTH_SHORT).show();
                }else {
                    mostrarHistoricoDB.mostrarHistorico(Historico.this, idProd, tablaResultados);
                }

            }
        });

    }
}