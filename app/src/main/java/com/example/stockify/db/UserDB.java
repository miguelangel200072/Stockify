package com.example.stockify.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stockify.entidades.User;

public class UserDB {

    private SQLiteDatabase mDatabase;

    public UserDB(SQLiteDatabase database) {
        mDatabase = database;
    }

    public User getUser(String nom, String pass) {
        User user = null;
        String[] columns = {"idUsuario", "nom", "pass"};
        String selection = "nom = ? AND pass = ?";
        String[] selectionArgs = {nom, pass};
        Cursor cursor = mDatabase.query("usuario", columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex("idUsuario"));
            String nombreUsuario = cursor.getString(cursor.getColumnIndex("nom"));
            String contrasenaUsuario = cursor.getString(cursor.getColumnIndex("pass"));
            user = new User(id, nombreUsuario, contrasenaUsuario);
        }
        cursor.close();
        return user;
    }
}
