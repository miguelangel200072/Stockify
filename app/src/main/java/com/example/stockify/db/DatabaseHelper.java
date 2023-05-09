package com.example.stockify.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "stockify.db";
    private static final int DATABASE_VERSION = 1;

    // Tabla "usuario"
    private static final String CREATE_TABLE_USUARIO = "CREATE TABLE usuario (" +
            "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nom TEXT," +
            "pass TEXT" +
            ")";

    // Tabla "producto"
    private static final String CREATE_TABLE_PRODUCTO = "CREATE TABLE producto (" +
            "codigo TEXT PRIMARY KEY," +
            "standNuevo TEXT," +
            "descr TEXT" +
            ")";

    // Tabla "historico"
    private static final String CREATE_TABLE_HISTORICO = "CREATE TABLE historico (" +
            "idCambio INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuario INTEGER," +
            "standNuevo TEXT," +
            "standAnterior TEXT," +
            "idProd INTEGER," +
            "fecha DATETIME," +
            "FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario)," +
            "FOREIGN KEY(idProd) REFERENCES producto(idProd)," +
            "FOREIGN KEY(standNuevo) REFERENCES producto(standNuevo)" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Aquí puedes crear tus tablas y definir su estructura
        // Crear tablas
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_PRODUCTO);
        db.execSQL(CREATE_TABLE_HISTORICO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí puedes actualizar la estructura de tus tablas si cambia la versión de la base de datos

    }
}
