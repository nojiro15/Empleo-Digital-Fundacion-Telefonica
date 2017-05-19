package Inmobiliaria;

public class InmuebleEnVenta extends Inmueble{
		private double precioVenta;
		
		/**
		 * Constructores.
		 */
		public InmuebleEnVenta(){
			
		}
		public InmuebleEnVenta(double superficie, boolean edificable, String direccion,String propietario, double precioVenta){
			super(superficie,edificable,direccion,propietario);
			this.precioVenta=precioVenta;
			
		}
		public InmuebleEnVenta(InmuebleEnVenta inmVenta){
			super(inmVenta);/* Es lo mismo que lo de abajo*/
			/*superficie=inmVenta.superficie;
			edificable = inmVenta.edificable;
			direccion = inmVenta.direccion;*/
			precioVenta = inmVenta.precioVenta;
		}
		
		public double getPrecioVenta() {
			return precioVenta;
		}
		public void setPrecioVenta(double precioVenta) {
			this.precioVenta = precioVenta;
		}
		/**
		 * Puesto que hay dos métodos abstractos, es necesario definir los métodos
		 * de la clase padre.
		 */
		public double getTipoIva(){
			
			return 10;/*Para los inmuebles es el 10%*/
		}
		public double getPrecio(){
			
			return precioVenta;
		}
		@Override
		public String toString(){
			return "\n\nSuperficie (m^2): " + superficie + "\nEdificable: "+ ((edificable==true)?"Si" : "No")+ "\nDirección: " + direccion+ "\nPropietario del Inmueble: " + propietario + "\nPrecio de Venta: " + precioVenta;
		}
		
		@Override
		public void setPrecio(double precio){
			
			precioVenta = precio;
			
		}
}
