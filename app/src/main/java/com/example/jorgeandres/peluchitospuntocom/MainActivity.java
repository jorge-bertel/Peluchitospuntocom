package com.example.jorgeandres.peluchitospuntocom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardar (View v){
        Intent i=new Intent(this,agregar.class);
        startActivity(i);
    }
    public void consultar (View v){
        Intent i=new Intent(this,Mostrar.class);
        startActivity(i);
    }
    public void buscar (View v){
        Intent i=new Intent(this,buscar.class);
        startActivity(i);
    }
    public void eliminarpelu (View v){
        Intent i=new Intent(this,Eliminar.class);
        startActivity(i);
    }

    public void modificar (View v){
        Intent i=new Intent(this,Actualizar.class);
        startActivity(i);
    }
    public void Venta(View v){
        Intent i=new Intent(this,Venta.class);
        startActivity(i);
    }
    public void ganancias(View v){
        Intent i=new Intent(this,ganacias.class);
        startActivity(i);
    }
}
