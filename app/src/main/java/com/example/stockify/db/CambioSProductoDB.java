package com.example.stockify.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class CambioSProductoDB {
    private Context context;
    private static final String TABLE_PRODUCTO = "producto";
    private DatabaseHelper dbHelper;

    public CambioSProductoDB(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    public void cambioSProducto(String codigo, String standNuevo) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Crear un ContentValues con el nuevo valor del campo
        ContentValues values = new ContentValues();
        values.put("standNuevo", standNuevo);

        // Actualizar el campo "standNuevo" en la tabla "producto"
        int numRowsUpdated = db.update(TABLE_PRODUCTO, values, "codigo=?", new String[]{codigo});

        if (numRowsUpdated > 0) {
            Toast.makeText(context, "Actualización exitosa", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error al actualizar", Toast.LENGTH_SHORT).show();
        }

        // Cerrar la base de datos
        db.close();
    }
}
