package com.example.jorgeandres.peluchitospuntocom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JORGE ANDRES on 09/05/2016.
 */
public class basededatos extends SQLiteOpenHelper {
    String base1="CREATE TABLE peluche(nombre TEXT, id INTEGER, cantidad INTEGER,precio INTEGER)";
    String base2 = "CREATE TABLE ventas(nombre TEXT, cantidad TEXT, valor INTEGER, acumulado INTEGER, cantidadtotal INTEGER)";

    public basededatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(base1);
        db.execSQL(base2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS peluche");
        db.execSQL("DROP TABLE IF EXISTS ventas");
        db.execSQL(base1);
        db.execSQL(base2);

    }
    //String base2="CREATE TABLE venta(nombre TEXT PRIMARY KEY AUTOINCREMENT,id INTEGER,cantidad INTEGER,precio INTEGER)";

}
