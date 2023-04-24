package practica2;

/**
 * CLASE ALCALDE.
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */
public class Alcalde {
	
	private String nombre;
	private int edad;
	private Localidad localidad;
	
	/** 
	 * METODO CONSTRUCTOR DE LA CLASE.
	 * @author Luis Martin Portillo.
	 * @param nombre - NOMBRE DEL ALCALDE.
	 * @param edad - EDAD DEL ALCALDE.
	 * @param localidad - OBJETO CLASE LOCALIDAD DEL ALCALDE.
	 * @version 1.1.1
	 */
	public Alcalde(String nombre, int edad, Localidad localidad) {
		this.nombre = nombre;
		this.edad = edad;
		this.localidad = localidad;
	}
	
	/** 
	 * METODO GET DEL NOMBRE.
	 * @author Luis Martin Portillo.
	 * @return String - NOMBRE ALCALDE.
	 * @version 1.1.1
	 */
	public String getNombre() {
		return nombre;
	}
	
	/** 
	 * METODO SET DEL NOMBRE.
	 * @author Luis Martin Portillo.
	 * @param nombre - NOMBRE DEL ALCALDE.
	 * @version 1.1.1
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/** 
	 * METODO GET DE LA EDAD.
	 * @author Luis Martin Portillo.
	 * @return int - EDAD ALCALDE.
	 * @version 1.1.1
	 */
	public int getEdad() {
		return edad;
	}
	
	/** 
	 * METODO SET DE LA EDAD.
	 * @author Luis Martin Portillo.
	 * @param edad - EDAD DEL ALCALDE.
	 * @version 1.1.1
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/** 
	 * METODO GET DE LA LOCALIDAD.
	 * @author Luis Martin Portillo.
	 * @return Localidad - LOCALIDAD ALCALDE.
	 * @version 1.1.1
	 */
	public Localidad getLocalidad() {
		return localidad;
	}
	
	/** 
	 * METODO SET DE LA LOCALIDAD.
	 * @author Luis Martin Portillo.
	 * @param localidad - LOCALIDAD DEL ALCALDE.
	 * @version 1.1.1
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/** 
	 * METODO TOSTRING DE ALCALDE.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Override
	public String toString() {
		return "Alcalde [nombre=" + nombre + ", edad=" + edad + ", localidad=" + localidad + "]";
	}
	
	
	
}
