/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author USUARIO
 * @param <E>
 */
public class ArrayList<E> implements List<E>, Iterable<E>, Serializable{
      
    private E[]elements=null;
    private int effectiveSize;
    private int capacity=10;
    
    public ArrayList(){
        effectiveSize=0;
        elements= (E[]) new Object[capacity];
    }
    
    @Override
    public boolean addFirst(E e) {
        if(e==null) return false;
        else if(isEmpty()){
            elements[0]=e;
            effectiveSize++;
            return true;
        }else if(isFull()){
            addCapacity();
        }
        for(int i=effectiveSize-1;i >= 0;i--){
            elements[i+1]=elements[i];
        }
        elements[0]=e;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e==null) return false;
        else if(isFull()){
            addCapacity();
        }
        elements[effectiveSize]=e;
        effectiveSize++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(element==null) throw new NullPointerException();
        else if(index<0 || index>=effectiveSize) throw new IndexOutOfBoundsException();
        else if(isFull()) addCapacity();
        for(int i=effectiveSize-1;i>=index;i--){
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        effectiveSize++;
        
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(effectiveSize-1);
    }

    @Override
    public E remove(int index) {
        E eremove=null;
        if(isEmpty()|| index<0 || index>=effectiveSize){
            throw new IndexOutOfBoundsException();
        }
        for(int i=index;i<effectiveSize;i++){
            elements[i]=elements[i+1];
        }
        effectiveSize--;
        return eremove;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize==0;
    }

    @Override
    public int size() {
       return effectiveSize;
    }

    @Override
    public void clear() {
        effectiveSize=0;
        elements= (E [])new Object[capacity];
    }

    @Override
    public E get(int index) {
        if(isEmpty() || index>=effectiveSize || index<0){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        if(index<0 || index>=effectiveSize) throw new IndexOutOfBoundsException();
        E eviejo= elements[index];
        elements[index]=element;
        return eviejo;
    }
    
    private boolean isFull(){
        return effectiveSize==capacity;
    }

    
    private void addCapacity(){
        E[] newArray =(E[]) new Object[capacity*2];
        for(int i=0;i<effectiveSize;i++){
            newArray[i] = elements[i];
        }
        elements=newArray;
        capacity=capacity*2;
    }

    @Override
    public boolean contains(E element) {
        if(element!=null){
            for(int i=0;i<effectiveSize;i++){
                if(elements[i].equals(element)) return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < effectiveSize;
            }

            @Override
            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                return elements[currentIndex++];
            }       
        };
    }
    
}
 
