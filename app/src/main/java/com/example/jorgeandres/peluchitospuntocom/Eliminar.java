package com.example.jorgeandres.peluchitospuntocom;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends Activity {

    private EditText nombre1;
    private Button Eliminando;
    String nombre="";
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        nombre1= (EditText) findViewById(R.id.nombre_eliminar);
        Eliminando= (Button) findViewById(R.id.bEliminando);
        nombre = nombre1.getText().toString();
        basededatos Pelu = new basededatos(this, "Peluches",null, 2);
        db= Pelu.getWritableDatabase();
    }

    public void eliminando(View view) {


        Toast.makeText(this, "Buscando Su Peluchito", Toast.LENGTH_SHORT).show();

        mostrar1(nombre);
    }
    protected void mostrar1(String  nombre) {
        this.nombre = nombre1.getText().toString();
        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        db.execSQL("DELETE FROM peluche WHERE nombre='"+this.nombre+"'");
        Toast.makeText(this, this.nombre, Toast.LENGTH_SHORT).show();
        nombre1.setText("");
        db.close();
        Toast.makeText(this, "Se Eliminó El Peluche", Toast.LENGTH_SHORT).show();

    }

    public void Regresar3(View view) {

        finish();
    }
}
