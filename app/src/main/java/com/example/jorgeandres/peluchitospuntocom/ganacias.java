package com.example.jorgeandres.peluchitospuntocom;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ganacias extends Activity {
    private TextView ganancia;
    String encabezado="(" + " Nombre - " + "Cantidad - " + "Valor Total - " + "Ganancia Total - " + "Cantidad Total "+ ")"+"\n";
    SQLiteDatabase db;
    SQLiteDatabase bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganacias);

        ganancia = (TextView)findViewById(R.id.ganancias_totales);

        basededatos Pelu= new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        basededatos ventas= new basededatos(this, "ventas", null, 2);
        bd = ventas.getWritableDatabase();

        Cursor v = bd.rawQuery("SELECT * FROM ventas", null);
        while (v.moveToNext())
        {
            encabezado+="  "+v.getString(0);
            encabezado+=" - "+v.getString(1);
            encabezado+=" - "+v.getString(2);
            encabezado+=" - "+v.getString(3);
            encabezado+=" - "+v.getString(4);
            encabezado+="\n";
        }

        ganancia.setText(encabezado);


    }
    
    public void Regresar5(View view) {

        finish();
    }
}



