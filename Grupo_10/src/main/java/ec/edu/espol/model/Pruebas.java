/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author Estudiante
 */
public class Pruebas {
    
    public static void main(String [] args){
        ArrayList<String> propioArray = new ArrayList<>();
        propioArray.add(0, "Hola");
        propioArray.addLast("Mundo");
        System.out.println(propioArray.size());
        propioArray.addFirst("nothing");
    }
}
