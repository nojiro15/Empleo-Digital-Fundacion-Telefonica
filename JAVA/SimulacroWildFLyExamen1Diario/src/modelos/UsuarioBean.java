package modelos;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UsuarioBean implements Serializable, HttpSessionBindingListener{
	private static final long serialVersionUID=1L;
	/**
	 * Propiedades
	 */
	private int id;
	private String nombre;
	
	/**
	 * Constructores
	 */
	public UsuarioBean(){
		
	}
	
	public UsuarioBean(int id, String nombre){
		this.id=id;
		this.nombre=nombre;
	}
	/**
	 * Getter & Setter
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
