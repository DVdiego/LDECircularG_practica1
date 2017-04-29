
package tareas;

import Lineales.LDECG;
import excepciones.TADExcepciones;
import java.io.IOException;
import java.lang.Integer;
import java.util.Scanner;


/**
 * Clase operaciónes que hace uso de los métodos del TAD para
 * realizar todas sus tareas 
 */
public class Operaciones {
    
    Scanner input = new Scanner (System.in); 
    protected LDECG<Integer> lista = null;
    
     /**
     * Crea una lista si lista apunta a null, sino vacia la lista actual
     * mediante el metodo vaciarlista y pone a null la ultima referencia 
     * a la lista.
     * @see #crearListaClavesEnteras()  
     */
    public void crearListaClavesEnteras(){ 
        if(lista==null) lista = new LDECG();
        else lista.vaciarLista();
        System.out.println("\n**LDEC vacía creada**");
        pausa();
    }
 
    
    /**
     * Método introducirClaves pide al usuario introducir las claves por teclado
     * las mismas se almacenan en una cadena, posteriormente las separala usando
     * como refenrecia los distintos separadores admitidos, y almacena cada
     * clave en un array de strings que es el que se usara para finalmente
     * insertarlas individualmente en la lista de nodos LDEG.
     * En este proceso se controla que solo se adminan enteros y que para
     * terminar de introducir las claves se incluya -1 al final.
     * @see Lineales.LDECG#toString() 
     * @see Lineales.LDECG#insertar(java.lang.Object) 
     */
    public void introducirClavesLista(){
        boolean bandera = false;
        String delimitadores = "[ .,;?!¡¿\'\"\\[\\]]";
        String claves = "";
        
        do{
            System.out.println("\n\tINTRODUCIR CLAVES");  
            try{
                System.out.print("Introduzca claves (-1 para terminar): ");
                claves = input.nextLine();   
                if(claves.matches(".*[a-zA-Z].*") ) 
                    throw new TADExcepciones("->Introduce claves enteras!.");
                if(!claves.contains("-1")) 
                    throw new TADExcepciones
                    ("->Incluye -1 al final para introducirlas en la lista.");
                bandera = false;                   

                }catch(TADExcepciones ex){
                    System.out.println(ex.getMessage());
                    bandera = true;
                }
            
        }while(bandera);

        String[] clavesIndividuales = claves.split(delimitadores);
        
        for(int i=0;i<clavesIndividuales.length-1;++i){                    
            if(Integer.parseInt(clavesIndividuales[i])<0)
                lista.insertar((Integer.parseInt(clavesIndividuales[i])*-1)); 
            else 
                lista.insertar(Integer.parseInt(clavesIndividuales[i]));                  
        }   
        System.out.println("\tLa lista creada es: "+lista.toString());
        pausa();
    }

    
    /**
     * Método que muestra por pantalla la lista de claves y la talla del mismo.
     * @see Lineales.LDECG#contadorNodos()
     * @see Lineales.LDECG#toString()
     */
    public void contarNodos(){ 
        int i = lista.contadorNodos();
        System.out.println("\n\tCONTAR NODOS");
        System.out.println
        ("\nLa lista: "+lista.toString()+" tiene "+i+" elementos");
        pausa();
    }

    
    /**
     * Método que muestra por pantalla una cadena con la lista de claves.
     * @see Lineales.LDECG#toString()
     */
    public void listadoDeClaves(){
        System.out.println("\n\tLISTADO DE CLAVES\n");
        System.out.println("\t"+lista.toString());
        pausa();
    }
    
    
    /**
     * Método que muestra por pantalla una cadena con la lista de claves de 
     * forma invertida.
     * @see Lineales.LDECG#toStringRev()
     */
    public void listadoDeClavesRev(){
        System.out.println("\n\tLISTADO DE CLAVES(al revés)\n");
        System.out.println
        ("\t"+lista.toStringRev());
        pausa();
    }
    
    
    /**
     * Método que muestra por pantalla la lista de claves, llama al método 
     * duplicarNodosPares para duplicar los nodos pares y muestra la nueva 
     * lista de claves con los nodos pares duplicados.
     * @see Lineales.LDECG#toString()
     * @see Lineales.LDECG#duplicarNodosPares() 
     */
    public void duplicarNodosPares(){
        System.out.println("\n\tDUPLICAR NODOS PARES");
        System.out.println("Lista Inicial: "+lista.toString());
        lista.duplicarNodosPares();
        System.out.println("**Lista con duplicados: "+lista.toString());
        pausa();
    }

    
    /**
     * Método que muestra por pantalla la lista de claves, llama al método 
     * duplicarNodosPares para duplicar los nodos pares y muestra la nueva
     * lista de claves con los nodos en orden invertido respecto a la inicial.
     * @see Lineales.LDECG#toString()
     * @see Lineales.LDECG#invertirLista()
     */
    public void invertirLista(){
        System.out.println("\n\tINVERTIR LISTA\n");
        System.out.println("Lista inicial: "+lista.toString());
        lista.invertirLista();
        System.out.println("Lista invertida: "+lista.toString());
        pausa();
    }
    

    
    /**
     * Método que muestra por pantalla la lista de claves, llama al método 
     * premiarClaves para duplicar el valor contenido en los nodos cuyo valor
     * coincida con la talla y muestra la nueva
     * lista de claves con los valores de los nodos duplicados.
     * Tambien nos avisa si se han premiado claves o no, comparando la lista 
     * original almacenada en una cadena y la compara con la cadena de la lista
     * nueva.
     * @see Lineales.LDECG#toString()
     * @see Lineales.LDECG#premiarClaves()
     */
    public void premiarClaves(){
        System.out.println("\n\tPREMIAR CLAVES\n");
        String inicial = lista.toString();
        System.out.println("Lista inicial: "+inicial);
        lista.premiarClaves();
        if(inicial.equals(lista.toString())) System.out.println
        ("->No se han premiado claves, ninguna clave coincide con la talla.");
        else System.out.println("->¡Se han premiado claves!");
        System.out.println("**Lista con duplicados: "+lista.toString());
        pausa();
    }
    
    
    /**
     * Método que muestra por pantalla un mensaje de salia.
     */
     public void salir(){
        System.out.println
        ("\n\tGracias por utilizar nuestro TAD Lista Doblemente Enlazada(LDE)");
    }
    
     
    /**
     * Método que nos sirve para realizar la función de pausa.
     */ 

    public void pausa(){
        try {
           System.out.println("\nPulse <Intro> para continuar...");
           int read = System.in.read();
        } catch (IOException ex) {}
        System.out.println("\n");
    }
     
}
