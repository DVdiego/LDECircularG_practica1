
package Lineales;

public class NodoLDEC<E> {
    
    protected NodoLDEC<E> siguiente;
    protected NodoLDEC<E> anterior;
    protected E dato;
    
    NodoLDEC(E dato){
        this(dato, null, null);
    }
    
    NodoLDEC(E dato, NodoLDEC<E> sig, NodoLDEC<E> ant){
        this.dato = dato;
        this.siguiente = sig;
        this.anterior = ant;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
    
    
    
    
}
