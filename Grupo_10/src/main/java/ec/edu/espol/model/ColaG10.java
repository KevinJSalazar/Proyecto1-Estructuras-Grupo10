/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author evin
 */
public class ColaG10<E> {
    
    private SimpleLinkedList<E> lista;
    
    public ColaG10() {
        lista = new SimpleLinkedList<>();
    }

    public void offer(E elemento) {
        lista.addLast(elemento);
    }

    public E poll() {
        return lista.removeFirst();
    }

    public E peek() {
        return lista.get(lista.size()-1);
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public int tamano() {
        return lista.size();
    }

    public void roundRobin(int n) {
        for (int i = 0; i < n; i++) {
            E elemento = poll();
            System.out.println(elemento.toString());
            offer(elemento);
        }
    }
}
