package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import models.Viaje;

public class DAOViaje {
	/**
	 * Listado de todos los viajes
	 * @return lista de viajes
	 */
	public ArrayList<Viaje> listar(){
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		
		String sql="select * from viaje";
		
		try(Connection con=DB.getConexion();
			Statement stm=con.createStatement();){
				ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next()){
				Viaje v=new Viaje(rs.getInt("id"),rs.getString("destino"),rs.getInt("duracion"),rs.getFloat("precio"));
				lista.add(v);
			}
		
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	}
	/**
	 * Búsqueda de viajes por palabra
	 * @return Listado de viajes con esa palabra
	 */
	public ArrayList<Viaje> buscar(String palabra){
		ArrayList<Viaje> lista = new ArrayList<Viaje>();
		
		String sql="select * from viaje where destino like ?";
							
			try(Connection con=DB.getConexion();
					PreparedStatement ps=con.prepareStatement(sql);){
				
				ps.setString(1,"%"+palabra+"%");
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					Viaje v=new Viaje(rs.getInt("id"),rs.getString("destino"),rs.getInt("duracion"),rs.getFloat("precio"));
					lista.add(v);
				}
				rs.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		
		return lista;
	}
	/**
	 * método leer para poder leer la promoción
	 * @param id del viaje en promocion
	 * @return v viaje en promocion completo
	 */
	public Viaje read(int id){
		Viaje v = null;
		
		String sql="select * from viaje where id=?";
		
		try(Connection con=DB.getConexion();
				PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				v=new Viaje(id,rs.getString("destino"),rs.getInt("duracion"),rs.getFloat("precio"));
			}
			rs.close();
		}
		catch(SQLException sqle){
			System.out.println("Fallo al leer viaje");
		}
		
		
		return v;
	}
}
