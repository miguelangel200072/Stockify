package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockify.db.InsertarProductoDB;

public class InsertarProducto extends AppCompatActivity {
    EditText etCodigo, etStandNuevo, etDescr;
    Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_producto);

        etCodigo = findViewById(R.id.etCodigo);
        etStandNuevo = findViewById(R.id.etStandNuevo);
        etDescr = findViewById(R.id.etDescr);
        btnInsertar = findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!etCodigo.getText().toString().equals("") && !etStandNuevo.getText().toString().equals("") && !etDescr.getText().toString().equals("")) {

                    InsertarProductoDB dbContactos = new InsertarProductoDB(InsertarProducto.this);
                    long id = dbContactos.insertarProducto(etCodigo.getText().toString(), etStandNuevo.getText().toString(), etDescr.getText().toString());

                    if (id > 0) {
                        Toast.makeText(InsertarProducto.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(InsertarProducto.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(InsertarProducto.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar() {
        etCodigo.setText("");
        etStandNuevo.setText("");
        etDescr.setText("");
    }
}