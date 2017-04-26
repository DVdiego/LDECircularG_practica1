
package tareas;

import Lineales.LDECG;
import excepciones.TADExcepciones;
import java.io.IOException;
import java.lang.Integer;
import java.util.Scanner;


public class Operaciones {
    Scanner input = new Scanner (System.in); 
    protected LDECG<Integer> lista = null;
    
    public void crearListaClavesEnteras(){ 
        if(lista==null) lista = new LDECG();
        else lista.vaciarLista();
        System.out.println("\n**LDE vacia creada**");
        pausa();
    }
    
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
                    
            lista.insertar(Integer.parseInt(clavesIndividuales[i]));       
            
        }   
        System.out.println("\tLa lista creada es: "+lista.toString());
        pausa();
    }
    
    
    public void contarNodos(){
        int i = lista.contadorNodos(lista.getUltimo(),1);
        System.out.println("\n\tCONTAR NODOS");
        System.out.println("\nLa lista: "+lista.toString()+" tiene "+i+" elementos");
        pausa();
    }
    
    public void listadoDeClaves(){
        System.out.println("\n\tLISTADO DE CLAVES\n");
        System.out.println("\t"+lista.toString());
        pausa();
    }
    
    public void listadoDeClavesRev(){
        System.out.println("\n\tLISTADO DE CLAVES(al reves)\n");
        System.out.println("\t"+lista.toStringRev());
        pausa();
    }
    
    /**
     * 
     */
    public void duplicarNodosPares(){
        System.out.println("\n\tDUPLICAR NODOS PARES");
        System.out.println("Lista Inicial: "+lista.toString());
        lista.duplicarNodosPares();
        System.out.println("**Lista con duplicados: "+lista.toString());
        pausa();
    }
    
    /**
     * Invierte el orden de los elementos dentro de la lista.
     * @see (lineales.LDECG#invertirLista(); lineales.LDECG#toString(); #pausa())
     */
    public void invertirLista(){
        System.out.println("\n\tINVERTIR LISTA\n");
        System.out.println("Lista inicial: "+lista.toString());
        lista.invertirLista(0);
        System.out.println("Lista invertida: "+lista.toString());
        pausa();
    }
    
    /**
     * Duplica las claves que coincidan con la talla de la lista.
     * @see (lineales.LDECG#premiarClaves(); lineales.LDECG#toString(); #pause())
     */
    public void premiarClaves(){
        System.out.println("\n\tPREMIAR CLAVES\n");
        String inicial = lista.toString();
        System.out.println("Lista inicial: "+inicial);
        lista.premiarClaves(lista.talla());
        if(inicial.equals(lista.toString())) System.out.println
        ("->No se han premiado claves, ninguna clave coincide con la talla.");
        else System.out.println("->¡Se han premiado claves!");
        System.out.println("**Lista con duplicados: "+lista.toString());
        pausa();
    }
    
    /**
     * La función salir() imprime por pantalla el mensaje de gracias.
     */
     public void salir(){
        
        System.out.println("\n\tGracias por utilizar nuestro TAD Lista Doblemente Enlazada (LDE)");

    }
    
    /**
     * La función pausa() nos crea una pausa en el sistema hasta pulsar intro
     * con una excepción por si la pausa falla.
     */
    public void pausa(){
        try {
           System.out.println("\nPulse <Intro> para continuar...");
           int read = System.in.read();
        } catch (IOException ex) {}
        System.out.println("\n");
    }
     
}
