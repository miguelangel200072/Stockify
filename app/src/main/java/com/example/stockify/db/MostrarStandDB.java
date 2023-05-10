package com.example.stockify.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.TextView;

public class MostrarStandDB extends DatabaseHelper {
    private Context mContext;
    private static final String TABLE_PRODUCTO = "producto";

    public MostrarStandDB(Context context) {
        super(context);
        mContext = context;
    }

    public static void mostrarStand(EditText etcodigo, TextView stand) {
        String codigo = etcodigo.getText().toString();

        MostrarStandDB dbHelper = new MostrarStandDB(stand.getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Realizar la consulta
        String[] projection = { "standNuevo" };
        String selection = "codigo = ?";
        String[] selectionArgs = { codigo };
        Cursor cursor = db.query(TABLE_PRODUCTO, projection, selection, selectionArgs, null, null, null);

        // Obtener el valor del campo "standNuevo"
        String standNuevo = "";
        if (cursor.moveToFirst()) {
            standNuevo = cursor.getString(cursor.getColumnIndexOrThrow("standNuevo"));
        }
        // Mostrar el valor en un TextView
        stand.setText(standNuevo);

        // Cerrar el cursor y la base de datos
        cursor.close();
        db.close();
    }

}
