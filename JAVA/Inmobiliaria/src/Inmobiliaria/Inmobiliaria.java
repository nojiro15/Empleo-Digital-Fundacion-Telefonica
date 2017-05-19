package Inmobiliaria;

public class Inmobiliaria implements ConPropietario {
		/**
		 * Propiedades
		 */
		private int pos = 0;
		private Inmueble [] arrInmu = new Inmueble[500];
		private String propietario;
		
	/**
	 * Métodos
	 */
		/**
		 * Constructores
		 * @param inmu
		 */
		public Inmobiliaria(){
			
		}
		public Inmobiliaria(String propietario){
			this.propietario = propietario;
		}
	public void add(Inmueble inmu){
		if(pos<500){
			
			arrInmu[pos]= inmu;
			pos++;
		}
		else{System.out.println("El array está lleno.");}
		
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public Inmueble getInmueble(int i){
		
		return arrInmu[i];
	}
	/*Si quisiera acotar getInmueble
	 * public boolean add(Inmueble inmu){
	 * if(pos<500){
	 * 	inmuebles[pos] = inmu;
	 * 	pos++;
	 * return true;
	 * }
	 * public boolean esLLeno(){
	 * return pos==500;
	 * }
	 * */
	public int size(){
		
		return pos;
	}
	public boolean esLLeno(){
		 return pos==500;
	}
	@Override
	public String toString(){
		String s= "\nEl propietario de la inmobiliaria es: "+ propietario +"\n\nEsta inmoviliaria tiene " + pos + " inmuebles y son:\n ";
		for(int i = 0; i<pos;i++){
			s = s + arrInmu[i].toString();/*Para los array existe un método predefinido toString*/
		}
		
		return  s;
	}
	
}
