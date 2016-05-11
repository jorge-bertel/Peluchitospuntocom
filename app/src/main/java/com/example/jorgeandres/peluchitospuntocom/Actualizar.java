package com.example.jorgeandres.peluchitospuntocom;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actualizar extends Activity {

    private EditText nombre1, Newcantidad;
    private Button Actualizando, buscando,atras1,atras2;
    private TextView Cantidad, Advertencia;
    String nombre="";

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        nombre1= (EditText) findViewById(R.id.enombre_actualizar);
        Actualizando= (Button) findViewById(R.id.bActualizando);
        atras1= (Button) findViewById(R.id.batras);
        atras2= (Button) findViewById(R.id.batras2);
        nombre = nombre1.getText().toString();
        Newcantidad = (EditText) findViewById(R.id.eCantidad_actualizar);
        Cantidad = (TextView) findViewById(R.id.NCantidad);
        Advertencia = (TextView) findViewById(R.id.tAvisos);
        buscando= (Button) findViewById(R.id.Buscando_peluche);


        basededatos Pelu = new basededatos(this, "Peluches",null, 2);
        db= Pelu.getWritableDatabase();
    }
    public void buscandopeluche(View view) {

        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        nombre = nombre1.getText().toString();
        Cursor c = db.rawQuery("SELECT nombre,cantidad FROM peluche where nombre='"+nombre+"'", null);

        if (c.moveToFirst()) {
            nombre1.setText(c.getString(0));
            Toast.makeText(this, "Mostrando el peluche", Toast.LENGTH_SHORT).show();

            db.close();
            Advertencia.setVisibility(View.VISIBLE);
            Actualizando.setVisibility(View.VISIBLE);
            Cantidad.setVisibility(View.VISIBLE);
            Newcantidad.setVisibility(View.VISIBLE);
            buscando.setVisibility(View.INVISIBLE);
            atras1.setVisibility(View.INVISIBLE);
            atras2.setVisibility(View.VISIBLE);
        }else
        { Toast.makeText(this, "No Existe Peluche en Peluchito.com", Toast.LENGTH_SHORT).show();}


    }
    public void actualizando(View view) {

        Toast.makeText(this, "Buscando Su Peluchito a Actualizar", Toast.LENGTH_SHORT).show();
        mostrar1(nombre);
    }
    protected void mostrar1(String  nombre) {
        this.nombre = nombre1.getText().toString();
        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        db.execSQL("UPDATE peluche SET cantidad='" + Newcantidad.getText().toString() + "' WHERE nombre='" + this.nombre + "'");

        db.close();
        Toast.makeText(this, "Se Actualizó El Peluche De Peluchitos.com", Toast.LENGTH_SHORT).show();
        nombre1.setText("");
        Newcantidad.setText("");

    }
    public void Regresar4(View view) {

        finish();
    }
}
