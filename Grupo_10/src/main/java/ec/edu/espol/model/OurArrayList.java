/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author USUARIO
 */
public class OurArrayList<E> implements List<E>{
    
    private int capacity=10;
    private E[]elements=null;
    private int effectiveSize=0;
    
    @Override
    public boolean addFirst(E e){
        if(e==null) return false;
        else if(isEmpty()){
            elements[effectiveSize]=e;
            effectiveSize+=1;
            return true;
        }else if(isFull()){
            addCapacity();
        }
        add(0,e);
        return true;
    }
    
    @Override
    public boolean addLast(E e){
        if(e==null) return false;
        else if(isEmpty()){
            elements[effectiveSize]=e;
            effectiveSize+=1;
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
    }
    
    @Override
    public void add(int index, E element){
        if(element==null) throw new NullPointerException();
        else if(verifyRange(index))throw new IndexOutOfBoundsException();
        else if(this.isEmpty()){
            elements[effectiveSize]=element;
            effectiveSize+=1;
        }else if(this.isFull()){
            this.addCapacity();
        }
        for(int i=effectiveSize;i>=index;i--){
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        effectiveSize++;
    }
    
    @Override
    public E remove(int index){
        E eRemove=null;
        if(this.isEmpty() || index>effectiveSize || index<0){
            throw new IndexOutOfBoundsException();
        }else{
            eRemove=elements[index];
            for(int i=index;i<this.effectiveSize-1;i++){
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
        if(verifyRange(index)){
            throw new IndexOutOfBoundsException();
        }else{
            E eViejo=elements[index];
            elements[index]=element;
            return eViejo;
        }
    }
    
    private boolean verifyRange(int index){
        return index<0 || index>=effectiveSize;
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

}
