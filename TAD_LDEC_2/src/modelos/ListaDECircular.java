
package modelos;

/**
     * Interfaz del TAD, con todos los metodos básicos a implementar. 
     */
public interface ListaDECircular<E> {
    
    public abstract void insertar(E x);
    
    public abstract void insertar(E x, int i);
    
    public abstract void insertarEnFin(E x);
    
    public abstract int indiceDe(E x); 
    
    public abstract E recuperar(int i);
    
    public abstract boolean vaciarLista();
    
    public abstract boolean eliminar(E x); 
    
    public abstract boolean eliminar(int i);
    
    public abstract boolean esVacia();
    
    public abstract boolean contiene(E x);
    
    public abstract int talla();
    
    public abstract E[] toArray();
    
    public abstract String toString();
    
    
}
