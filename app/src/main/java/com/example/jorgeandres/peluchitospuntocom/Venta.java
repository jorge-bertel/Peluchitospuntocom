package com.example.jorgeandres.peluchitospuntocom;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Venta extends Activity {

    String nombre = "";
    private EditText nombre1, Cantidad;
    private Button Comprar;
    private TextView Preciouni, Preciototal;
    SQLiteDatabase db;
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);

        nombre1 = (EditText)findViewById(R.id.eNombre_vendido);
        Cantidad = (EditText)findViewById(R.id.eCantidad_vendida);
        Preciouni = (TextView)findViewById(R.id.tPrecio);
        Preciototal = (TextView)findViewById(R.id.tPrecio_total);
        Comprar= (Button) findViewById(R.id.bVender);
        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();

    }

    public void vender (View view) {

        nombre = nombre1.getText().toString();
        String cantidad = Cantidad.getText().toString();

        Toast.makeText(this, "Buscando Peluchito a vender", Toast.LENGTH_SHORT).show();

        mostrar1(nombre, cantidad);

        nombre1.setText("");
        Cantidad.setText("");
    }
    protected void mostrar1(String nombre, String cantidad) {

        int Precios=0,total=0,canti=0, cant=0, Nueva_cantidad=0, acumulado=0,  cantidad1=0;
        String  Cant, Total, nueva_cantidad;

        basededatos Pelu = new basededatos(this, "Peluches", null, 2);
        db = Pelu.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT nombre,cantidad,precio FROM peluche where nombre='" + nombre + "'", null);




        if(c.moveToFirst()) {
            Cant = c.getString(1);
            Precios = c.getInt(2);
            canti = Integer.parseInt(cantidad);
            cant = Integer.parseInt(Cant);

              if(cant >=canti) {
                 total = canti * Precios;
               Total=String.valueOf(total);
                  Preciototal.setText(Total);
                Preciouni.setText(String.valueOf(Precios));
                Nueva_cantidad = cant-canti;
                nueva_cantidad=String.valueOf(Nueva_cantidad);
                db.execSQL("UPDATE peluche SET cantidad='" + nueva_cantidad + "' WHERE nombre='" + this.nombre + "'");

                  basededatos venta = new basededatos(this, "ventas", null, 2);
                  bd = venta.getWritableDatabase();
                Cursor v = bd.rawQuery("SELECT acumulado, cantidad FROM ventas", null);

            if(v.moveToLast()) {
              acumulado =v.getInt(0);
            cantidad1 = v.getInt(1);
            }

            acumulado+=total;
            cantidad1 +=canti;


             bd.execSQL("INSERT INTO ventas (valor,nombre,cantidad, acumulado, cantidadtotal) VALUES ('" + Total + "','" + nombre + "','" + cantidad + "','" + acumulado + "','" + cantidad1 + "') ");


            Toast.makeText(this, "Venta Exitosa", Toast.LENGTH_SHORT).show();

            if(Nueva_cantidad<= 5){

             hacer_notificacion(this.nombre, Nueva_cantidad);
            }


                 }else {Toast.makeText(this, "No Existe La Cantidad Pedida En El Momento", Toast.LENGTH_SHORT).show();}
            } else {Toast.makeText(this, "No Existe El Peluchito Buscado En EL Momento", Toast.LENGTH_SHORT).show();}


        }


    public void hacer_notificacion(String nombre, int Nueva_cantidad) {


        NotificationManager jorge = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("Warning").setContentText("Se esta agotando el peluche: "+nombre)
                .setTicker(String.valueOf(Nueva_cantidad)).setSmallIcon(R.drawable.mune);

        Intent i = new Intent(Venta.this, Notificacion.class);
        i.putExtra("Peluche", nombre);
        i.putExtra("Cantidad", String.valueOf(Nueva_cantidad));
        PendingIntent gil = PendingIntent.getActivity(Venta.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(gil);
        jorge.notify(1234, builder.build());
    }

    public void back(View view) {

        finish();
    }

}
