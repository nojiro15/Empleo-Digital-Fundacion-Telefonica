package Inmobiliaria;

public class PrincipalInmobiliaria {

	public static void main(String[] args) {
		/**
		 * Creamos tres Inmuebles en ventas.
		 */
		InmuebleEnVenta inmuVenta1 = new InmuebleEnVenta(245.45,true,"calle salamanca 7" ," Pepe de Miguel ",250.68);
		InmuebleEnVenta inmuVenta2 = new InmuebleEnVenta(325.66,false,"calle mirlo 34", "Manuel Gutierrez",420.68);
		InmuebleEnVenta inmuVenta3 = new InmuebleEnVenta(225.45,true,"calle madrid 13", " Ana Garrido",306.55);
		
		/**
		 * Creamos tres Inmuebles en alquiler.
		 */
		InmuebleEnAlquiler inmuAlqui1 = new InmuebleEnAlquiler(166.3,false,"calle barcelona 7","Francisco Lucero",150.68);
		InmuebleEnAlquiler inmuAlqui2 = new InmuebleEnAlquiler(60.55,false,"calle merida 23", "Elena Perez",50.33);
		InmuebleEnAlquiler inmuAlqui3 = new InmuebleEnAlquiler(200,true,"calle soria 41","Miriam Diaz",140.84);
		/**
		 * Creamos la inmobiliaria.
		 * Añadimos inmuebles.
		 */
		
		Inmobiliaria inmobiliaria1 = new Inmobiliaria("Pablo López");/*Creamos objeto inmobiliaria*/
		
		inmobiliaria1.add(inmuVenta1);
		inmobiliaria1.add(inmuVenta2);
		inmobiliaria1.add(inmuVenta3);
		
		inmobiliaria1.add(inmuAlqui1);
		inmobiliaria1.add(inmuAlqui2);
		inmobiliaria1.add(inmuAlqui3);
		
		/**
		 * Mostrar lo que contiene la inmobiliaria.
		 */
		
		System.out.println(inmobiliaria1);
		
		/**
		 * Para cambiar el precio.
		 */
		for(int i=0; i<inmobiliaria1.size();i++){
			Inmueble inmu = inmobiliaria1.getInmueble(i);
			double precio = inmu.getPrecio()+1.1;
			inmu.setPrecio(precio);
		}
		
		System.out.println(inmobiliaria1);
		
		/**
		 * Usamos el interface.
		 */
		ConPropietario cp1=inmobiliaria1;
		ConPropietario cp2 = inmuVenta1;
		
		cp1.setPropietario("Ana Mª Matute");
		cp2.setPropietario("Ángeles Díez");
		
		System.out.println(inmobiliaria1);
		
	}

}
