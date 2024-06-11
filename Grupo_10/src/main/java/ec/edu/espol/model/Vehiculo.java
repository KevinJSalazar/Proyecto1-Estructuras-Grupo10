/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evin
 */
public class Vehiculo implements Serializable{
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipo;
    protected int precio;
    protected double kilometraje;
    protected Usuario propietario;

    public Vehiculo(String placa, String marca, String modelo, String tipo, int precio, double kilometraje, Usuario propietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", precio=" + precio + ", kilometraje=" + kilometraje + ", propietario=" + propietario + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.placa, other.placa);
    }
    
    public static void saveListVehiculosSer(ArrayList<Vehiculo> vehiculos){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vehiculos.ser"))){
            out.writeObject(vehiculos);
        } catch(IOException e){}
    }
    
    public static ArrayList<Vehiculo> readFileSer(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("vehiculos.ser"))){
            vehiculos = (ArrayList<Vehiculo>)in.readObject();
        } catch(ClassNotFoundException | IOException c){
        }
        return vehiculos;
    }
    
    public static boolean checkPlaca(ArrayList<Vehiculo> vehiculos, String placa){
        for(Vehiculo v : vehiculos){
            if(v.placa.equals(placa)){
                return true;
            }       
        }
        return false;
    }
    
    public static Vehiculo filtrarPlaca(ArrayList<Vehiculo> vehiculos, String placa){
        for(Vehiculo v : vehiculos){
            if(v.getPlaca().equals(placa))
                return v;
        }
        return null;
    }
    
    public static final ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos, String tipo, String marca, String modelo, int preMin, int preMax, double kilMin, double kilMax){
        if(kilMin < 0 || kilMax < 0 || preMin < 1 || preMax < 0){
            throw new NegativeNumberException();
        }
        ArrayList<Vehiculo> vehiculosFil = new ArrayList<>();
        for(Vehiculo v : vehiculos){
            if(tipo.isEmpty() || tipo.equals("Todos") || tipo.equals(v.tipo)){
                if(marca.isEmpty() || marca.equals("Todos") || marca.equals(v.marca)){
                    if(modelo.isEmpty() || modelo.equals("Todos") || modelo.equals(v.modelo)){
                        if(kilMin <= v.kilometraje && v.kilometraje <= kilMax){
                            if(preMin <= v.precio && v.precio <= preMax){
                                vehiculosFil.addLast(v);
                            }
                        }
                    }
                }
            }
        }
        return vehiculosFil;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }
}
