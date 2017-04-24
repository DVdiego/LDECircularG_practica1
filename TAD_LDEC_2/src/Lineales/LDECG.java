
package Lineales;

public class LDECG<E> implements ListaDECircular<E> {
    
    protected NodoLDEC<E> ultimo;
    
    public LDECG(){
        this.ultimo = null;
    }
    
    public NodoLDEC<E> getUltimo(){
        return ultimo;
    }

    @Override
    public void insertar(E x) { // insertar al principio LDECircularG
        NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> primero = ultimo.siguiente;
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

    @Override
    public void insertar(E x, int i) { // Ya modificado para LDECircularG
        
        NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> ant = null;
        NodoLDEC<E> aux = ultimo;
        
        if(i == 0) insertar(x); // insertar al principio
        
        if(i > 0){ // inserción en medio
            
            for(int j=0;j<=i;j++){
                aux = aux.siguiente;
                ant = aux.anterior; 
            }
            nuevo.siguiente = aux;
            ant.siguiente = nuevo;
            nuevo.anterior = ant;
            aux.anterior = nuevo; 
        }
        
        if(i%talla()==2) insertarEnFin(x); //insertar al final
    }

    @Override
    public void insertarEnFin(E x) { // Ya modificado para LDECircularG
       NodoLDEC<E> nuevo = new NodoLDEC<E>(x);
        NodoLDEC<E> primero = ultimo.siguiente;
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

    @Override
    public int indiceDe(E x) { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente;
        int cont = 0;
        while(aux.dato!=x || aux.siguiente!=ultimo){
            aux = aux.siguiente;
            cont++;
        }
        if(aux.dato == x) return cont;
        else return -1;
    }

    @Override
    public E recuperar(int i) { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente;
        if(i>=0){
            for (int j=0; j<i; j++){
                aux = aux.siguiente;
            }
            return aux.dato;
        } else return null;
    }

    @Override
    public boolean vaciarLista() { // Ya modificado para LDECircularG
        ultimo = null;
        return true;
    }

    @Override
    public boolean eliminar(E x) {
        NodoLDEC<E> aux = ultimo.siguiente; 
        while(aux != ultimo && !aux.dato.equals(x)) aux = aux.siguiente;
        NodoLDEC<E> sig = aux.siguiente;
        NodoLDEC<E> ant = aux.anterior;
        if(aux==ultimo&&!aux.dato.equals(x)) return false;
        
        if (aux.anterior == ultimo) ultimo = aux.siguiente;
        else ant.siguiente = aux.siguiente;
        if(aux.siguiente!=null) sig.anterior = aux.anterior;
        return true;
    }

    @Override
    public boolean eliminar(int i) {
        NodoLDEC<E> aux = primero;
        NodoLDEC<E> sig = aux.siguiente;
        NodoLDEC<E> ant = aux.anterior;
        int cont = 0; //->se puede usar una bandera boolean
        if(talla()==0) return false; //si la lista está vacia
        if(talla()==1){
            primero = null;
            cont++;
        }else if (talla()>1){    
            if(i == 0){ //borrado al principio
                sig.anterior = null;
                primero = aux.siguiente;
                cont++;
            }
            if(i < talla()-1 && i>0){ // borrado en medio 
                for(int j = 1;j<=i;j++){
                    aux = aux.siguiente;
                    ant = aux.anterior;
                    sig = aux.siguiente;
                }
                ant.siguiente = aux.siguiente;
                sig.anterior = aux.anterior;
                cont++;
            }
            if(i == talla()-1){  //borrado al final 
                while(aux.siguiente!=null){
                    aux = aux.siguiente;
                    ant = aux.anterior;
                }
                if(ant!=null) ant.siguiente = null;
                cont++;
            }
        }
        if(cont>0) return true;
        else return false;
    }

    @Override
    public boolean esVacia() { // es lo mismo que talla o casi
        if(primero == null) return true;
        else return false;
    }

    @Override
    public boolean contiene(E x) {
        NodoLDEC<E> aux = primero;
        while(aux.siguiente!=null||!x.equals(aux.dato)){
            aux = aux.siguiente;
        }
        if(x.equals(aux.dato)) return true;
        else return false;
    }

    @Override
    public int talla() {
        NodoLDEC<E> aux = primero;
        int cont = 0;
        if(!esVacia()){
            cont++;
            while(aux.siguiente!=null){
                aux = aux.siguiente;
                cont++;
            }
        }
        return cont; 
    }

    @Override
    public E[] toArray() {
        NodoLDEC<E> aux = primero;
        E a[] = null;
        int cont = 0;
        while(aux.siguiente!=null){
            a[cont] = aux.dato;
            aux = aux.siguiente;
        }
        return a;
    }
    
    @Override  
    public String toString(){
        NodoLDEC<E> aux = primero;
        String res = "";
        do{    
           try{ 
                res = aux.dato.toString()+" "+ res;
                aux = aux.siguiente;
           }catch (Exception e){
               System.out.println("no se pudo convertir a string");
           }
        }while(aux!=null);
        return res;    
    }
       
    public String toStringRev(){
        NodoLDEC<E> aux = primero;
        String res = "";
        do{
            res = res+" "+aux.dato.toString();
            aux = aux.siguiente;
        }while(aux!=null);
        return res;
    }
    
    public int contadorNodos(NodoLDEC<E> x, int i){ 
        int cont = i; 
        if(x.siguiente != null){
            NodoLDEC<E> aux = x;
            aux = aux.siguiente;
            return cont+contadorNodos(aux,cont);
        }else return i;
    }
    
    public void invertirLista(int cont){
        //E guarda = null;
        if(talla()>0){
            E guarda = recuperar(cont);
            eliminar(cont);
            invertirLista(cont);
            insertarEnFin(guarda);
        }
    }
    
    public void duplicarNodosPares(){
        int cont = 0;
        if(talla()>0){
            E guarda = recuperar(cont);
            eliminar(cont);
            duplicarNodosPares();
            try{ // Excepción por si se intenta usar el metodo con una lista 
                    //que contenga elementos no enteros
                if(Integer.parseInt(guarda.toString())%2==0) insertar(guarda);
            }catch(Exception e){
                System.out.println("Un elemento no se pudo tratar como entero");
            }
            insertar(guarda);
        }
    }
    
    public void premiarClaves(int x){ 
        int cont = 0;
        if(talla()>0){
            E guarda = recuperar(cont);
            eliminar(cont);
            premiarClaves(x);
            if(Integer.parseInt(guarda.toString())==x){
                Integer i = (Integer.parseInt(guarda.toString()))*2;           
                guarda = (E) i;   
            }   
            insertar(guarda);
        }
    }
    
    
    
}
