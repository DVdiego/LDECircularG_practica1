
package Lineales;

public class LDECG<E> implements ListaDECircular<E> {
    
    protected NodoLDEC<E> ultimo;
    
    public LDECG(){
        this.ultimo = null;
    }
    
    public NodoLDEC<E> getUltimo(){
        return ultimo;
    }

    /**
     * La función insertar nos permite insertar un elemento al principio de la
     * lista enlazada.
     * @param x 
     */
    @Override
    public void insertar(E x) {
        NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> primero = null;
        if(talla()>0) {
            primero = ultimo.siguiente;
        }
        if(talla() == 1){
            nuevo.siguiente = ultimo;
            nuevo.anterior = ultimo;
            ultimo.anterior = nuevo;
            ultimo.siguiente = nuevo;
        } else if(talla()==0){ 
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
        } else if(talla()>1){
            primero.anterior = nuevo;
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
        }
    }

    /**
     * La función insertar nos permite insertar un elemento en la lista
     * en la posición indicada.
     * @param x
     * @param i 
     */
    @Override
    public void insertar(E x, int i) { 
        
        NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> ant = null;
        NodoLDEC<E> aux = ultimo;
        
        if(i == 0) insertar(x); // insertar al principio
        
        if(i > 0&&i<talla()){ // inserción en medio
            
            for(int j=0;j<=i;j++){
                aux = aux.siguiente;
                ant = aux.anterior; 
            }
            nuevo.siguiente = aux;
            ant.siguiente = nuevo;
            nuevo.anterior = ant;
            aux.anterior = nuevo; 
        }
        
        if(i==talla()) insertarEnFin(x); //insertar al final
    }

