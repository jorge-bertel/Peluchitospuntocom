package com.example.jorgeandres.peluchitospuntocom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Notificacion extends Activity {

    private TextView alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        alerta = (TextView)findViewById(R.id.alerta);
        Bundle extras = getIntent().getExtras();
        alerta.setText("Quedan solamente: " + extras.getString("Cantidad") + " Peluchitos " + "\n" + " Del Peluchito: " + extras.getString("Peluche"));


    }

    public void OK (View view) {

        finish();
    }
}
