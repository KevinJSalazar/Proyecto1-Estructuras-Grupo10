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
import java.util.List;

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

//    public Vehiculo(String placa, String marca, String modelo, int precio, double kilometraje, Usuario usuario) {
//        this.placa = placa;
//        this.marca = marca;
//        this.modelo = modelo;
//        this.precio = precio;
//        this.kilometraje = kilometraje;
//        this.usuario = usuario;
//    }
//
//    public String getPlaca() {
//        return placa;
//    }
//    
//    public static void saveListVehiculosSer(List<Vehiculo> vehiculos){
//        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vehiculos.ser"))){
//            out.writeObject(vehiculos);
//        } catch(IOException e){}
//    }
//    
//    public static List<Vehiculo> readFileSer(){
//        List<Vehiculo> vehiculos = new List<>();
//        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("vehiculos.ser"))){
//            vehiculos = (List<Vehiculo>)in.readObject();
//        } catch(ClassNotFoundException c){
//        } catch(IOException e){}
//        return vehiculos;
//    }
//    
//    public static boolean checkPlaca(List<Vehiculo> vehiculos, String placa){
//        for(Vehiculo v : vehiculos){
//            if(v.placa.equals(placa)){
//                return true;
//            }       
//        }
//        return false;
//    }
//    
//    public static Vehiculo filtrarPlaca(List<Vehiculo> vehiculos, String placa){
//        for(Vehiculo v : vehiculos){
//            if(v.getPlaca().equals(placa))
//                return v;
//        }
//        return null;
//    }
//    
//    public static List<Vehiculo> filtrarVehiculos(List<Vehiculo> vehiculos, String marca, String modelo, int preMin, int preMax, double kilMin, double kilMax){
//        if(kilMin < 0 || kilMax < 0 || preMin < 1 || preMax < 0){
//            throw new NegativeNumberException();
//        }
//        else{
//            List<Vehiculo> vehiculosFil = new List<>();
//            String tipoVeh;
//            for(Vehiculo v : vehiculos){
//                if(kilMin <= v.kilometraje && v.kilometraje <= kilMax){
//                    if(preMin <= v.precio && v.precio <= preMax)
//                        vehiculosFil.add(v);
//                }
//            }
//        }
//        return vehiculosFil;
//    }
//
//    public void setPlaca(String placa) {
//        this.placa = placa;
//    }
//
//    public String getMarca() {
//        return marca;
//    }
//
//    public void setMarca(String marca) {
//        this.marca = marca;
//    }
//
//    public String getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(String modelo) {
//        this.modelo = modelo;
//    }
//
//    public int getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(int precio) {
//        this.precio = precio;
//    }
//
//    public int getAño() {
//        return año;
//    }
//
//    public void setAño(int año) {
//        this.año = año;
//    }
//
//    public double getKilometraje() {
//        return kilometraje;
//    }
//
//    public void setKilometraje(double kilometraje) {
//        this.kilometraje = kilometraje;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
}