
package menu;

import tareas.Operaciones;
import java.util.Scanner;
import excepciones.*;

/**
 * Clase que nos permite usar el TAD que se ha diseñado para realizar
 * distintas tareas.
 */
public class TAD_LDEC {

    /**
     * Main muestra por pantalla de forma repetitiva el menú de opciones.
     * En el metodo se controla que las opciones 2..8 del menú sólo puedan
     * ser ejecutadas si con anterioridad se ha ejecutado la opción 1.
     *  
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner (System.in);
        Operaciones operacion = new Operaciones();
        boolean continuar = true;
        boolean listaCreada = false;
        
        do{
            System.out.println("\t+++++ MENÚ LDEC +++++");
            System.out.println("1. Crear lista de claves enteras");
            System.out.println("2. Introducir claves en la lista");
            System.out.println("3. Contar nodos");
            System.out.println("4. Listado de claves");
            System.out.println("5. Listado de claves al revés");
            System.out.println("6. Duplicar Nodos Pares");
            System.out.println("7. Premiar claves");
            System.out.println("8. Invertir lista");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            String opcion = entrada.nextLine ();
            
            try{
                if(opcion.isEmpty()||opcion.matches(".*[^0-9].*")) 
                  throw new TADExcepciones("\t->Seleccionar una opción [0-8].");

                else if(!listaCreada&&Integer.parseInt(opcion)>1){ 
                  opcion = "9";
                  throw new TADExcepciones("\t->¡Primero debe crear la lista!");
                }
            }catch(TADExcepciones ex){
                System.out.println(ex.getMessage());
                operacion.pausa();
            }
            
            switch(opcion){
                
                case "1": operacion.crearListaClavesEnteras();
                          listaCreada = true;break;
            
                case "2": operacion.introducirClavesLista(); break;
                
                case "3": operacion.contarNodos(); break;
                
                case "4": operacion.listadoDeClaves(); break;
            
                case "5": operacion.listadoDeClavesRev(); break;
                
                case "6": operacion.duplicarNodosPares(); break;
                
                case "7": operacion.premiarClaves();break;
            
                case "8": operacion.invertirLista(); break;
                
                case "0": operacion.salir();continuar = false; break;
                
                default: continuar = true; break;
                               
            }
            
        }while(continuar); 
    }
    
    
}
      
    