    /**
     * La funcion insertarEnFin, nos permite insertar los elementos al final de
     * la lista.
     * @param x 
     */
    @Override
    public void insertarEnFin(E x) { 
        NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> primero = null;
        if(talla()>0) {
            primero = ultimo.siguiente;
        }
        if(talla() == 1){
            nuevo.siguiente = ultimo;
            nuevo.anterior = ultimo;
            ultimo.anterior = nuevo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        } else if(talla()==0){ 
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
        } else if(talla()>1){
            primero.anterior = nuevo;
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
    }

    /**
     * La función indiceDe, nos permite conocer la posición en la lista de cierto
     * objeto si está en la lista.
     * @param x
     * @return 
     */
    @Override
    public int indiceDe(E x) { 
        NodoLDEC<E> aux = null; 
        if(talla()>0){
            aux = ultimo.siguiente;
            int cont = 0;
            while(aux.dato!=x || aux.siguiente!=ultimo){
                aux = aux.siguiente;
                cont++;
            }
            if(aux.dato == x) return cont;
            else return -1;
        }else return -1;
    }

    /**
     * La función recuperar, nos permite obtener el elemento que se encuentre en
     * cierta posición de la lista.
     * @param i
     * @return 
     */
    @Override
    public E recuperar(int i) { 
        NodoLDEC<E> aux = null; 
        if(talla()>0){
            aux = ultimo.siguiente;
            if(i>=0&&i<talla()){
                for (int j=0; j<i; j++){
                    aux = aux.siguiente;
                }
                return aux.dato;
            } else return null;
        }else return null;
    }

    /**
     * la función vaciarLista, nos permite dejar una lista sin elementos.
     * @return 
     */
    @Override
    public boolean vaciarLista() { 
        ultimo = null;
        return true;
    }

    /**
     * La función eliminar, nos permite eliminar un elemento x de la lista.
     * @param x
     * @return 
     */
    @Override
    public boolean eliminar(E x) { 
        NodoLDEC<E> aux = null; 
        if(talla()>0){
            aux = ultimo.siguiente; 
            while(aux != ultimo && !aux.dato.equals(x)) aux = aux.siguiente;
            NodoLDEC<E> sig = aux.siguiente;
            NodoLDEC<E> ant = aux.anterior;
            if(aux==ultimo&&!aux.dato.equals(x)) return false;
            else{
                if(aux.dato.equals(x)){// borrar cualquier posición
                    ant.siguiente = sig;
                    sig.anterior = ant;
                    if(aux==ultimo) ultimo = ant; //si el borrado era el ultimo se reasigna
                } 
            return true;
            }
        }else return false;
    }

    /**
     * La función eliminar nos permite eliminar el elemento que esté en la
     * posición indicada de la lista.
     * @param i
     * @return 
     */
    @Override
    public boolean eliminar(int i) { 
        NodoLDEC<E> aux = null;
        NodoLDEC<E> sig = null;
        NodoLDEC<E> ant = null;
        if(talla()>0){
            aux = ultimo.siguiente;
            sig = aux.siguiente;
            ant = aux.anterior;
        }
        
        boolean bandera = false; 
        if(talla()==0) return bandera; //si la lista está vacia
        if(talla()==1){
            ultimo = null;
            bandera = true;
        }else if (talla()>1&&i<talla()){    
            if(i==0){ //borrado al principio
                ant.siguiente = sig;
                sig.anterior = ant;
                bandera = true;
            }
            if(i < talla()-1 && i>0){ // borrado en medio 
                for(int j = 1;j<=i;j++){
                    aux = aux.siguiente;
                    ant = aux.anterior;
                    sig = aux.siguiente;
                }
                ant.siguiente = sig;
                sig.anterior = ant;
                bandera = true;
            }
            if(i == talla()-1){  //borrado al final 
                while(aux!=ultimo){
                    aux = aux.siguiente;
                    ant = aux.anterior;
                    sig = aux.siguiente;
                }
                ant.siguiente = sig;
                sig.anterior = ant;
                ultimo = ant;
                bandera = true;
            }
        }
        return bandera;
    }

    /**
     * La función esVacia, nos permite conocer si la lista tiene o no algún 
     * elemento.
     * @return 
     */
    @Override
    public boolean esVacia() {
        if(ultimo == null) return true;
        else return false;
    }

    /**
     * La funcion contiene, nos permite conocer si en la lista se encuentra el
     * elemento x.
     * @param x
     * @return 
     */
    @Override
    public boolean contiene(E x) { 
        NodoLDEC<E> aux = null;
        if(talla()>0){
            aux = ultimo.siguiente;
            while(aux!=ultimo||!x.equals(aux.dato)){
                aux = aux.siguiente;
            }
        }
        if(x.equals(aux.dato)) return true;
        else return false;
    }

    /**
     * La función talla, nos permite saber el numero de nodos que hay en una
     * lista.
     * @return 
     */
    @Override
    public int talla() { 
        NodoLDEC<E> aux = ultimo;
        int cont = 0;
        if(!esVacia()){
            cont++;
            while(aux.siguiente!=ultimo){
                aux = aux.siguiente;
                cont++;
            }
        }
        return cont; 
    }

    /**
     * La funcion toArray, nos permite convertir la lista en un array.
     * @return 
     */
    @Override
    public E[] toArray() { 
        NodoLDEC<E> aux = null;
        if(talla()>0){
            aux = ultimo.siguiente;
        }
        E a[] = null;
        int cont = 0;
        while(aux!=ultimo&&aux!=null){
            a[cont] = aux.dato;
            aux = aux.siguiente;
            cont++;
        }
        return a;
    }
      
    /**
     * La funcion toString es el metodo lanzadera de toString recursivo, nos
     * permite transformar la lista en un String.
     * @return
     * @see toString(NodoLDE<E> n,String s, int i)
     */
    public String toString(){
          if(talla()>0) return toString(ultimo.siguiente, "", talla());
          else return "";
    }
    
    /**
     * La funcion toString nos permite de forma recursiva obtener la lista en 
     * forma de String.
     * @param n
     * @param s
     * @param i
     * @return 
     */
    public String toString(NodoLDEC<E> n,String s, int i){
         NodoLDEC<E> aux = n;  
         if(i>0){            
             s = aux.dato.toString()+" "+s;
             aux = aux.siguiente;           
             return toString(aux,s,i-1);
         }
         else    return s;
      }
    
    public String toStringRev(){
          if(talla()>0) return toStringRev(ultimo.siguiente,"",talla());
          else return "";
      }
    
    /**
     * la función toStringRev, nos permite obtener de forma recursiva la lista 
     * en forma de String de forma invertida.
     * @param n
     * @param s
     * @param i
     * @return 
     */
     public String toStringRev(NodoLDEC<E> n,String s, int i){
         NodoLDEC<E> aux = n;  
         if(i>0){            
             s = s+aux.dato.toString()+" ";           
             aux = aux.siguiente;           
             return toStringRev(aux,s,i-1);
         }
         else    return s;
      }
    
    public int contadorNodos(NodoLDEC<E> x, int i){ 
        int cont = i; 
        if(x.siguiente != ultimo){
            NodoLDEC<E> aux = x;
            aux = aux.siguiente;
            return cont+contadorNodos(aux,cont);
        }else return i;
    }
    
    
    /**
     * la función invertir lista, nos permite obrener de forma invertida la 
     * lista de forma recursiva.
     * Para ello, en la fase de desplegado llegamos al final de la lista, y a 
     * este ultimo nodo le referenciamos como el primero, y en la fase de 
     * replegado, damos la vuelta a las referencias anterior y siguiente para 
     * así tener la lista invertida.
     * @param n
     * @param aux 
     */
    public void invertirLista(){
        if(ultimo.siguiente!=null){
            invertirLista(ultimo.siguiente, ultimo.siguiente.siguiente);
        }
    }
    
    
    /**
     * la función invertir lista, nos permite obrener de forma invertida la 
     * lista de forma recursiva.
     * Para ello, en la fase de desplegado llegamos al final de la lista, y al 
     * siguiente, osea el primero, le referenciamos como el último, y en la fase
     * de replegado, damos la vuelta a las referencias anterior y siguiente para 
     * así tener la lista invertida.
     * @param n
     * @param aux 
     */
    protected void invertirLista(NodoLDEC<E> n, NodoLDEC<E> aux){ //no acabada
        if(aux!=ultimo.siguiente){ 
            invertirLista(aux, aux.siguiente);
        } else ultimo = n.siguiente;
        n.siguiente = n.anterior;
        n.anterior = aux;
    }
    
    /**
     * Esta función es la misma función anterior, implementada de otra forma, 
     * sin tener en cuenta el unico recorrido debido a los metodos.
     * Nos permite obtener de forma invertida la
     * lista de forma recursiva.
     * Para ello, en la fase de desplegado vamos guardando una copia del primer
     * nodo en una variable que llevamos al stack, y eliminamos este nodo de la
     * lista, hasta alcanzar el caso base(lista vacia), y comienza la fase de 
     * replegado donde añadimos los elementos del stack al final de la lista.
     * @param cont 
     */ 
    public void invertirLista(int cont){ 
        if(talla()>0){
            E guarda = recuperar(cont);
            eliminar(cont);
            invertirLista(cont);
            insertarEnFin(guarda);
        }
    }
    
    /**
     * la función duplicarNodosPares, nos permite duplicar los nodos que 
     * contengan elementos pares de forma recursiva.
     * Para ello seguimos la estrategia de invertirLista, pero en la fase de 
     * replegado, comparamos si el nodo es par, y si lo es lo insertamos dos
     * veces.
     * @see invertirLista(int cont)
     */
    public void duplicarNodosPares(){ 
        int cont = 0;
        if(talla()>0){
            E guarda = recuperar(cont);
            eliminar(cont);
            duplicarNodosPares();
            try{ 
                if(Integer.parseInt(guarda.toString())%2==0) insertar(guarda);
            }catch(Exception e){
             System.out.println("->Un elemento no se pudo tratar como entero.");
            }
            insertar(guarda);
        }
    }
    
    /**
     * el metodo premiar claves multiplica por 2 los datos de los elementos cuyo
     * dato coincida con la talla. Esto lo hace de forma recursiva siguiendo la
     * estrategia de invertirLista, pero en la fase de replegado, comparamos si
     * el dato del nodo es igual a la talla, y de ser así, lo multiplicamos por 
     * 2 antes de ser insertado.
     * @see invertirLista(int cont)
     * @param x 
     */
    public void premiarClaves(int x){ 
        int cont = 0;
        if(talla()>0){
            E guarda = recuperar(cont);
            eliminar(cont);
            premiarClaves(x);
            try{
                if(Integer.parseInt(guarda.toString())==x){
                    Integer i = (Integer.parseInt(guarda.toString()))*2;           
                    guarda = (E) i;   
                }   
            }catch(Exception e){
             System.out.println("->Un elemento no se pudo tratar como entero.");
            }
            insertar(guarda);
        }
    }
    
}
