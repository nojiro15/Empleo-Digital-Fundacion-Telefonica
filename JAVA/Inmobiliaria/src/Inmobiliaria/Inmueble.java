package Inmobiliaria;

public abstract class Inmueble implements ConPropietario {
		protected double superficie;
		protected boolean edificable;
		protected String direccion;
		protected String propietario;
		/**
		 * Constructores.
		 */
		public Inmueble(){
			
		}
		public Inmueble(double superficie, boolean edificable, String direccion, String propietario){
			this.superficie = superficie;
			this.edificable= edificable;
			this.direccion = direccion;
			this.propietario = propietario;
			
		}
		public Inmueble(Inmueble inmueble){
			superficie=inmueble.superficie;
			edificable = inmueble.edificable;
			direccion = inmueble.direccion;
			
		}
		/**
		 * Getters & Setters.
		 * @return
		 */
		public double getSuperficie() {
			return superficie;
		}
		public void setSuperficie(double superficie) {
			this.superficie = superficie;
		}
		public boolean isEdificable() {
			return edificable;
		}
		public void setEdificable(boolean edificable) {
			this.edificable = edificable;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		public String getPropietario() {
			return propietario;
		}
		public void setPropietario(String propietario) {
			this.propietario = propietario;
		}
		/**
		 * toString.
		 */
		public String toString(){
			return "\nSuperficie (m^2): " + superficie + "\nEdificable: "+ ((edificable==true)?"Si" : "No")+ "\nDirección: " + direccion + "\nPropietario: " + propietario;
		}
		public boolean equals(Object obj){
			 if(obj == null){
				 	return false;
				 }
				 if(this == obj){
				  	return true;
				  }
				  else if(!(obj instanceof Inmueble)){
				  	return false;
				  }
				  else{
				  	Inmueble inmueble = (Inmueble)obj;
				  	return superficie==inmueble.superficie && edificable==inmueble.edificable && direccion.equals(inmueble.direccion) ;
				  }
		}
		/**
		 * Creamos una serie de métodos abstractos: getTipoIva y getPrecio.
		 * Las declaramos abstractas puesto de los precios están en las subclase Venta o Alquiler.
		 * El método getPrecioTotal() llama a los otros dos para ser calculado.
		 * 
		 * @return
		 */
		public abstract double getTipoIva();
		public abstract double getPrecio();
		public double getPrecioTotal(){
			
			return getTipoIva()+100 * getPrecio()/100;/*También puede calcularse así: getTipoIva() * getPrecio()/100+getPrecio();*/
		}
		
		public abstract void setPrecio(double precio);
		
}
