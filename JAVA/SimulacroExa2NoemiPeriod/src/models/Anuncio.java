package models;

public class Anuncio {

	private int id;/*Debe llamarse como os campos de la tabla pero sin guión bajo, con CamelCase*/
	private String texto;
	
	public Anuncio(){
		
	}
	public Anuncio(int id,String texto){
		this.id=id;
		this.texto=texto;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
