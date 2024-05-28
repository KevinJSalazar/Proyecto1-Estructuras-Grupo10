/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author Estudiante
 */
public class LinkedList<E> implements List<E>{
    private Nodo first;
    
    public LinkedList(){
        this.first=null;
    }
    
    public boolean isEmpty(){
        return first==null;
    }
    
    public int size(){
        int size=0;
        if(isEmpty()) return size;
        size++;
        while(first.getNext()!= null){
            size++;
        }
        return size;
    }
    
    @Override
    public boolean addFirst(E e) {
       Nodo<E> nuevo= new Nodo<>(e);
       nuevo.setNext(first);
       first=nuevo;
       return true;
    }

    @Override
    public boolean addLast(E e) {
        if(isEmpty()) addFirst(e);
        Nodo<E> ultimo=first;
        while(first.getNext()!=null){
           ultimo=ultimo.getNext();
        }
        ultimo.setNext(new Nodo(e));
        return true;
    }

    @Override
    public E removeFirst(E e) {
        E element=e;
        first=first.getNext();
        return element;
    }

    @Override
    public E removeLast(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        this.first=null;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
