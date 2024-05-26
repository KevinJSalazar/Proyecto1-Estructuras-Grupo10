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

/**
 *
 * @author evin
 */
public class Usuario implements Serializable{
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    
    public Usuario(String nombre, String apellido, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }
    
    public static boolean verificarCorreo(String correo){
        if(correo.contains("@")){
            String[] parteCorreo = correo.split("@");
            if(parteCorreo[1].equals("hotmail.com") || parteCorreo[1].equals("outlook.com"))
                return true;
            else if(parteCorreo[1].equals("outlook.es") || parteCorreo[1].equals("gmail.com"))
                return true;
            return false;
        } else{
            return false;
        } 
    }
    
    public static boolean verificarExtContraseña(String contra){
        return contra.length() >= 8 && contra.length()<20;
    }
    
//    private List<Vehiculo> vehiculos;

//    public Usuario(String nombres, String apellidos, String correo, String clave, ArrayList<Vehiculo> vehiculos) {
//        this.nombres = nombres;
//        this.apellidos = apellidos;
//        this.correo = correo;
//        this.clave = clave;
//        this.vehiculos = vehiculos;
//    }
//    
//    @Override
//    public String toString(){
//        return this.correo + "|" + this.clave;
//    }
//    
    public static void saveListUsuariosSer(ArrayList<Usuario> usuarios){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.ser"))){
            out.writeObject(usuarios);
        } catch(IOException e){}
    }
//    
    public static List<Usuario> readFileSer(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.ser"))){
            usuarios = (List<Usuario>)in.readObject();
        } catch(ClassNotFoundException c){
        } catch(IOException e){}
        return usuarios;
    }
//    
//    public static boolean checkCorreo(List<Usuario> usuarios, String correo){
//        for(Usuario u : usuarios){
//            if(u.correo.equals(correo)){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public static boolean checkCuenta(List<Usuario> usuarios, String correo, String clave){
//        for(Usuario u : usuarios){
//            if(u.correo.equals(correo) && u.clave.equals(clave)){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public static Usuario filtrarCorreo(List<Usuario> usuarios, String correo){
//        for(Usuario u : usuarios){
//            if(u.correo.equals(correo))
//                return u;
//        }
//        return null;
//    }
//    
//    public List<String> getPlacas(){
//        List<String> placas = new List<>();
//        for(Vehiculo v : this.getVehiculos())
//            placas.add(v.getPlaca());
//        return placas;
//    }
//
//    public String getNombres() {
//        return nombres;
//    }
//
//    public void setNombres(String nombres) {
//        this.nombres = nombres;
//    }
//
//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }
//
//    public String getCorreo() {
//        return correo;
//    }
//
//    public void setCorreo(String correo) {
//        this.correo = correo;
//    }
//
//    public String getClave() {
//        return clave;
//    }
//
//    public void setClave(String clave) {
//        this.clave = clave;
//    }
//
//    public List<Vehiculo> getVehiculos() {
//        return vehiculos;
//    }
//
//    public void setVehiculos(List<Vehiculo> vehiculos) {
//        this.vehiculos = vehiculos;
//    }


}
