package models;

public class Viaje {
		/**
		 * Propiedades
		 */
		private int id;
		private String destino;
		private int duracion;
		private float precio;
		
		/**
		 * Constructores
		 */
		public Viaje(){
			
		}
		public Viaje(int id, String destino, int duracion, float precio){
			this.id=id;
			this.destino=destino;
			this.duracion=duracion;
			this.precio=precio;
		}
		/**
		 * Getter 6 Setter
		 * @return
		 */
		public int getId() {
			return id;
		}
		
		public String getDestino() {
			return destino;
		}
		public void setDestino(String destino) {
			this.destino = destino;
		}
		public int getDuracion() {
			return duracion;
		}
		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}
		public float getPrecio() {
			return precio;
		}
		public void setPrecio(float precio) {
			this.precio = precio;
		}
		
}
