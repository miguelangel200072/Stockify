package com.example.stockify.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ObtenerIdUsuarioDB extends DatabaseHelper {
    private Context mContext;
    private static final String TABLE_USUARIO = "usuario";

    public ObtenerIdUsuarioDB(Context context) {
        super(context);
        mContext = context;
    }

    public static int obtenerIdUsuario(TextView tvUser, int idUsuario) {
        String nom = tvUser.getText().toString();

        MostrarStandDB dbHelper = new MostrarStandDB(tvUser.getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Realizar la consulta
        String[] projection = { "idUsuario" };
        String selection = "nom = ?";
        String[] selectionArgs = { nom };
        Cursor cursor = db.query(TABLE_USUARIO, projection, selection, selectionArgs, null, null, null);
        Log.d("mostrarStand", "filas: " + cursor.getCount());

        // Obtener el valor del campo "idProd"
        if (cursor.moveToFirst()) {
            idUsuario = cursor.getInt(cursor.getColumnIndexOrThrow("idUsuario"));
            Log.d("mostrarStand", "idUsuario2: " + idUsuario);


        }

        // Cerrar el cursor y la base de datos
        cursor.close();
        db.close();
        return idUsuario;
    }


}
