package com.example.jorgeandres.peluchitospuntocom;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class agregar extends AppCompatActivity {

    private EditText nombre1, numero, cantidad, precio;
    private Button save;
    private TextView mostrar;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        nombre1 = (EditText) findViewById(R.id.eNombre);
        numero = (EditText) findViewById(R.id.Numeropeluche);
        cantidad = (EditText) findViewById(R.id.Cantidadpeluche);
        precio = (EditText) findViewById(R.id.ePrecio);
        save = (Button) findViewById(R.id.bSave);
        mostrar = (TextView) findViewById(R.id.bmostrar);
    }

    public void guardarpeluche(View view) {
        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        String Nombre = nombre1.getText().toString();
        String Numero = numero.getText().toString();
        String Cantidad = cantidad.getText().toString();
        String Precio = precio.getText().toString();

        ContentValues agregarpeluche = new ContentValues();
        agregarpeluche.put("nombre", Nombre);
        agregarpeluche.put("id", Numero);
        agregarpeluche.put("cantidad", Cantidad);
        agregarpeluche.put("precio", Precio);
        db.insert("peluche", null, agregarpeluche);
        db.close();

        nombre1.setText("");
        numero.setText("");
        cantidad.setText("");
        precio.setText("");
        Toast.makeText(this, "Peluche Guardado", Toast.LENGTH_SHORT).show();

    }


    public void Regresar(View view) {

        finish();
    }
}
