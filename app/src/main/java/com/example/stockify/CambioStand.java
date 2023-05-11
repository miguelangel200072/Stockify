package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stockify.db.CambioSHistoricoDB;
import com.example.stockify.db.CambioSProductoDB;
import com.example.stockify.db.InsertarProductoDB;
import com.example.stockify.db.MostrarStandDB;
import com.example.stockify.db.ObtenerIdDB;
import com.example.stockify.db.ObtenerIdUsuarioDB;

import java.util.Calendar;

public class CambioStand extends AppCompatActivity {
    Button btnCambio, btnScan;
    TextView tvStand, tvUser;
    EditText etStandNuevo, etArt;
    int numId, id2, idUsuario;
    String SN, SA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_stand);
        btnCambio = findViewById(R.id.btnCambio);
        btnScan = findViewById(R.id.btnScan);
        tvStand = findViewById(R.id.tvStand);
        tvUser = findViewById(R.id.tvUser);
        String username = getIntent().getStringExtra("username");
        tvUser.setText(username);
        etStandNuevo = findViewById(R.id.etStandNuevo);
        etArt = findViewById(R.id.etArt);



        etArt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //metodo para mostrar stand previo al cambio
                MostrarStandDB.mostrarStand(etArt, tvStand);
                //obtener el id del producto
                id2 = ObtenerIdDB.obtenerId(etArt, numId);
            }
        });
        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //etStandNuevo.setText(String.valueOf(id2));
                Log.d("mostrarStand", "idProd2: " + id2);
                //obtener el id del usuario que realiza el cambio
                idUsuario = ObtenerIdUsuarioDB.obtenerIdUsuario(tvUser, idUsuario);
                Log.d("mostrarStand", "idUsuario: " + id2);

                //metodo para actualizar stand tabla producto
                CambioSProductoDB cambioSProductoDB = new CambioSProductoDB(CambioStand.this);
                cambioSProductoDB.cambioSProducto(etArt.getText().toString(), etStandNuevo.getText().toString());
                SN = etStandNuevo.getText().toString();
                SA = tvStand.getText().toString();

                CambioSHistoricoDB dbContactos = new CambioSHistoricoDB(CambioStand.this);
                long id = dbContactos.cambioSHistorico(id2, SN, SA,idUsuario, getDateTime());


            }
        });
    }

    public String getDateTime() {
        // Obtiene la fecha y hora actual
        Calendar cal = Calendar.getInstance();

        // Obtiene la información de la fecha y hora actual
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // Se suma 1 porque los meses empiezan en 0
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        // Formatea la fecha y hora como una cadena
        String dateTime = String.format("%d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, second);

        return dateTime;
    }
}