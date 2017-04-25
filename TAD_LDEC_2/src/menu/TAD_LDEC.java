
package menu;

import tareas.Operaciones;
import java.util.Scanner;


public class TAD_LDEC {

  
    public static void main(String[] args) {
        // TODO menú para el programa con la utilización del TAD
        Scanner entrada = new Scanner (System.in);
        Operaciones operacion = new Operaciones();
        boolean continuar = true;
        boolean listaCreada = false;
        
        do{
            System.out.println("\t +++++ MENÚ LDE +++++");
            System.out.println("1. Crear lista de claves enteras");
            System.out.println("2. Introducir claves en la lista");
            System.out.println("3. Contar nodos");
            System.out.println("4. Listado de claves");
            System.out.println("5. Listado de claves al revés");
            System.out.println("6. Duplicar Nodos Pares");
            System.out.println("7. Premiar claves");
            System.out.println("8. Invertir lista");
            System.out.println("0. Salir");
            System.out.print("Opción:");
            String opcion = entrada.nextLine ();
            
            if(opcion.isEmpty()||opcion.matches(".*[^0-9].*")){
                System.out.println("\tSeleccionar una opción [0-8]");
                operacion.pausa();
            }else if(!listaCreada&&Integer.parseInt(opcion)>1){
                opcion = "9";
                System.out.println("\t¡Primero debe crear la lista!");
                operacion.pausa();
            }
            
            switch(opcion){
                
                case "1": 
                    operacion.crearListaClavesEnteras();
                    listaCreada = true;
                break;
            
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
      
    

