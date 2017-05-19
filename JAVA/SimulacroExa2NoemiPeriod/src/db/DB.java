package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {
	/**
	 * Devuelve una conexión a la base de datos.
	 * @return Conexion a la base de datos
	 * Lo que vaya en comentarios // es para acerlo para Tomcat
	 * Tener en cuenta que para Tomcat necesitamos el archivo Context.xml
	 * Con Context en web.xml habrá que meter el resource
	 */
	public static Connection getConexion(){
		Connection con=null;
		try {
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			//Context envContext = .....
			dataSource = (DataSource)initContext.lookup("PeriodicoDB");//Esto cambia
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return con;
}
}
