package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stockify.db.InsertarProductoDB;

public class InsertarProducto extends AppCompatActivity {
    EditText etCodigo, etStandNuevo, etDescr;
    TextView tvUser;
    Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_producto);
        tvUser = findViewById(R.id.tvUser);
        String username = getIntent().getStringExtra("username");
        tvUser.setText(username);
        etCodigo = findViewById(R.id.etCodigo);
        etStandNuevo = findViewById(R.id.etStandNuevo);
        etDescr = findViewById(R.id.etDescr);
        btnInsertar = findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = etCodigo.getText().toString();
                String standNuevo = etStandNuevo.getText().toString();
                String descr = etDescr.getText().toString();

                if (codigo.isEmpty() || standNuevo.isEmpty() || descr.isEmpty()) {
                    Toast.makeText(InsertarProducto.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                    return;
                }

                // Realizar la comprobación de existencia del producto por código
                boolean productoExistente = checkProductoExistente(codigo);

                if (productoExistente) {
                    Toast.makeText(InsertarProducto.this, "YA EXISTE UN PRODUCTO CON EL MISMO CÓDIGO", Toast.LENGTH_LONG).show();
                    return;
                }

                // Insertar el producto en la base de datos
                InsertarProductoDB dbContactos = new InsertarProductoDB(InsertarProducto.this);
                long id = dbContactos.insertarProducto(codigo, standNuevo, descr);

                if (id > 0) {
                    Toast.makeText(InsertarProducto.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(InsertarProducto.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
    private void limpiar() {
        etCodigo.setText("");
        etStandNuevo.setText("");
        etDescr.setText("");
    }
    private boolean checkProductoExistente(String codigo) {
        // Realizar la consulta en la base de datos para comprobar la existencia del producto
        InsertarProductoDB dbContactos = new InsertarProductoDB(InsertarProducto.this);
        return dbContactos.checkProductoExistente(codigo);
    }
}