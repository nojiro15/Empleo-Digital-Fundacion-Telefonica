package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.resource.cci.ResultSet;

import db.DB;
import modelos.DiarioBean;

public class DAODiarioB implements Serializable{
	private static final long serialVersionUID=1L;
	
	public DAODiarioB(){
		
	}
	
	/**
	 * Método Crear
	 */
	public ResultadoCRUD create(DiarioBean d){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="insert into diario(id,nombre_usuario,fecha,texto) values(?,?,?,?)";
		try(Connection con=DB.getConexion();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1, d.getId());
			ps.setString(2, d.getNombre());
			Date f=new Date(d.getFecha().getTime());/*Esto transforma la fecha en milisegundos para que mysql lo entienda*/
			ps.setDate(3, f);
			ps.setString(4, d.getTexto());
		}
		catch(SQLException sqle){
			System.out.println("Fallo al insertar una nueva entrada en el diario");
		}
		return r;
	}
		
	/**
	 * Método listar
	 */
	public ArrayList<DiarioBean> listar(){
		ArrayList<DiarioBean> lista=new ArrayList<DiarioBean>();
		
		String sql="select* from diario order by fecha";
		try(Connection con=DB.getConexion();
				Statement stm=con.createStatement();){
			stm.executeQuery(sql);
			
			ResultSet rs=(ResultSet) stm.getResultSet();
			while(rs.next()){
				DiarioBean d=new DiarioBean(rs.getInt("id"),
						rs.getString("nombre"),rs.getDate("fecha"),
						rs.getString("texto"));
				lista.add(d);
				
			}
		}
		catch(SQLException sqle){
			System.out.println("Fallo al hacer la lista de entradas");
		}
		
		return lista;
	}
	/**
	 * Método Borrar
	 */
	public ResultadoCRUD delete(int id){
		ResultadoCRUD r =ResultadoCRUD.ERROR;
		String sql="delete from diario where id=?";
		
		return r;
	}
}
