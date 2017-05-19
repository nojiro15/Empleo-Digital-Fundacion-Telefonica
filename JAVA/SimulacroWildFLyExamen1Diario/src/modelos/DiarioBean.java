package modelos;

import java.io.Serializable;
import java.util.Date;

public class DiarioBean implements Serializable{
	
	/**
	 * Propiedades
	 */
	private static final long serialVersionUID=1L;
	private int id;
	private String nombre;
	private Date fecha;
	private String texto;
	
	/**
	 * Constructores
	 */
	public DiarioBean(){
		
	}
	public DiarioBean(int id,String nombre,Date fecha, String texto){
		this.id=id;
		this.nombre=nombre;
		this.fecha=fecha;
		this.texto=texto;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
