package com.example.medico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;

public class MainPaciente extends AppCompatActivity {
    private EditText txtname;
    private EditText txtdni;
    private  EditText txtdireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paciente);
        txtname = findViewById(R.id.txtnombre);
        txtdni = findViewById(R.id.txtdni);
        txtdireccion = findViewById(R.id.txtdireccion);

    }
    public void goToMain(View view){
        Intent intent = new Intent();
        intent.putExtra("nombre",txtname.getText().toString());
        intent.putExtra("dni",txtdni.getText().toString());
        intent.putExtra("direccion",txtdireccion.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}