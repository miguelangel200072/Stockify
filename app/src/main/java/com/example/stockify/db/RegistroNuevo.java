package com.example.stockify.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class RegistroNuevo extends DatabaseHelper{
    Context context;

    public RegistroNuevo(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarContacto(String nom, String pass) {

        long id = 0;

        try {
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nom", nom);
            values.put("pass", pass);

            id = db.insert("usuario", null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
}
