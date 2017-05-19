package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.resource.cci.ResultSet;

import db.DB;

import models.Anuncio;

public class DAOAnuncio {
	
	public ArrayList<Anuncio>buscarText(String palabra){
		ArrayList<Anuncio> listado=new ArrayList<Anuncio>();
		String sql = "select * from anuncios where texto like%?%";
		try(Connection con=DB.getConexion();PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, palabra);
			ResultSet rs=(ResultSet) ps.getResultSet();
			
			while(rs.next()){
				Anuncio a=new Anuncio(rs.getInt("id"),
						rs.getString("texto"));
				listado.add(a);
				
			}
			rs.close();/*¡Ojo!Comprueba que todos los preparedStatement
			 			estén cerrados, los Statement no hace falta*/
		}
		catch(SQLException sqle){
			System.out.println("Fallo al buscar el texto");
		}
		return listado;
	}
	public ArrayList<Anuncio>listar(){
		ArrayList<Anuncio> lista=new ArrayList<Anuncio>();
		String sql = "select * from anuncios order by id";
		try(Connection con=DB.getConexion();
				Statement stm=con.createStatement()){
			
			ResultSet rs=(ResultSet) stm.executeQuery(sql);
			
			while(rs.next()){
				Anuncio a=new Anuncio(rs.getInt("id"),
						rs.getString("texto"));
				lista.add(a);
				
			}
		}
		catch(SQLException sqle){
			System.out.println("Fallo al listar");
		}
		return lista;
	}
	public Anuncio read(int id){
		Anuncio a=null;
		
		String sql="select* from anuncios where id=?";
		try(Connection con=DB.getConexion();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs=(ResultSet) ps.executeQuery();
			if(rs.next()){
				a = new Anuncio(id,rs.getString("texto"));
			}
			
		}
		catch(SQLException sqle){
			System.out.println("Fallo al leer");
		}
		return a;
	}
	/**
	 * Hacemos un método para contar todos los anuncios que hay en la BBDD
	 * @return
	 */
	public int contar(){
		int n= 0;
		String sql = "select count(id) as n from anuncios";/*cuenta el número de filas total*/
		try(Connection con=DB.getConexion();
				Statement stm=con.createStatement()){
			
			ResultSet rs=(ResultSet) stm.executeQuery(sql);
			
			rs.next();
			n=rs.getInt("n");
		}
		catch(SQLException sqle){
			System.out.println("Fallo al contar");
		}
		return n;
	}
	
}
