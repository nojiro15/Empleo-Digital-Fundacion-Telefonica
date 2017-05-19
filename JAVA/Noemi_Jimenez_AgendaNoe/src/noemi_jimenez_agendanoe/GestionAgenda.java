
package noemi_jimenez_agendanoe;

public class GestionAgenda {
        //Propiedades
        String arr[];
        int dimen;
        
        //Constructor
        public GestionAgenda(int dim){
            arr = new String [dim];
            dimen = dim;
        }
        
        //Métodos
        //Añadir contacto  
        public void addContacto(String nom, int pos){
          arr[pos]=nom;
          
        }
        //Eliminar contacto
        public void delContacto(int posi){

            if (arr[posi]!= null) {
                arr[posi]=null;
                String aux = null; 
                for (int i = 0; i < dimen; i++) {
                   for (int j = i+1; j < dimen; j++) {
                         if (arr[i]== null) {//De esta manera voy trasladando el valor de i.
                             aux = arr[i];  //Así los vacíos se quedan al final del array.
                             arr[i]=arr[j];
                             arr[j]=aux;

                            }

                        }
                }
                     System.out.println("El contacto ha sido borrado");
                     System.out.println("-----------------------");
            }else{
                     System.out.println("La posición ya está vacía.");
                     System.out.println("-----------------------");
                 }

             }
        //Buscar contacto
           public void buscarContacto(int pos){
         if (arr[pos]!=null) {
          System.out.println("El contacto es " + arr[pos]);
          System.out.println("-----------------------");   
         }
         else{
             System.out.println("El contacto no existe");
             System.out.println("-----------------------");
         }
         
        }
        //Mostrar contactos
        public void mostrarTodos(){
          for (int i = 0; i < dimen; i++) {
                System.out.println(i+"-"+arr[i]);
            }
     }
}
