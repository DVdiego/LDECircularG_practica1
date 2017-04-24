
package tareas;

import Lineales.LDECG;
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
            System.out.print("Introduzca claves (-1 para terminar):");
            claves = input.nextLine();
            //otros delimitadores"[ .,;?!¡¿\'\"\\[\\]]"
            bandera = claves.contains("-1");
            
            }while(bandera==false || claves.matches(".*[a-zA-Z].*"));   
        
        String[] clavesIndividuales = claves.split(delimitadores);
        for(int i=0;i<clavesIndividuales.length-1;++i){ 
                    
            lista.insertar(Integer.parseInt(clavesIndividuales[i]));       
            
        }   
        System.out.println("La lista creada es: "+lista.toString());
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
        System.out.println(lista.toString());
        pausa();
    }
    
    public void listadoDeClavesRev(){
        System.out.println("\n\tLISTADO DE CLAVES(al reves)\n");
        System.out.println(lista.toStringRev());
        pausa();
    }
    
    public void duplicarNodosPares(){
        System.out.println("\n\tDUPLICAR NODOS PARES");
        System.out.println("Lista Inicial: "+lista.toString());
        lista.duplicarNodosPares();
        System.out.println("**Lista con duplicados: "+lista.toString());
        pausa();
    }
    
    public void invertirLista(){
        System.out.println("\n\tINVERTIR LISTA\n");
        System.out.println("Lista inicial: "+lista.toString());
        lista.invertirLista(0);
        System.out.println("Lista invertida: "+lista.toString());
        pausa();
    }
    
    
    public void premiarClaves(){
        System.out.println("\n\tPREMIAR CLAVES\n");
        System.out.println("Lista inicial: "+lista.toString());
        lista.premiarClaves(lista.talla());
        System.out.println("**Lista con duplicados: "+lista.toString());
        pausa();
    }
    
    
     public void salir(){
        
        System.out.println("\n\tGracias por utilizar nuestro TAD Lista Doblemente Enlazada (LDE)");

    }
    
    
    
    public void pausa(){
        try {
           System.out.println("\nPulse <Intro> para continuar...");
           int read = System.in.read();
        } catch (IOException ex) {}
        System.out.println("\n");
    }
     
}
