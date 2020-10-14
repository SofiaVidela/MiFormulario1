package com.sofiavidela.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;
import android.widget.TextView;


public class Confirmacion_de_Datos extends AppCompatActivity {


    String nombre,fechaDeNacimiento,telefono,email,descripcionDeContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de__datos);

        //Recuperacion de datos de MainActivity.class
        Bundle parametros               = getIntent().getExtras();
        nombre                   = parametros.getString(getResources().getString(R.string.pnombre)) ;
        fechaDeNacimiento        = parametros.getString(getResources().getString(R.string.pfechaDeNacimiento));
        telefono                 = parametros.getString(getResources().getString(R.string.ptelefono));
        email                    = parametros.getString(getResources().getString(R.string.pemail));
        descripcionDeContacto    = parametros.getString(getResources().getString(R.string.pdescripcionDeContacto));

        //Declaración de Textviews con su nombre de id
        TextView tvnombre                   = (TextView) findViewById(R.id.tvnombre);
        TextView tvfechaDeNacimiento        = (TextView) findViewById(R.id.tvfechaDeNacimiento);
        TextView tvtelefono                 = (TextView) findViewById(R.id.tvtelefono);
        TextView tvemail                    = (TextView) findViewById(R.id.tvemail);
        TextView tvdescripcionDeContacto    = (TextView) findViewById(R.id.tvdescripcionDeContacto);

        //llenado del textviews con la información traída de MainActivity.class
        tvnombre.setText(nombre);
        tvfechaDeNacimiento.setText("Fecha de Nacimiento: " + fechaDeNacimiento);
        tvtelefono.setText("Telefono: "+ telefono);
        tvemail.setText("Email: " + email);
        tvdescripcionDeContacto.setText("Descripción de Contacto: "+ descripcionDeContacto);

        //Declaración de botones
        Button boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Confirmacion_de_Datos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), nombre);
                intent.putExtra(getResources().getString(R.string.pfechaDeNacimiento), fechaDeNacimiento);
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
                intent.putExtra(getResources().getString(R.string.pemail),email);
                intent.putExtra(getResources().getString(R.string.pdescripcionDeContacto), descripcionDeContacto);
                startActivity(intent);
                finish();
            }
        });


        Button boton3 =(Button)findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Datos = nombre+ " todo listo";
                Snackbar.make(v,Datos,Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Confirmacion_de_Datos.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}