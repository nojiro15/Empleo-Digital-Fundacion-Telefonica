package modelos;

public class Avion {
		/**
		 * Propiedades
		 */
		private int idavion;
		private String descripcion;
		private double peso;
		
		/**
		 * Constructores
		 */
		
		public Avion(){
			
		}
		public Avion(int idavion,String descripcion, double peso){/*Como en la BBDD idavion es autoincremental
		 										no es necesario incorporarlo en el constructor*/
			this.idavion = 	idavion;
			this.descripcion = descripcion;
			this.peso = peso;
		}
		public Avion(Avion av){
			
			idavion=av.idavion;
			descripcion= av.descripcion;
			peso = av.peso;
		}
		
		
		/**
		 * Getter & Setter
		 */
		public int getIdavion() {
			return idavion;
		}
		public void setIdavion(int idavion) {
			this.idavion = idavion;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			this.peso = peso;
		}
		/**
		 * Método toString
		 */
		@Override
		public String toString(){
			return "\nIdentificador avion: " + idavion +" Descripcion: " +descripcion+" Peso: "+peso;
		}
}
