package ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import dao.DAOAvion;
import datos.Db;
import modelos.Avion;

public class ProgramaAviones {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Db.init();/*Inicializar la BBDD, conexi�n*/
		
		boolean continuar = true;
		
		while(continuar){
			imprimirMenu();
			System.out.println("\nIntroduzca la opcion");
			String s = teclado.nextLine();
			s = s.trim();/*Elimina los espacios del principio y del final, tabuladores y saltos de l�nea que pueda haber introducido el usuario*/
			
			if(s.length()>0){/*Compruebo que el usuario ha metido datos*/
				char o = s.charAt(0); /*Obtiene el primer caracter de la cadena*/
				switch(o){
				case '1':
					insertarAvion();
					break;
				case '2':
					modificarAvion();
					break;
				case '3':
					eliminarAvion();
					break;
				case '4':
					listarAviones();
					break;
				case '5':
					buscarAvion();
					break;
				case '6':
					System.out.println("Adios. Gracias por utilizar nuestra aplicaci�n.");
					continuar = false;
					Db.cerrar();
				default:
					System.out.println("Introduce una opci�n v�lida, por favor.");
				}
			}
			
		}

	}
	private static void imprimirMenu(){
		
		System.out.println("\n------------MENU-------------");
		System.out.println();
		System.out.println("1. Insertar un Avion");
		System.out.println("2. Modificar Avion");
		System.out.println("3. Borrar Avion");
		System.out.println("4. Listar aviones");
		System.out.println("5. Buscar un Avion concreto");
		System.out.println("-----------------------------");
		System.out.println("6. Salir");
		System.out.println("-----------------------------");
		
	}
	private static int pedirIdentificador(){
		boolean hecho=false;
		int idavion=-1;
		while(!hecho){
			try{
				System.out.print("Identificador del avion: ");
				idavion = teclado.nextInt();
				hecho=true;
			}
			catch(InputMismatchException e){ //Excepcion que se produce cuando el usuario no introduce un numero
				System.out.println("Por favor introduce un numero valido");
			}
		}
		return idavion;
	}
	private static void insertarAvion(){
		/**
		 * Pedimos datos
		 */
		System.out.print("Descripcion del Avion:");
		String descripcion = teclado.next();
		System.out.print("Peso: ");
		Double peso = teclado.nextDouble();
		
		/**
		 * Generamos el avion y lo creamos en la BBDD
		 */
		Avion av= new Avion(-1,descripcion,peso);
		DAOAvion dao=new DAOAvion();/*Para decirle que cree un avion en la BBDD*/
		
		if(!dao.create(av)){/*Crea el avion desde DAO, interact�a*//*pongo if*/
			System.out.println("Fallo en la insercci�n. �El avion ya est� insertado?");
		
		}
	}
	
	private static void modificarAvion(){
		
		/**
		 * Pedimos datos
		 */
		
		int idavion = pedirIdentificador();
		System.out.println("Nueva descripcion del avion:");
		String descripcion = teclado.nextLine();
		System.out.print("Nuevo Peso: ");
		Double peso = teclado.nextDouble();
				
		Avion av = new Avion(idavion,descripcion, peso);
		DAOAvion dao=new DAOAvion();
		if(!dao.update(av)){
			System.out.println("Fallo en la modificaci�n");
		
		}
	}
	
	private static void eliminarAvion(){
		
		int idavion = pedirIdentificador();
		
		DAOAvion dao=new DAOAvion();
		if(!dao.delete(idavion)){
			System.out.println("Fallo al borrar el avi�n.");
		}
	}
	private static void buscarAvion(){
		/**
		 * Pedimos datos
		 */
		
		int idavion = pedirIdentificador();
		
		
		DAOAvion dao=new DAOAvion();
		Avion av = dao.read(idavion);/*Llamamos al avion, hacemos consulta*/
		if(av!=null){/*verificaci�n de si los campos est�n vac�os*/
			System.out.println(av);
		}
		else{
			System.out.println("El Identificador introducido no consta en la BBDD");
		}
	}
	private static void listarAviones(){
		System.out.println("Listado de todas los aviones.");
		System.out.println();
		DAOAvion dao=new DAOAvion();
		ArrayList<Avion> a =dao.listar();
		
		for(Avion av:a){/*Recorre el array*/
			System.out.println(av);
		}
	}
}
