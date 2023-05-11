package com.example.stockify.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ObtenerIdDB extends DatabaseHelper {
    private Context mContext;
    private static final String TABLE_PRODUCTO = "producto";

    public ObtenerIdDB(Context context) {
        super(context);
        mContext = context;
    }

    public static int obtenerId(EditText etcodigo, int numId) {
        String codigo = etcodigo.getText().toString();

        MostrarStandDB dbHelper = new MostrarStandDB(etcodigo.getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Realizar la consulta
        String[] projection = { "idProd" };
        String selection = "codigo = ?";
        String[] selectionArgs = { codigo };
        Cursor cursor = db.query(TABLE_PRODUCTO, projection, selection, selectionArgs, null, null, null);
        Log.d("mostrarStand", "filas: " + cursor.getCount());

        // Obtener el valor del campo "idProd"
        if (cursor.moveToFirst()) {
            numId = cursor.getInt(cursor.getColumnIndexOrThrow("idProd"));
            Log.d("mostrarStand", "idProd: " + numId);


        }

        // Cerrar el cursor y la base de datos
        cursor.close();
        db.close();
        return numId;
    }


}
