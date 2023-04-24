package practica2;

/**
 * CLASE LOCALIDAD.
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */
public class Localidad {
	
	private String nombre;
	private int habitantes;
	private int codPostal;
	
	/** 
	 * METODO CONSTRUCTOR DE LA CLASE.
	 * @author Luis Martin Portillo.
	 * @param nombre - NOMBRE DE LA LOCALIDAD.
	 * @param habitantes - POBLACION LOCALIDAD.
	 * @param codPostal - COD. POSTAL LOCALIDAD.
	 * @version 1.1.1
	 */
	public Localidad(String nombre, int habitantes, int codPostal) {
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.codPostal = codPostal;
	}

	/** 
	 * METODO GET DEL NOMBRE.
	 * @author Luis Martin Portillo.
	 * @return String - NOMBRE LOCALIDAD.
	 * @version 1.1.1
	 */
	public String getNombre() {
		return nombre;
	}

	/** 
	 * METODO SET DEL NOMBRE.
	 * @author Luis Martin Portillo.
	 * @param nombre - NOMBRE DE LA LOCALIDAD.
	 * @version 1.1.1
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** 
	 * METODO GET DEL NUMERO DE HABITANTES.
	 * @author Luis Martin Portillo.
	 * @return int - HABITANTES LOCALIDAD.
	 * @version 1.1.1
	 */
	public int getHabitantes() {
		return habitantes;
	}

	/** 
	 * METODO SET DEL NUMERO DE HABITANTES.
	 * @author Luis Martin Portillo.
	 * @param habitantes - POBLACION DE LA LOCALIDAD.
	 * @version 1.1.1
	 */
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	/** 
	 * METODO GET DEL CODIGO POSTAL.
	 * @author Luis Martin Portillo.
	 * @return int - CODIGO POSTAL LOCALIDAD.
	 * @version 1.1.1
	 */
	public int getCodPostal() {
		return codPostal;
	}

	/** 
	 * METODO SET DEL CODIGO POSTAL.
	 * @author Luis Martin Portillo.
	 * @param codPostal - CODIGO POSTAL DE LA LOCALIDAD.
	 * @version 1.1.1
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	/** 
	 * METODO TOSTRING DE LA LOCALIDAD.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + ", habitantes=" + habitantes + ", codPostal=" + codPostal + "]";
	}
	
	

}
