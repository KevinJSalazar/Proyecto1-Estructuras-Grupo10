/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import static ec.edu.espol.model.Vehiculo.filtrarVehiculos;

/**
 *
 * @author Estudiante
 */
public class Pruebas {
    
    public static void main(String [] args){
//        ArrayList<String> propioArray = new ArrayList<>();
//        propioArray.add(0, "Hola");
//        propioArray.addLast("Mundo");
//        System.out.println(propioArray.size());
//        propioArray.addFirst("nothing");
        
        List<Vehiculo> vehiculos = new SimpleLinkedList<>();

        // Agregar algunos vehículos a la lista
//        vehiculos.addLast(new Vehiculo("AAA111", "Toyota", "Corolla", 20000, 15000.5));
//        vehiculos.addLast(new Vehiculo("BBB222", "Toyota", "Camry", 25000, 12000.0));
//        vehiculos.addLast(new Vehiculo("CCC333", "Honda", "Civic", 18000, 20000.0));
//        vehiculos.addLast(new Vehiculo("DDD444", "Honda", "Accord", 27000, 10000.0));
//        vehiculos.addLast(new Vehiculo("EEE555", "Ford", "Fiesta", 15000, 30000.0));

        // Filtrar los vehículos
        List<Vehiculo> vehiculosFiltrados = filtrarVehiculos(vehiculos, "Toyota", "Corolla", 15000, 30000, 10000, 20000);

        // Imprimir los vehículos filtrados
        for (int i = 0; i < vehiculosFiltrados.size(); i++) {
            System.out.println(vehiculosFiltrados.get(i));
        }
    }
}
