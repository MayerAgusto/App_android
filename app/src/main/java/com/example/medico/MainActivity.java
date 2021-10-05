package com.example.medico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txtpaciente;
    private Paciente paciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtpaciente = findViewById(R.id.txtpaciente);
        paciente = new Paciente();

    }
    public void goToPaciente(View view){
        //Para ir al activity donde se obtienen los datos del paciente
        Intent intent = new Intent(this, MainPaciente.class);
        startActivityForResult(intent,1);
    }
    public void goToVista(View view){
        Intent intent = new Intent(this, MainVista.class);
        intent.putExtra("dni", paciente.getDni());
        startActivityForResult(intent, 2);
    }
    public void sendEmail(View view){
        //funcion para enviar el correo electronico
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{});
        intent.putExtra(Intent.EXTRA_SUBJECT, paciente.getNombre());
        intent.putExtra(Intent.EXTRA_TEXT, "Mr. " + paciente.getNombre());
        startActivity(intent);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                final String nombre = data.getStringExtra("nombre");
                final String dni = data.getStringExtra("dni");
                final String direccion = data.getStringExtra("direccion");
                paciente.insertPacientData(dni,nombre, direccion);
                txtpaciente.setText(paciente.getDataPaciente());
            }else{
                Toast.makeText(this, "Error al recibir los datos", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == 2){
            if (resultCode == Activity.RESULT_OK){
                final String peso = data.getStringExtra("peso");
                final String temp = data.getStringExtra("temp");
                final String presion = data.getStringExtra("presion");
                final String saturacion = data.getStringExtra("saturacion");
                try {
                    double n_peso = Double.parseDouble(peso);
                    double n_temp = Double.parseDouble(temp);
                    int n_presion = Integer.parseInt(presion);
                    double n_saturacion = Double.parseDouble(saturacion);

                    paciente.insertData(n_peso, n_temp, n_presion, n_saturacion);
                    txtpaciente.setText(paciente.getDataPaciente());
                }catch (NumberFormatException  e){
                    Toast.makeText(this, "Datos Invalidos", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Error al recibir los datos", Toast.LENGTH_SHORT).show();
            }
        }
    }

}