package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	/**
	 * Establecer conexión con la Base de datos
	 */
	private static Connection con;

	public static void init(){/*Abre conexión con la BBDD*/
		
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aeronaves","root","");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Imposible conectar con la BBDD. Por favor consulta con administrador");
		}
		catch(SQLException sqle){
			System.out.println("BBDD inexistente o no se puede conectar. Por favor consulta con administrador");
		}
	}
	public static void cerrar(){
		try{
			con.close();
			System.out.println("BBDD cerrada exitosamente");
		}
		catch(SQLException sqle){
			System.out.println("No se ha podido cerrar la BBDD");
		}
	}
	
	
	public static Connection getConexion(){/*Retornará la conexión*/
		return con;
	}
}
