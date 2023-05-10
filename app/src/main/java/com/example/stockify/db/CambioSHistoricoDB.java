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
    public long cambioSHistorico(String codigo, String standNuevo, String descr) {

        long id = 0;

        try {
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("codigo", codigo);
            values.put("standNuevo", standNuevo);
            values.put("descr", descr);

            id = db.insert("producto", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
}