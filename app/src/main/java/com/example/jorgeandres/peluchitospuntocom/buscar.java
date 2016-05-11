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

public class buscar extends Activity {
    private EditText nombre1;
    private Button Buscar;
    private TextView buscar;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        nombre1= (EditText) findViewById(R.id.nombreabuscar);
        Buscar= (Button) findViewById(R.id.bBuscando);
        buscar = (TextView)findViewById(R.id.Textbuscado);
        basededatos Pelu = new basededatos(this, "Peluches",null, 2);
        db= Pelu.getWritableDatabase();

    }

    public void buscando(View view) {

        String nombre = nombre1.getText().toString();

        Toast.makeText(this, "Buscando Su Peluchito", Toast.LENGTH_SHORT).show();

        mostra1(nombre);
    }

    protected void mostra1(String  nombre) {
        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT nombre,cantidad,precio,id FROM peluche where nombre='"+nombre+"'", null);
        String Nombre="",cantidad="",precio="",id="";
        buscar.setText("");
        if (c.moveToFirst()) {
            Nombre = c.getString(0);
            cantidad = c.getString(1);
            id = c.getString(3);
            precio = c.getString(2);
            Toast.makeText(this, "Mostrando el peluche", Toast.LENGTH_SHORT).show();

            buscar.setText("id:" + id + "\n" + "Nombre: " + Nombre + "\n" + "cantidad: " + cantidad + "\n" +
                    " Precio:" + precio + "\n");
            db.close();
            nombre1.setText("");
        }
        else {
            Toast.makeText(this, "No Existe Peluche en Peluchito.com", Toast.LENGTH_SHORT).show();
        }


    }

    public void Regresar2(View view) {

        finish();
    }
}
