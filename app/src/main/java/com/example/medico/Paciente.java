package com.example.medico;

import java.util.ArrayList;

public class Paciente {
    private String nombre="";
    private String dni="";
    private String direccion="";
    private ArrayList<Datos> datos;
    public Paciente(){
        datos = new ArrayList<Datos>();
    }

    private class Datos{
        private double peso = 0;
        private double temp= 0;
        private int presion = 0;
        private double saturacion = 0;

        public Datos(double peso, double temp, int presion, double saturacion){
            this.peso = peso;
            this.temp = temp;
            this.presion = presion;
            this.saturacion = saturacion;
        }
        public String showDatos(){
            String message = "[ \n";
            message += "Temperatura: \t" + this.temp+ "\n";
            message+= "Peso: \t" + this.peso + "\n";
            message+= "Presion: \t" + this.presion + "\n";
            message+= "Saturacion: \t" + this.saturacion + "\n";
            message += "] \n";
            return message;
        }
    }
    public String getDataPaciente() {
        String paciente = "Nombre: \t" + this.nombre +"\n";
        paciente += "DNI: \t" + this.dni + "\n";
        paciente += "Direccion: \t" + this.direccion + "\n";
        for(int i= 0; i < datos.size(); i++){
            paciente += datos.get(i).showDatos();
        }
        return paciente;
    }
    public void insertData(double peso, double temp, int presion, double saturacion) {
        Datos dato = new Datos(peso, temp,presion,saturacion);
        datos.add(dato);
    }
    public void insertPacientData(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public String getDni(){return this.dni;}
    public String getDireccion(){return this.direccion;}
    public String getNombre(){return this.nombre;}

}
