package practica2;

public class Localidad {
	
	String nombre;
	int habitantes;
	int codPostal;
	
	public Localidad(String nombre, int habitantes, int codPostal) {
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.codPostal = codPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + ", habitantes=" + habitantes + ", codPostal=" + codPostal + "]";
	}
	
	

}
