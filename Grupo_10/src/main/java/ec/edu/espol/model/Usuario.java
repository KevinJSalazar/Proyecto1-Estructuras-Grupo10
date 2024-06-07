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
    private ArrayList<Vehiculo> vehiculos;

    
    public Usuario(String nombre, String apellido, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.vehiculos = new ArrayList<>();
    }
    
    public static boolean verificarFirmaCorreo(String correo){
        List<String> firmas = new ArrayList<>();
        firmas.addLast("hotmail.com");firmas.addLast("outlook.com");firmas.addLast("outlook.es");firmas.addLast("gmail.com");
        if(correo.contains("@")){
            String[] parteCorreo = correo.split("@");
            if(parteCorreo.length >= 2 )
                for(int i = 0; i < firmas.size(); i++){
                    if(parteCorreo[1].equals(firmas.get(i)))
                        return true;
                }
        }
        return false;
    }
    
//    @Override
//    public String toString(){
//        return this.correo + "|" + this.clave;
//    }
    
    public static boolean verificarExtContraseña(String contra){
        return contra.length() >= 8 && contra.length()<20;
    }

    public static void saveListUsuariosSer(ArrayList<Usuario> usuarios){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.ser"))){
            out.writeObject(usuarios);
        } catch(IOException e){}
    }
    
    public static ArrayList<Usuario> readFileSer(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.ser"))){
            usuarios = (ArrayList<Usuario>)in.readObject();
        } catch(ClassNotFoundException | IOException c){}
        
        return usuarios;
    }
    
    public static boolean validarCorreo(ArrayList<Usuario> usuarios, String correo){
        for(Usuario u : usuarios){
            if(u.correo.equals(correo))
                return true;      
        }return false;
    }
    
    public static boolean verificarCuenta(ArrayList<Usuario> usuarios, String correo, String clave){
        for(Usuario u : usuarios){
            if(u.correo.equals(correo) && u.clave.equals(clave))
                return true;   
        } return false;
    }
    
    public static Usuario filtrarUsuario(ArrayList<Usuario> usuarios, String correo){
        for(Usuario u : usuarios){
            if(u.correo.equals(correo))
                return u;
        } return null;
    }
    
//    public List<String> getPlacas(){
//        List<String> placas = new List<>();
//        for(Vehiculo v : this.getVehiculos())
//            placas.add(v.getPlaca());
//        return placas;
//    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    @Override
    public String toString(){
        return this.correo+"|"+this.clave;
    }
}
