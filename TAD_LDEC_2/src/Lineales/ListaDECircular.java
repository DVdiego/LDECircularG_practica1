/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lineales;

/**
 *
 * @author Diegojim
 */
public interface ListaDECircular<E> {
    
    public abstract void insertar(E x);
    
    public abstract void insertar(E x, int i);
    
    public abstract void insertarEnFin(E x);
    
    public abstract int indiceDe(E x); //cambiado a E
    
    public abstract E recuperar(int i);
    
    public abstract boolean vaciarLista();
    
    public abstract boolean eliminar(E x); //cambiado a E
    
    public abstract boolean eliminar(int i);
    
    public abstract boolean esVacia();
    
    public abstract boolean contiene(E x);
    
    public abstract int talla();
    
    public abstract E[] toArray();
    
    public abstract String toString();
    
    
}
