/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author USUARIO
 * @param <E>
 */
public interface List<E>{
    
    public boolean addFirst(E e);
    
    public boolean addLast(E e);
    
    public E removeFirst();
    
    public E removeLast();
    
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
    
    public E get(int index);
    
    public void add(int index, E element);
    
    public E remove(int index);
    
    public E set(int index, E element);
    
    public boolean contains(E element);
}
