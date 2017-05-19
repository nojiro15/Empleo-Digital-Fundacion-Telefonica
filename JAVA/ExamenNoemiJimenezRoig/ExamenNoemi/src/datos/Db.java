package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	/**
	 * Establece la conexion con la Base de datos
	 */
	private static Connection con;
	
	/**
	 * Hacemos el metodo de inicializar la conexion
	 */
	public static void init(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root","");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Imposible conectar con la Base de datos. Consulte con el administrador.");
		}
		catch(SQLException sqle){
			System.out.println("Base de Datos inexistente o sin conexion. Contactar con el administrador.");
		}
	}
	/**
	 * Creamos el metodo cerrar conexion
	 */
	public static void cerrar(){
		try{
			con.close();
			System.out.println("Desconexion con la Base de Datos efectuada.");
		}
		catch(SQLException sqle){
			System.out.println("No se ha podido desconectar la Base de Datos");
		}
	}
	/**
	 * Creamos el metodo getConexion que retornara al programa la conexion. 
	 */
	public static Connection getConexion(){
		return con;
	}
}
