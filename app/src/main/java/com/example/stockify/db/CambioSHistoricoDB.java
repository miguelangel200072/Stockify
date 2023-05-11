package com.example.stockify.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class CambioSHistoricoDB extends DatabaseHelper{
    Context context;

    public CambioSHistoricoDB(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long cambioSHistorico(int idProd, String standNuevo, String standAnterior, int idUsuario, String fecha) {

        long id = 0;

        try {
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("idProd", idProd);
            values.put("standNuevo", standNuevo);
            values.put("standAnterior", standAnterior);
            values.put("idUsuario", idUsuario);
            values.put("fecha", fecha);

            id = db.insert("historico", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
}