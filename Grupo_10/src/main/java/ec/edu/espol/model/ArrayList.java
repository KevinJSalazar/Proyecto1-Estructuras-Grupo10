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
    private int capacity=10;
    private int effectiveSize;
    
    public ArrayList(){
        elements=(E[]) new Object[10];
        effectiveSize=0;
    }
    
    @Override
    public boolean addFirst(E e){
        if(e==null) return false;
        else if(isEmpty()){
            elements[0]=e;
            effectiveSize++;
            return true;
        }
        else if(isFull()){
            addCapacity();
        }
        for(int i=effectiveSize-1;i>=0;i--){
            elements[i+1]=elements[i];
        }
        elements[0]=e;
        effectiveSize++;
        return true;
    }
    
    @Override
    public boolean addLast(E e){
       if(e==null) return false;
        else if(isEmpty()){
            elements[0]=e;
            effectiveSize++; 
            return true;
        }else if(isFull()){
            addCapacity();
        }
        elements[effectiveSize]=e;
        effectiveSize++;
        return true;
    }
    
    @Override
    public E removeFirst(E e){
        return remove(0);
    }
    
    @Override
    public E removeLast(E e){
        return remove(this.effectiveSize-1);
    }
    @Override
    public int size(){
        return effectiveSize;
    }
    @Override
    public boolean isEmpty(){
        return effectiveSize==0;
    }
    
    @Override
    public void clear(){
            effectiveSize=0;
            elements=(E []) new Object[capacity];
    }
    
    @Override
    public void add(int index, E element){
        if(element==null) throw new NullPointerException();
        else if(index<0 || index>effectiveSize) throw new IndexOutOfBoundsException();
        else if(isFull()) addCapacity();
        for(int i=effectiveSize;i>index;i--){
            elements[i]=elements[i-1];
        }
        elements[index]=element;
        effectiveSize++;
    }
    
    @Override
    public E remove(int index){
        E eRemove=null;
        if(index<0 || index>=effectiveSize){
            throw new IndexOutOfBoundsException();
        }else{
            eRemove=elements[index];
            for(int i=index;index<this.effectiveSize;i++){
                elements[i]=elements[i+1];
            }
            effectiveSize--;
        }
        return eRemove;
    }
    
    @Override
    public E get(int index){
        if(!this.isEmpty() && index<effectiveSize){
            return elements[index];
        }
        return null;
    }
    
    @Override
    public E set(int index, E element){
        if(index < 0 || index >= effectiveSize){
            throw new IndexOutOfBoundsException();
        }else{
            E eViejo=elements[index];
            elements[index]=element;
            return eViejo;
        }
    }
    
    private void addCapacity(){
        E[] nuevo=(E[]) new Object[capacity*2];
        for(int i=0;i<elements.length;i++){
            nuevo[i]=elements[i];
        }
        elements= nuevo;
        capacity*=2;
    }
    
    private boolean isFull(){
        return effectiveSize==capacity;
    }

    @Override
    public boolean contains(E element) {
        for(int i = 0; i < this.effectiveSize; i++){
            if(this.elements[i].equals(element))
                return true;
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
