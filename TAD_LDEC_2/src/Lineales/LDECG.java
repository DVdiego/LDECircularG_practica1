
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
        if(i>=0&&i<talla()){
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
    public boolean eliminar(E x) { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente; 
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
    }

    @Override
    public boolean eliminar(int i) { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente;
        NodoLDEC<E> sig = aux.siguiente;
        NodoLDEC<E> ant = aux.anterior;
        boolean bandera = false; //->se puede usar una bandera boolean
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

    @Override
    public boolean esVacia() { // Ya modificado para LDECircularG
        if(ultimo == null) return true;
        else return false;
    }

    @Override
    public boolean contiene(E x) { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente;
        while(aux!=ultimo||!x.equals(aux.dato)){
            aux = aux.siguiente;
        }
        if(x.equals(aux.dato)) return true;
        else return false;
    }

    @Override
    public int talla() { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente;
        int cont = 0;
        if(!esVacia()){
            cont++;
            while(aux!=ultimo){
                aux = aux.siguiente;
                cont++;
            }
        }
        return cont; 
    }

    @Override
    public E[] toArray() { // Ya modificado para LDECircularG
        NodoLDEC<E> aux = ultimo.siguiente;
        E a[] = null;
        int cont = 0;
        while(aux!=ultimo){
            a[cont] = aux.dato;
            aux = aux.siguiente;
            cont++;
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
