package ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.DAOLibros;
import datos.Db;
import modelos.Libro;

public class GestionLibros {
	
	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/**
		 * Inicializamos conexion con la base de datos
		 */
		Db.init();
		
		boolean continuar = true;
		
		while(continuar){
			
			imprimirMenu();
			String s = teclado.nextLine();
			s = s.trim();/*Quitamos espacios*/
			
			if(s.length()>0){/*Esto es para comprobar que el usuario ha introducido datos*/
				char o = s.charAt(0);/*No quedamos con el primer caracter de la cadena*/
				switch(o){
				case '1':
					altaLibro();
					break;
				case '2':
					eliminacionLibro();
					break;
				case '3':
					busquedaLibro();
					break;
				case '4':
					listarLibros();
					break;
				case'5':
					System.out.println("Nos vemos en otra ocasión.\nAdios");
					continuar = false; /*Para parar el bucle del Menu*/
					Db.cerrar();/*Para cerrar la conexion con la base de datos*/
					break;
				default:
					System.out.println("Introduce una opción válida, por favor (1,2,3,4)");
				}
			}
		}
	}
	/**
	 * Metodo que imprime el Menu
	 */
	private static void imprimirMenu(){
		System.out.println("----------- MENU-----------");
		System.out.println("1.Alta de libro");
		System.out.println("2. Eliminacion de libro");
		System.out.println("3. Busqueda de libro");
		System.out.println("4. Lista de Libros");
		System.out.println();
		System.out.println("5. Salir");
		System.out.println("Escoge una opcion");
		
	}
	/**
	 * Utilizaremos un metodo a parte para pedir la Primary Key isbn
	 */
	
	private static int pedirIsbn(){
		boolean hecho = false;
		int isbn = -1;
		while(!hecho){
			try{
				System.out.println("Introduce el identificador ISBN del libro: ");
				isbn = teclado.nextInt();
				teclado.nextLine();
				
				hecho = true;
			}
			catch(InputMismatchException ime){
				teclado.nextLine();
				System.out.println("Por favor introduce un numero valido.");
			}
		}
		return isbn;
	}
	/**
	 * Metodos enlazados con el DAO
	 */
	private static void altaLibro(){
		/**
		 * Pedimos los datos o valores de las propiedades.
		 */
		DAOLibros dao = new DAOLibros();
		int isbn = pedirIsbn();
		if(!dao.comprobarExistencia(isbn)){
			System.out.println("¿Cual es el titulo del libro? ");
			String titulo = teclado.nextLine();
			System.out.println("¿Quien escribio ese libro?");
			String autor = teclado.nextLine();
			System.out.println("¿Cuantas paginas tiene el libro?");
			int paginas = teclado.nextInt();
			teclado.nextLine();
	
			/**
			 * Generamos el objeto Libro con los parametros introducidos.
			 * Lo añadimos a la Base de datos.
			 */
			 Libro l = new Libro(isbn,titulo,autor,paginas);
			 
				 if(!dao.create(l)){
					 System.out.println("Fallo en el alta.");
				 }
		
		 }
		else{
			System.out.println("El ISBN introducido ya existe.");
		}
	}
	private static void eliminacionLibro(){
		int isbn = pedirIsbn();
		DAOLibros dao= new DAOLibros();
		int resultado = dao.delete(isbn);
		switch(resultado){
		case DAOLibros.OK:
			System.out.println("Libro borrado correctamente");
			break;
		case DAOLibros.NO_EXISTE:
			System.out.println("El libro es inexistente");
			break;
		case DAOLibros.ERROR:
			System.out.println("Fallo al intentar borrar de la Base de Datos");
			break;
		}
	}
	private static void busquedaLibro(){
		System.out.println("Introduce un fragmento del titulo");
		String fragmento = teclado.nextLine();
		DAOLibros dao = new DAOLibros();
		ArrayList<Libro> li =dao.read(fragmento);
		for(Libro l:li){
			System.out.println(l);
		}
	}
	/**
	 * Incluyo listarLibros() para poder visualizar todos los libros de la Base de datos 
	 */
	private static void listarLibros(){
		System.out.println("Lista de todos los libros de la libreria: ");
		System.out.println();
		DAOLibros dao= new DAOLibros();
		ArrayList<Libro> li = dao.listar();
	
		
		for(Libro l:li){
			System.out.println(l);
		}
	}
}
