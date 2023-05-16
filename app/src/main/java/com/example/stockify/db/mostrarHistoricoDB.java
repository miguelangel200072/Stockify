package com.example.stockify.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.stockify.R;


import com.example.stockify.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class mostrarHistoricoDB {

    public static void mostrarHistorico(Context context, int idProd, TableLayout tablaResultados) {
        // Abrir la base de datos y ejecutar la consulta
        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();
        String query = "SELECT idUsuario, standAnterior, standNuevo, fecha FROM historico WHERE idProd = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(idProd)});

        // Crear una estructura de datos en tu aplicación para almacenar los resultados de la consulta.
        ArrayList<HashMap<String, String>> resultados = new ArrayList<HashMap<String, String>>();

        // Iterar a través de los resultados de la consulta y agregarlos a la estructura de datos en tu aplicación.
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> resultado = new HashMap<String, String>();
                resultado.put("idUsuario", cursor.getString(0));
                resultado.put("standAnterior", cursor.getString(1));
                resultado.put("standNuevo", cursor.getString(2));
                resultado.put("fecha", cursor.getString(3));
                resultados.add(resultado);
            } while (cursor.moveToNext());
        }

        // Limpiar la tabla de resultados antes de agregar los nuevos datos
        tablaResultados.removeAllViews();

        // Agregar las etiquetas de columna
        TableRow encabezado = new TableRow(context);
        encabezado.setBackgroundColor(Color.parseColor("#FFA521"));
        TextView etiquetaIdUsuario = new TextView(context);
        etiquetaIdUsuario.setText("ID Usuario");
        etiquetaIdUsuario.setTextColor(Color.BLACK);
        etiquetaIdUsuario.setGravity(Gravity.CENTER);
        etiquetaIdUsuario.setPadding(10, 10, 10, 10);
        encabezado.addView(etiquetaIdUsuario);
        TextView etiquetaStandAnterior = new TextView(context);
        etiquetaStandAnterior.setText("Stand Anterior");
        etiquetaStandAnterior.setTextColor(Color.BLACK);
        etiquetaStandAnterior.setGravity(Gravity.CENTER);
        etiquetaStandAnterior.setPadding(10, 10, 10, 10);
        encabezado.addView(etiquetaStandAnterior);
        TextView etiquetaStandNuevo = new TextView(context);
        etiquetaStandNuevo.setText("Stand Nuevo");
        etiquetaStandNuevo.setTextColor(Color.BLACK);
        etiquetaStandNuevo.setGravity(Gravity.CENTER);
        etiquetaStandNuevo.setPadding(10, 10, 10, 10);
        encabezado.addView(etiquetaStandNuevo);
        TextView etiquetaFecha = new TextView(context);
        etiquetaFecha.setText("Fecha");
        etiquetaFecha.setTextColor(Color.BLACK);
        etiquetaFecha.setGravity(Gravity.CENTER);
        etiquetaFecha.setPadding(10, 10, 10, 10);
        encabezado.addView(etiquetaFecha);

        tablaResultados.addView(encabezado);

        // Agregar los datos a la tabla de resultados
        for (HashMap<String, String> resultado : resultados) {
            TableRow fila = new TableRow(context);
            TextView idUsuario = new TextView(context);
            idUsuario.setText(resultado.get("idUsuario"));
            idUsuario.setTextColor(context.getResources().getColor(R.color.white));
            idUsuario.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
            fila.addView(idUsuario);
            TextView standAnterior = new TextView(context);
            standAnterior.setText(resultado.get("standAnterior"));
            standAnterior.setTextColor(context.getResources().getColor(R.color.white));
            standAnterior.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
            fila.addView(standAnterior);
            TextView standNuevo = new TextView(context);
            standNuevo.setText(resultado.get("standNuevo"));
            standNuevo.setTextColor(context.getResources().getColor(R.color.white));
            standNuevo.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
            fila.addView(standNuevo);
            TextView fecha = new TextView(context);
            fecha.setText(resultado.get("fecha"));
            fecha.setTextColor(context.getResources().getColor(R.color.white));
            fecha.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
            fila.addView(fecha);
            tablaResultados.addView(fila);
        }

        // Cerrar el cursor y la conexión a la base de datos.
        cursor.close();
        db.close();
    }
}
