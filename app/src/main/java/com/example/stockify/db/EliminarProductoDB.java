package com.example.stockify.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class EliminarProductoDB extends DatabaseHelper{
    Context context;
    private static final String TABLE_PRODUCTO = "producto";

    public EliminarProductoDB(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public boolean eliminarProducto(String codigo) {
        Log.e("error", codigo);

        boolean correcto = false;

        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_PRODUCTO + " WHERE codigo = '" + codigo + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
}
