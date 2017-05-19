package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import datos.Db;
import modelos.Libro;

public class DAOLibros {
		/**
		 * Establecemos conexion
		 */
	 private Connection con = (Connection) Db.getConexion();
	 public static final int OK =0;
	 public static final int ERROR=1;
	 public static final int NO_EXISTE =2;
	 
	 	/**
	 	 * Generamos los metodos CRUD
	 	 */
	 public boolean create(Libro l){
		 String sql = "insert into libros (isbn,titulo,autor,paginas) values (?,?,?,?)";
		 
		 try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1,l.getIsbn() );
			 ps.setString(2, l.getTitulo());
			 ps.setString(3, l.getAutor());
			 ps.setInt(4, l.getPaginas());
			 ps.executeUpdate();
			 ps.close();
			 return true;
		 }
		 catch(SQLException sqle){
			
			 System.out.println("Fallo al crear el libro.");
			 return false;
		 }
	 }
	 public int delete(int isbn){
		 int resultado =OK;
		 String sql = "delete from libros where isbn=?";
		 
		 try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, isbn);
			 int numeroBorrado=ps.executeUpdate();
			 if(numeroBorrado>0){
				 	resultado=OK;
			 }
			 else{
				 resultado=NO_EXISTE;
			 }
			 
			
		 }
		 catch(SQLException sqle){
			resultado=ERROR;
			
		 }
		 return resultado;
	 }
	 public ArrayList<Libro> read(String fragmento){
		 
		 ArrayList<Libro> resultadoBuscar = new ArrayList<Libro>();
		 
		 String sql = "select * from libros where titulo like?";
		 try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, "%" +fragmento+"%");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 Libro l = new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("paginas"));
				 resultadoBuscar.add(l);
			 }
			 rs.close();
		 }
		 catch(SQLException sqle){
			
			 System.out.println("Fallo en la busqueda del libro.");
		 }
		 return resultadoBuscar;
		 
	 }
	/**
	 * Crearemos un ArrayList para poder visualizar los distintos libros encontrados con el mismo fragmento de título.
	 * @return
	 */
	 public ArrayList<Libro> listar(){
		 ArrayList<Libro> libros = new ArrayList<Libro>();
		 
		 String sql = "select * from libros order by isbn";
		 try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 Libro l = new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("paginas"));
				 libros.add(l);
			 }
			 rs.close();
		 }
		 catch(SQLException sqle){
			 
			 System.out.println("Al listar la Base de Datos ha fallado");
		 }
		 return libros;
	 }
	 		/**
	 		 * Comprobamos si el isbn ya existe.
	 		 * Lo haremos mediante una consulta a la Base de Datos
	 		 */
	 		public boolean comprobarExistencia(int isbn){
	 			String sql = "select * from libros where isbn = ?";
	 			
	 			try {
	 				PreparedStatement ps = con.prepareStatement(sql);
	 				ps.setInt(1, isbn);
	 				ResultSet  rs = ps.executeQuery();
	 				
	 				if (rs.next()){
	 					ps.close();
	 					rs.close();
	 					return true;
	 				}
	 				
	 			} 
	 			catch (SQLException sqle){
	 				System.err.println("Error en la consulta.");	
	 			}
	 			return false;
	 		}
	 		
	 		
}
