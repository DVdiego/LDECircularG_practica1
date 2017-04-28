
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
     * @param x Es el dato de tipo E a almacenar en el nodo.
     */
    @Override
    public void insertar(E x) {
        NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> primero = ultimo.siguiente;
        System.out.println(nuevo.dato.toString());
        if(primero != null){
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        } else primero = nuevo;
    }
    
    
    /**
     * La función insertar nos permite insertar un elemento en la lista
     * en la posición indicada.
     * @param x Es el dato de tipo E a almacenar en el nodo.
     * @param i Es el indice de la lista donde se quiere insertar el nodo.
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
     * @param x Es el dato de tipo E a almacenar en el nodo.
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
     * @param x es el dato de tipo E que almacena el nodo en cuestión.
     * @return cont qie es el indice del dato si es encontrado, si no se
     * encuentra retorna -1
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
     * @param i indice del valor del nodo a recuperar.
     * @return E que es el dato de tipo E que almacena el nodo.
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
     * @return boolean
     */
    @Override
    public boolean vaciarLista() { 
        ultimo = null;
        return true;
    }
    
    
    /**
     * La función eliminar, nos permite eliminar un elemento x de la lista.
     * @param x es el dato de tipo E que almacena cada nodo.
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
     * @param i es el indice correspondiente al nodo dentro de la lista.
     * @return boolean
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
     * @return boolean true o false segun el caso.
     */
    @Override
    public boolean esVacia() {
        if(ultimo == null) return true;
        else return false;
    }

  
    
    /**
     * La funcion contiene, nos permite conocer si en la lista se encuentra el
     * elemento x devolviendo true o false segun el caso.
     * @param x que es el dato de tipo E que almacena cada nodo.
     * @return booleano
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
     * @return cont que es valor de la talla de la lista.
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
     * @return a array con los elementos de la lista.
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
     * @return un String de la lista.
     * @see #toString(Lineales.NodoLDE, java.lang.String) 
     */
    @Override  
    public String toString(){
        return toString(ultimo.siguiente,"");   
    }
    
    /**
     * La funcion toString nos permite de forma recursiva obtener la lista en 
     * forma de String.
     * @param n Contiene al nodo correspondiente de la lista en cada llamada
     * recursiva empezando por el nodo primero y terminando con null una vez se
     * llege al caso base
     * @param s Cadena que almacena los valores contenidos en cada nodo, estos
     * valores los va concatenando al inicio de la cadenea durante la fase 
     * de desplegado.
     * @return s Una vez se llegue al caso base retorna la cadena que contiene
     * todos los valores de los nodos.
     */
    public String toString(NodoLDEC<E> n,String s){
         
        if(n!=ultimo){                             
           return toString(n.siguiente,n.dato.toString()+" "+s);
        }
        else    return s;
    }
    
    
     
    /**
     * La funcion toStringRev nos permite de forma recursiva obtener la lista 
     * al revés es decir del ultimo al primer nodo como una cadena.
     * @param n Contiene al nodo correspondiente de la lista en cada llamada
     * recusiva empezando por el nodo primero y terminando con null una vez se
     * llege al caso base
     * @param s Cadena que almacena los valores contenidos en cada nodo, estos
     * valores los va concatenando al final de la cadena durante la fase 
     * de desplegado.
     * @return s Una vez se llegue al caso base retorna la cadena que contiene
     * todos los valores de los nodos.
     */
    protected String toStringRev(NodoLDEC<E> n,String s){

       if(n!=ultimo){                      
          return toStringRev(n.siguiente,s+n.dato.toString()+" ");
       }
       else    return s;
    }
    
    
    /**
     * La funcion toStringRev es el metodo lanzadera de toStringRev recursivo,
     * nos permite transformar la lista en un String pero con los valores de los
     * nodos al revés.
     * @return un String de la lista al réves.
     * @see #toString(Lineales.NodoLDE, java.lang.String) 
     */    
    public String toStringRev(){ 
        return toStringRev(ultimo.siguiente,"");
    }
     
    
     
    
    /**
     * La función contar nodos, nos permite obtener recursivamente la talla 
     * de la lista.
     * @param n Contiene el nodo correspondiente de la lista en cada llamada
     * recusiva empezando por el nodo primero y terminando con null una vez se
     * llege al caso base.
     * @param i Se usa como contador, sumando +1 en la fase de desplegado.
     * @return i Cuando se llega al caso base se retorna i que es la talla.
     */
    protected int contadorNodos(NodoLDEC<E> x, int i){ 
        if(x != ultimo){          
            return contadorNodos(x.siguiente,i+1);           
        }else return i;
    }
    
    
    /**
     * La funcion contadorNodos es un metodo lanzadera de contadorNodos 
     * recursivo, nos permite obtener la talla de la lista.
     * @return un String de la lista al réves.
     * @see #contadorNodos(Lineales.NodoLDE, int) 
     */
    public int contadorNodos(){   
        
        return contadorNodos(ultimo.siguiente, 0);
    }
     
    
    


    
    /**
     * La función invertir lista, nos permite obrener de forma invertida la 
     * lista de forma recursiva.
     * Para ello, en la fase de desplegado llegamos al final de la lista, y a 
     * este ultimo nodo le referenciamos como el primero, y en la fase de 
     * replegado, damos la vuelta a las referencias anterior y siguiente para 
     * así tener la lista invertida.
     * @param n Contiene el nodo correspondiente de la lista en cada llamada
     * recursiva empezando por el nodo primero y terminando con el nodo anterior
     * a null una vez se alcance el caso base.
     * @param aux Contiene el nodo correspondiente de la lista en cada llamada
     * recursiva empezando por el nodo siguiente al primero y terminando con null 
     * una vez se llege al caso base.
     */
    protected void invertirLista(NodoLDEC<E> n, NodoLDEC<E> aux){
        if(aux!=ultimo){      
            invertirLista(aux, aux.siguiente);
        } else ultimo.siguiente = n;
        n.siguiente = n.anterior;
        n.anterior = aux;
    }
    
    
    
    /**
     * La funcion inverirLista es un metodo lanzadera de inverirLista()
     * recursivo, nos permite invertir el orden de los nodos de la lista.
     * @see #invertirLista(Lineales.NodoLDE, Lineales.NodoLDE) 
     */
    public void invertirLista(){
        
            invertirLista(ultimo.siguiente, ultimo.siguiente.siguiente);
        
    }

    
    
     /**
     * Esta función es la misma función anterior, implementada de otra forma, 
     * sin tener en cuenta el unico recorrido debido a los metodos.
     * Nos permite obtener de forma invertida la lista de forma recursiva.
     * Para ello, en la fase de desplegado vamos guardando una copia del primer
     * nodo en una variable que llevamos al stack, y eliminamos este nodo de la
     * lista, hasta alcanzar el caso base(lista vacia), y comienza la fase de 
     * replegado donde añadimos los elementos del stack al final de la lista.
     * @param cont 
     */ 
            /*protected void invertirLista(NodoLDE<E> n){
                if(n!=null){      
                    insertar(n.dato);
                    invertirLista(n.siguiente);  
                    eliminar(n.dato);
                }
            }*/
    
    
    /**
     * La función duplicarNodosPares, nos permite duplicar los nodos que 
     * contengan elementos pares de forma recursiva.
     * La fúncion se llama recursivamente, realizando la fase de desplegado
     * hasta que llegue al caso base, este es cuando se ah recorrido toda la 
     * lista hasta llegar a null.
     * En la fase de replegado, compara si el dato del nodo es par, en caso de 
     * que lo sea se duplica el nodo par y se inserta el duplicado entre el
     * nodo par y el nodo siguiente al nodo par modificando las referencias 
     * de los nodos implicados de forma oportuna.
     * @param n, Contiene el nodo correspondiente de la lista en cada llamada
     * recursiva empezando por el nodo primero y terminando con null una vez se
     * llege al caso base.
     */
    public void duplicarNodosPares(NodoLDEC<E> n){
        
        if(n!=ultimo){
           duplicarNodosPares(n.siguiente); 
           try{ 
             
                if(Integer.parseInt(n.dato.toString())%2==0) {
                    System.out.println("dato: "+n.dato);
                    NodoLDEC<E> nuevo = new NodoLDEC<E>(n.dato);
                    nuevo.siguiente = n.siguiente;
                    nuevo.anterior = n;
                    n.siguiente.anterior = nuevo;
                    n.siguiente = nuevo;       
                }
 
            }catch(Exception e){
             System.out.println("->Un elemento no se pudo tratar como entero.");
            }
        }       
       
    } 
    
    
    
    /**
     * La función duplicarNodosPares es metodo lanzadera de duplicarNodosPares
     * recursivo, nos permite duplicar los nodos pares de la lista.
     * @see #duplicarNodosPares(Lineales.NodoLDE) 
     */
    public void duplicarNodosPares(){
        duplicarNodosPares(ultimo.siguiente);
    }

    
    /**
     * La función premiar claves duplica el valor del dato que contienen los 
     * nodos cuyo dato almacenado coincida con la talla. 
     * Para ello se llama a si misma recursivamente hasta llegar al caso base 
     * que es cuando llega a null una vez se haya recorrido toda la lista. 
     * En cada llamada recursiva durante la fase de desplegado el parametro n 
     * va tomando el valor de cada uno de los nodos de la lista y el
     * parametro c se usa como contador sumando +1 en cada llamada.  
     * Cuando se llegue al caso base se retorna el valor de c. 
     * En la fase de replegado usamos c ,este valor determina 
     * la talla de la lista y lo comparamos con el dato que almacena cada nodo, 
     * en caso de ser iguales, multiplicamos por 2 el valor actual del nodo,
     * lo sustituimos por este nuevo valor y se vuelve a retornar c de tal forma
     * que conservamos la talla de la lista para seguir comparandolo con cada 
     * nodo hasta terminar la fase de replegado.
     * @param n Contiene el nodo correspondiente de la lista en cada llamada
     * recursiva empezando por el nodo primero y terminando con null una vez se
     * llege al caso base.
     * @param c Se usa como contador durante la fase de desplegado.
     * @return c Es el valor del contador que usamos como talla.
     */
    protected int premiarClaves(NodoLDEC<E> n, int c){ 
        
        if(n!=ultimo){  
            c = premiarClaves(n.siguiente,c+1 );
            System.out.println(c);
                try{
                if(Integer.parseInt(n.getDato().toString())==c){
                    Integer i = (Integer.parseInt(n.getDato().toString()))*2;           
                    n.setDato((E)i);  
                }   
            }catch(Exception e){
             System.out.println("->Un elemento no se pudo tratar como entero.");
            }
                return c;
        }else  return c;
             
    }
    
    
    /**
     * La función premiarClaves es metodo lanzadera de premiarClaves
     * recursivo, nos permite duplicar el valor del contenido almacenado en 
     * los nodos de la lista que coincidan con  la talla.
     * @see #premiarClaves(Lineales.NodoLDE, int)  
     */
    public void premiarClaves(){
        premiarClaves(ultimo.siguiente,0);
    }
    
    
    /*
    @Override  
    public String toString(){ 
        String res = "";
        if(talla()>0){
            NodoLDEC<E> aux = ultimo.siguiente;
            do{  
                    res = aux.dato.toString()+" "+ res;
                    aux = aux.siguiente;
            }while(aux!=ultimo.siguiente);
        }
        return res;    
    }
       
    public String toStringRev(){ 
        String res = "";
        if(talla()>0){
            NodoLDEC<E> aux = ultimo.siguiente;
            do{  
                    res = res+" "+aux.dato.toString();
                    aux = aux.siguiente;
            }while(aux!=ultimo.siguiente);
        }
        return res;

    }
    

}
