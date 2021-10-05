package com.example.medico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainVista extends AppCompatActivity {
    private EditText peso;
    private  EditText temp;
    private EditText presion;
    private EditText saturacion;
    private TextView show_dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vista);
        peso = findViewById(R.id.txtpeso);
        temp = findViewById(R.id.txttemp);
        presion = findViewById(R.id.txtpresion);
        saturacion = findViewById(R.id.txtsaturacion);
        show_dni = findViewById(R.id.textView);

        Intent intent = getIntent();
        String dni = intent.getStringExtra("dni");
        show_dni.setText("DNI: " + dni);
    }
    public void goVistaToMain(View view){
        Intent intent = new Intent();
        intent.putExtra("peso", peso.getText().toString());
        intent.putExtra("temp",temp.getText().toString());
        intent.putExtra("presion",presion.getText().toString());
        intent.putExtra("saturacion",saturacion.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}