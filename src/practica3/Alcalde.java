package practica3;

/**
 * CLASE ALCALDE.
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */
public class Alcalde {
	
	private int idAlcalde;
	private String nombre;
	private int edad;
	private String localidad;
	private int poblacion;
	private int codPostal;
	
	/** 
	 * METODO CONSTRUCTOR DE LA CLASE SIN PARAMETROS.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public Alcalde() {
	}

	/** 
	 * METODO CONSTRUCTOR DE LA CLASE.
	 * @author Luis Martin Portillo.
	 * @param idAlcalde - ID DEL ALCALDE.
	 * @param nombre - NOMBRE DEL ALCALDE.
	 * @param edad - EDAD DEL ALCALDE.
	 * @param localidad - LOCALIDAD DEL ALCALDE.
	 * @param poblacion - POBLACION DE LA CIUDAD DEL ALCALDE.
	 * @param codPostal - COD.POSTAL DE LA CIUDAD DEL ALCALDE.
	 * @version 1.1.1
	 */
	public Alcalde(int idAlcalde, String nombre, int edad, String localidad, int poblacion, int codPostal) {
		this.idAlcalde = idAlcalde;
		this.nombre = nombre;
		this.edad = edad;
		this.localidad = localidad;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
	}

	/** 
	 * METODO GET DEL ID.
	 * @author Luis Martin Portillo.
	 * @return int - ID DEL ALCALDE.
	 * @version 1.1.1
	 */
	public int getIdAlcalde() {
		return idAlcalde;
	}

	/** 
	 * METODO SET DEL ID.
	 * @author Luis Martin Portillo.
	 * @param idAlcalde - ID DEL ALCALDE.
	 * @version 1.1.1
	 */
	public void setIdAlcalde(int idAlcalde) {
		this.idAlcalde = idAlcalde;
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
	 * @return String - NOMBRE LOCALIDAD.
	 * @version 1.1.1
	 */
	public String getLocalicad() {
		return localidad;
	}

	/** 
	 * METODO SET DE LA LOCALIDAD.
	 * @author Luis Martin Portillo.
	 * @param localidad - LOCALIDAD DEL ALCALDE.
	 * @version 1.1.1
	 */
	public void setLocalicad(String localidad) {
		this.localidad = localidad;
	}

	/** 
	 * METODO GET DE LA POBLACION.
	 * @author Luis Martin Portillo.
	 * @return int - POBLACION.
	 * @version 1.1.1
	 */
	public int getPoblacion() {
		return poblacion;
	}

	/** 
	 * METODO SET DE LA POBLACION.
	 * @author Luis Martin Portillo.
	 * @param poblacion - POBLACION DE LA LOCALIDAD.
	 * @version 1.1.1
	 */
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	/** 
	 * METODO GET DEL COD.POSTAL.
	 * @author Luis Martin Portillo.
	 * @return int - COD.POSTAL.
	 * @version 1.1.1
	 */
	public int getCodPostal() {
		return codPostal;
	}

	/** 
	 * METODO SET DEL COD. POSTAL.
	 * @author Luis Martin Portillo.
	 * @param codPostal - COD POSTAL DE LA LOCALIDAD DEL ALCALDE.
	 * @version 1.1.1
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	/** 
	 * METODO TOSTRING DE ALCALDE.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Override
	public String toString() {
		return "Alcalde [idAlcalde=" + idAlcalde + ", nombre=" + nombre + ", edad=" + edad + ", localicad=" + localidad
				+ ", poblacion=" + poblacion + ", codPostal=" + codPostal + "]";
	}
	
	

}
