/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author evin
 */
public class Usuario implements Serializable{
    private String nombres;
    private String apellidos;
    private String correo;
    private String clave;
    private ArrayList<Vehiculo> vehiculos;

    public Usuario(String nombres, String apellidos, String correo, String clave, ArrayList<Vehiculo> vehiculos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.clave = clave;
        this.vehiculos = vehiculos;
    }
    
    
}
