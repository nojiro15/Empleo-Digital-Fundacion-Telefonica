package Inmobiliaria;

public class InmuebleEnAlquiler extends Inmueble{
	
	private double precioAlquiler;
	
	/**
	 * Constructores
	 */
	public InmuebleEnAlquiler(){
		
	}
	public InmuebleEnAlquiler(double superficie, boolean edificable, String direccion,String propietario, double precioAlquiler){
		super(superficie,edificable,direccion,propietario);
		this.precioAlquiler=precioAlquiler;
	}
	public InmuebleEnAlquiler(InmuebleEnAlquiler inmAlquiler){
		super(inmAlquiler);
		precioAlquiler = inmAlquiler.precioAlquiler;
		
	}
	/**
	 * Getter & Setter
	 */
	
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	public double getPrecio(){
		
		return precioAlquiler;
	}
	/**
	 * Puesto que hay dos métodos abstractos, es necesario definir los métodos
	 * de la clase padre.
	 */
	public double getTipoIva(){
		
		return 0;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	@Override
	public String toString(){
		return "\n\nSuperficie (m^2): " + superficie + "\nEdificable: "+ ((edificable==true)?"Si" : "No")+ "\nDirección: " + direccion+ "\nPropietario del Inmueble: " + propietario + "\nPrecio de Alquiler: " + precioAlquiler;
	}

	
	@Override
	public void setPrecio(double precio){
		
		precioAlquiler = precio;
		
	}
	
}
