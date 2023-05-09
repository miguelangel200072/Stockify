package com.example.stockify.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.stockify.entidades.Producto;

import java.util.ArrayList;

public class ListarProductoDB extends DatabaseHelper{
    static Context context;
    private static final String TABLE_PRODUCTO = "producto";


    public ListarProductoDB(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public static ArrayList<Producto> listarProducto(String codigo){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ArrayList<Producto> listaProducto = new ArrayList<>();
        Producto producto = null;
        Cursor cursorProducto = null;

        cursorProducto = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTO +" WHERE codigo = " + codigo, null);
        if (cursorProducto.moveToFirst()){
            do{
                producto = new Producto();
                producto.setDescr(cursorProducto.getString(0));
                producto.setCodigo(cursorProducto.getString(1));
                producto.setStandNuevo(cursorProducto.getString(2));
                listaProducto.add(producto);
            } while (cursorProducto.moveToNext());
        }
        cursorProducto.close();
        return listaProducto;
    }
}
