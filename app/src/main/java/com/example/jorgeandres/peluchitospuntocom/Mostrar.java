package com.example.jorgeandres.peluchitospuntocom;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mostrar extends Activity {

    private TextView consultar;
    String Lista=" Nombre - " + "Id  -  " + "Cantidad - " + "Precio " + "\n";
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        consultar=(TextView)findViewById(R.id.Consultar1);
        basededatos Pelu= new basededatos(this,"Peluches",null,2);
        db = Pelu.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM peluche", null);

        while (c.moveToNext())
        {
            Lista+="  "+c.getString(0);
            Lista+="  -  "+c.getString(1);
            Lista+="  -  "+c.getString(2);
            Lista+="  -  "+c.getString(3);
            Lista+="\n";
        }

        consultar.setText(Lista);
    }
    public void Regresar1(View view) {

        finish();
    }


}
