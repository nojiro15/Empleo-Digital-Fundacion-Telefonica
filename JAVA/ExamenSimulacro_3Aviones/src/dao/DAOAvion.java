package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.Db;
import modelos.Avion;

public class DAOAvion {
		/**
		 * Metodos CRUD:
		 * Create
		 * Read
		 * Update
		 * Delete
		 * Listar
		 */
	private Connection con = Db.getConexion();/*Conectamos con Db*/
	
	public boolean create(Avion av){
		String sql = "insert into aviones (descripcion,peso) values (?,?)";/*ORden SQL*/
		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, av.getDescripcion());
			ps.setDouble(2, av.getPeso());
			ps.executeUpdate();
			ps.close();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	public Avion read(int idavion){
		Avion av = null;
		String sql = "select * from aviones where idavion=?";
		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1,idavion);
			ResultSet rs = ps.executeQuery();/*Recoge el dato de la consulta*/
			if(rs.next()){
				av=new Avion(rs.getInt("idavion"),rs.getString("descripcion"),rs.getDouble("peso"));
			}
			rs.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			
		}
		return av;
	}
	public boolean update(Avion av){
		String sql = "update aviones set descripcion=?,peso=?" + " where idavion=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, av.getDescripcion());
			ps.setDouble(2, av.getPeso());
			ps.setInt(3, av.getIdavion());
			ps.executeUpdate();
			ps.close();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	public boolean delete(int idavion){
		String sql="delete from aviones where  idavion=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idavion);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	public ArrayList<Avion> listar(){
		ArrayList<Avion> aviones = new ArrayList<Avion>();
		
		String sql="select * from aviones order by idavion";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			/*No necesito poner parámetros porque no hay parámetros*/
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Avion av = new Avion(rs.getInt("idavion"),rs.getString("descripcion"),rs.getDouble("peso"));
				aviones.add(av);/*Añado al ArrayList*/
			}
			rs.close();
		}	
		
		catch(SQLException sqle){
			sqle.printStackTrace();
			
		}
		
		return aviones;
	}
}
