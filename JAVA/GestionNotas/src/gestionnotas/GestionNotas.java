
package gestionnotas;

import java.util.Scanner;

 
public class GestionNotas {
        //Propiedades
        int note;
        int arr[];
        int pos;
        String cali;
        int aprob;
        int media;
        boolean apto;
        int sum;
        
        //Constructor con las posición
        public GestionNotas(int dimen){
            arr = new int[dimen];
        }
        //Métodos
       
        //Añadir nota.
        public void llenarArray(int cali, int pos){
          arr[pos]=cali;
          this.pos=pos;
            }
                 
        
            //Aprobados y suspensos.
        
        public  int aprobados(){
        
        int aprob =0;
        int sum=0;
            for (int i = 0; i <= pos; i++) {
                if (arr[i] >= 5) {
                     apto=true;
                     aprob++;
                     sum=sum+arr[i];
            }
                
        }
       return aprob;
        }
               
         
        //Mostrar media
        public int mostrarMedia(){
            
            media = sum / 10;
            
            return media;
        }
        //Mostrar notas introducidas
        public void mostrarNotas(){
            System.out.println("Las notas introducidas son: ");
            
            
        }
       
        public static void main(String[] args ) {
          GestionNotas nota = new GestionNotas(10);//Llamo al constructor
          int posi=0;
       //Menu de opciones: 1.Añadir notas.
                        // 2. Mostrar media.
                        // 3. Total aprobados.
                        // 4. Mostrar notas introducidas.
                        // 5. Salir.
                        
                System.out.println("MENÚ");
                System.out.println("Elige una opción:");
                System.out.println("1. Añadir nota \n2. Mostrar media \n3. Total aprobados \n4. Mostrar notas introducidas \n5. Salir");
                Scanner scan = new Scanner(System.in);  
                int opcion = scan.nextInt();
                switch (opcion){
                case 1:
                //Añadir nota.
                        System.out.println("Introduce una nota");
                        Scanner scan1 = new Scanner(System.in);  
                        int calif = scan1.nextInt();
                        nota.llenarArray(calif, posi);
                        posi++;
                case 2://Media
                        System.out.println("La nota media de la clase es: "+nota.mostrarMedia());
                      
                case 3: //Aprobados
                        System.out.println("Hay  "+nota.aprobados()+"aprobados.");
                        
                case 4://Mostrar notas

                case 5://Salir
                }
           
        
        }
}
      


