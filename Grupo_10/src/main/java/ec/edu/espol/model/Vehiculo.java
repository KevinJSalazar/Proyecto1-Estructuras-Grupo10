/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.Serializable;

/**
 *
 * @author User evin
 */
public abstract class Vehiculo implements Serializable{
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int precio;
    protected int año;
    protected double kilometraje;
    protected Usuario usuario;

    public Vehiculo(String placa, String marca, String modelo, int precio, double kilometraje, Usuario usuario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.usuario = usuario;
    }
    
    
}