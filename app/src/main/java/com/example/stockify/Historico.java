package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.stockify.db.DatabaseHelper;

public class Historico extends AppCompatActivity {
  /*  private DatabaseHelper dbHelper;
    Context context;
        dbHelper = new DatabaseHelper(context);

    EditText etArt;
    TextView tvUser;
    Button btnMostrar;
    TableLayout tlHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        tvUser = findViewById(R.id.tvUser);
        String username = getIntent().getStringExtra("username");
        tvUser.setText(username);
        etArt = findViewById(R.id.etArt);
        btnMostrar = findViewById(R.id.btnMostrar);
        //tlHistorico = findViewById(R.id.tlHistorico);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarHistorico(etArt.getText().toString());
            }
        });
    }
    public void mostrarHistorico(String acodar) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM historico WHERE idProd = ?", new String[]{acodar});

        TableLayout tableLayout = findViewById(R.id.tlHistorico);
        tableLayout.removeAllViews();

        TableRow rowHeader = new TableRow(getApplicationContext());
        rowHeader.setBackgroundColor(Color.parseColor("#C73F31"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        TextView labelFecha = new TextView(getApplicationContext());
        labelFecha.setText("Fecha");
        labelFecha.setTextColor(getResources().getColor(R.color.white));
        labelFecha.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
        labelFecha.setPadding(5, 5, 5, 5);

        rowHeader.addView(labelFecha);

        TextView labelUsuario = new TextView(getApplicationContext());
        labelUsuario.setText("idUsuario");
        labelUsuario.setTextColor(getResources().getColor(R.color.white));
        labelUsuario.setPadding(5, 5, 5, 5);
        labelUsuario.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
        rowHeader.addView(labelUsuario);

        TextView labelStandOriginal = new TextView(getApplicationContext());
        labelStandOriginal.setText("Stand Original");
        labelStandOriginal.setTextColor(getResources().getColor(R.color.white));
        labelStandOriginal.setPadding(5, 5, 5, 5);
        labelStandOriginal.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
        rowHeader.addView(labelStandOriginal);

        TextView labelStandNuevo = new TextView(getApplicationContext());
        labelStandNuevo.setText("Stand Nuevo");
        labelStandNuevo.setTextColor(getResources().getColor(R.color.white));
        labelStandNuevo.setPadding(5, 5, 5, 5);
        labelStandNuevo.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
        rowHeader.addView(labelStandNuevo);

        tableLayout.addView(rowHeader);

        if (cursor.moveToFirst()) {
            do {
                String idUser = cursor.getString(cursor.getColumnIndex("idUser"));
                String standAnterior = cursor.getString(cursor.getColumnIndex("standAnterior"));
                String standNuevo = cursor.getString(cursor.getColumnIndex("standNuevo"));
                String fecha = cursor.getString(cursor.getColumnIndex("fecha"));

                TableRow row = new TableRow(getApplicationContext());
                row.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));

                TextView labelFechaValor = new TextView(getApplicationContext());
                labelFechaValor.setText(fecha);
                labelFechaValor.setPadding(8, 5, 5, 5);
                labelFechaValor.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
                row.addView(labelFechaValor);

                TextView labelUsuarioValor = new TextView(getApplicationContext());
                labelUsuarioValor.setText(idUser);
                labelUsuarioValor.setPadding(8, 5, 5, 5);
                labelUsuarioValor.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
                row.addView(labelUsuarioValor);

                TextView labelStandOriginalValor = new TextView(getApplicationContext());
                labelStandOriginalValor.setText(standAnterior);
                labelStandOriginalValor.setPadding(8, 5, 5, 5);
                labelStandOriginalValor.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
                row.addView(labelStandOriginalValor);

                TextView labelStandNuevoValor = new TextView(getApplicationContext());
                labelStandNuevoValor.setText(standNuevo);
                labelStandNuevoValor.setPadding(8, 5, 5, 5);
                labelStandNuevoValor.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
                row.addView(labelStandNuevoValor);
                tableLayout.addView(row);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

    }*/
}