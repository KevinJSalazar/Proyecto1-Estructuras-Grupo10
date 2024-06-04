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
 */
public class SimpleLinkedList<E> implements List<E>, Iterable<E>, Serializable{
    
    private Nodo<E> first;
    private Nodo<E> last;
    
    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
    }
    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        Nodo<E> nuevo = new Nodo<>(e);
        nuevo.setNext(this.getFirst());
        if (this.isEmpty()) {
            this.setLast(nuevo);
        }
        this.setFirst(nuevo);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        Nodo<E> nuevo = new Nodo<>(e);
        if (this.isEmpty()) {
            this.setFirst(nuevo);
        } else {
            this.getLast().setNext(nuevo);
        }

        this.setLast(nuevo);

        return true;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            if (size() == 1) {
                last = null;
            }
            Nodo<E> node = first;
            first = first.getNext();
            node.setNext(null);
            return node.getContent();
        }
        return null;
    }

    @Override
    public E removeLast() {
       if (!isEmpty()) {
            Nodo<E> deleted = last;
            if (first == last) {
                return removeFirst();
            }
            if (first.getNext() == last) {

                last = first;
                first.setNext(null);
                return deleted.getContent();
            }
            Nodo<E> n;
            for (n = first; n.getNext().getNext() != last; n = n.getNext()) {
            }
            last = n.getNext();
            n.getNext().setNext(null);
            return deleted.getContent();
        }
        return null;
    }

    @Override
    public int size() {
        int cont = 0;
        if (!isEmpty()) {
            Nodo<E> t;
            for (t = this.getFirst(); t != null; t = t.getNext()) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    @Override
    public void clear() {
         while (!isEmpty()) {
            removeFirst();
        }
    }

    @Override
    public E get(int index) {
        int size = size();
        if (index >= 0 && index < size) {
            Nodo<E> n = first;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
            return n.getContent();
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
          int size = size();
        if (element != null && index >= 0 && index <= size) {
            if (index == 0) {
                addFirst(element);
            } else if (index == size) {
                addLast(element);
            } else {
                Nodo<E> n = first;
                for (int i = 0; i < index - 1; i++) {
                    n = n.getNext();
                }
                Nodo<E> newNode = new Nodo(element);
                newNode.setNext(n.getNext());
                n.setNext(newNode);
            }
        }
    }

    @Override
    public E remove(int index) {
        int size = size();
        if (index >= 0 && index < size) {
            if (index == 0) {
                return removeFirst();
            } else if (index == size - 1) {
                return removeLast();
            } else {
                Nodo<E> n = first;

                for (int i = 0; i < index - 1; i++) {
                    n = n.getNext();
                }
                Nodo<E> deleted = n.getNext();
                n.setNext(n.getNext().getNext());
                deleted.setNext(null);
                return deleted.getContent();
            }
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        int size = size();
        if (index >= 0 && index < size) {
            Nodo<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            E old = node.getContent();
            node.setContent(element);
            return old;
        }
        return null;
    }

    public Nodo<E> getFirst() {
        return first;
    }

    public void setFirst(Nodo<E> first) {
        this.first = first;
    }

    public Nodo<E> getLast() {
        return last;
    }

    public void setLast(Nodo<E> last) {
        this.last = last;
    }
    
    public Iterator<E> iterator() {
        Iterator<E>it=new Iterator(){
            Nodo<E>cursor=first;
            @Override
            public boolean hasNext() {
                return cursor!=null;
            }

            @Override
            public E next() {
                E content = cursor.getContent();
                cursor=cursor.getNext();
                return content;
            }
            
        };
        return it;
    }

    
    
    @Override
    public boolean contains(E element) {
        if(element!=null){
            for(int i=0;i<this.size();i++){
                if(this.get(i)==element) return true;
            }
        }
        return false;
    }
    
}
