
package noemi_jimenez_agendanoe;

import java.util.Scanner;


public class Noemi_Jimenez_AgendaNoe {

   
    public static void main(String[] args) {
         
        int resp;
        int cont = 0;
        int dimension = 20;
        GestionAgenda contacto = new GestionAgenda(dimension);
        Scanner scanResp = new Scanner(System.in);
        Scanner scanContact = new Scanner(System.in);
        Scanner scanPos = new Scanner(System.in);          
        
        do{
            System.out.println("MENU \nElige una opción \n-------------------------");
            System.out.println("1. Añadir contacto \n2. Eliminar contacto \n3. Buscar contacto \n4. Mostrar Todos los contactos \n5. Salir \n------------------------");
            
            resp = scanResp.nextInt();
            
            switch(resp){
                case 1: //Añadir contactos
                    
                    if (cont < dimension){
                        System.out.println("¿Qué contacto quieres introducir?");
                        String contact = scanContact.next();
                        contacto.addContacto(contact, cont); 
                        cont = cont+1;
                        break;
                    }else{
                        System.out.println("Has introducido el máximo de contactos");
                        System.out.println("-----------------------"); 
                    break;
                    }
                    
                    
                case 2: //Eliminar contacto
                        contacto.mostrarTodos();
                        System.out.println("¿Qué posición de Contacto quieres borrar?");
                        int orden = scanPos.nextInt();
                        contacto.delContacto(orden);
                        cont=cont-1;
                    break;
                    
                case 3: //Buscar contacto
                    System.out.println("¿Qué posición de Contacto quieres buscar?");
                     int busca = scanPos.nextInt();
                     contacto.buscarContacto(busca);
                    
                    
                    break;
                case 4: //Buscar contacto
                   contacto.mostrarTodos();
                                       
                break;
            }   
            
        }while (resp != 5);
        
                
    }  
    
}

