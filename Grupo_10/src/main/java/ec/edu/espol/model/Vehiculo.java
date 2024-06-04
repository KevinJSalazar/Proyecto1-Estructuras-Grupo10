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
import java.util.Comparator;

/**
 *
 * @author User evin
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
    
//    @Override
//        public String toString() {
//            return "Vehiculo{" +
//                    "placa='" + placa + '\'' +
//                    ", marca='" + marca + '\'' +
//                    ", modelo='" + modelo + '\'' +
//                    ", precio=" + precio +
//                    ", kilometraje=" + kilometraje +
//                    '}';
//        }
    
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
//    
    public static boolean checkPlaca(List<Vehiculo> vehiculos, String placa){
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).placa.equals(placa)){
                return true;
            }       
        }
        return false;
    }
    
    public static Vehiculo filtrarPlaca(List<Vehiculo> vehiculos, String placa){
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getPlaca().equals(placa))
                return vehiculos.get(i);
        }
        return null;
    }
//    
    public static List<Vehiculo> filtrarVehiculos(List<Vehiculo> vehiculos, String marca, String modelo, int preMin, int preMax, double kilMin, double kilMax){
        if(kilMin < 0 || kilMax < 0 || preMin < 1 || preMax < 0){
            throw new NegativeNumberException();
        }
        List<Vehiculo> vehiculosFil = new SimpleLinkedList<>();
        for(int i = 0; i < vehiculos.size(); i++){
            Vehiculo v = vehiculos.get(i);
            if(v.marca.equals(marca) && v.modelo.equals(modelo)){
                if(kilMin <= v.kilometraje && v.kilometraje <= kilMax){
                    if(preMin <= v.precio && v.precio <= preMax)
                        vehiculosFil.addLast(vehiculos.get(i));
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