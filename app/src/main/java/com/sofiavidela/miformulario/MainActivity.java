package com.sofiavidela.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String nombre, email, descripcionDeContacto, telefono, fechaDeNacimiento;
    String cnombre, cemail, cdescripcionDeContacto, ctelefono, cfechaDeNacimiento;
    DatePickerDialog.OnDateSetListener SetListenerDate;
    EditText ETnombre;
    EditText ETfechaDeNacimiento;
    EditText ETtelefono;
    EditText ETemail;
    EditText ETdescripcionDeContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Declaración de Textviews con su nombre de id
        ETnombre               = (EditText) findViewById(R.id.editTextTextPersonName);
        ETfechaDeNacimiento    = (EditText) findViewById(R.id.editTextDate);
        ETtelefono             = (EditText) findViewById(R.id.editTextPhone);
        ETemail                = (EditText) findViewById(R.id.editTextTextEmailAddress);
        ETdescripcionDeContacto= (EditText) findViewById(R.id.DescripcionDeContacto);


        //Recuperacion de datos de MainActivity.class
        Bundle parametros = getIntent().getExtras();
        if (parametros != null ){
            cnombre = parametros.getString(getResources().getString(R.string.pnombre));
            cfechaDeNacimiento = parametros.getString(getResources().getString(R.string.pfechaDeNacimiento));
            ctelefono = parametros.getString(getResources().getString(R.string.ptelefono));
            cemail = parametros.getString(getResources().getString(R.string.pemail));
            cdescripcionDeContacto = parametros.getString(getResources().getString(R.string.pdescripcionDeContacto));
            ETnombre.setText(cnombre);
            ETfechaDeNacimiento.setText(cfechaDeNacimiento);
            ETtelefono.setText(ctelefono);
            ETemail.setText(cemail);
            ETdescripcionDeContacto.setText(cdescripcionDeContacto);
        }




        //Piket de fecha
        ETfechaDeNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendario = Calendar.getInstance();
                int year    = calendario.get(Calendar.YEAR);
                int month   = calendario.get(Calendar.MONTH);
                int day     = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        SetListenerDate, year, month, day );
                dialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        SetListenerDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String Date = dayOfMonth +"/"+ month +"/"+ year;
                ETfechaDeNacimiento.setText(Date);
            }
        };


        //Boton +Intent
        Button boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObtenerInformacion();
                Intent intent = new Intent(MainActivity.this , Confirmacion_de_Datos.class);
                intent.putExtra(getResources().getString(R.string.pnombre),nombre);
                intent.putExtra(getResources().getString(R.string.pfechaDeNacimiento),fechaDeNacimiento);
                intent.putExtra(getResources().getString(R.string.ptelefono),telefono);
                intent.putExtra(getResources().getString(R.string.pemail),email);
                intent.putExtra(getResources().getString(R.string.pdescripcionDeContacto),descripcionDeContacto);
                startActivity(intent);
                finish();
            }
        });

    }

    private void ObtenerInformacion() {
        nombre                  = ETnombre.getText().toString().trim();
        fechaDeNacimiento       = ETfechaDeNacimiento.getText().toString().trim();
        telefono                = ETtelefono.getText().toString().trim();
        email                   = ETemail.getText().toString().trim();
        descripcionDeContacto   = ETdescripcionDeContacto.getText().toString().trim();
    }

}