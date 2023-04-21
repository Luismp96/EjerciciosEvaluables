package practica2;

public class Alcalde {
	
	private String nombre;
	private int edad;
	private Localidad localidad;
	
	public Alcalde(String nombre, int edad, Localidad localidad) {
		this.nombre = nombre;
		this.edad = edad;
		this.localidad = localidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Localidad getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Alcalde [nombre=" + nombre + ", edad=" + edad + ", localidad=" + localidad + "]";
	}
	
	
	
}
