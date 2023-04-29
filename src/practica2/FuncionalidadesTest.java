package practica2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */
class FuncionalidadesTest {

	/** 
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	Scanner entrada = new Scanner(System.in);
	
	/** 
	 * METODO PRUEBA PEDIR EDAD
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testPedirEdad() {
		
		int resultado = Funcionalidades.pedirEdad(entrada);
		assertTrue (resultado != 0);
	}
	
	/** 
	 * METODO PRUEBA PEDIR NOMBRE
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testPedirNombre() {
		
		String resultado = Funcionalidades.pedirNombre(entrada);
		assertTrue (resultado != null);
	}
	
	/** 
	 * METODO PRUEBA PEDIR LOCALIDAD
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testPedirNombreLocalidad() {
		
		String resultado = Funcionalidades.pedirNombreLocalidad(entrada);
		assertTrue (resultado != null);
	}
	
	/** 
	 * METODO PRUEBA PEDIR POBLACION
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testPedirPoblacion() {
		
		int resultado = Funcionalidades.pedirPoblacion(entrada);
		assertTrue (resultado > 0);
	}
	
	/** 
	 * METODO PRUEBA PEDIR COD.POSTAL
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testPedirCodigoPostal() {
		
		int resultado = Funcionalidades.pedirCodPostal(entrada);
		assertTrue (resultado > 0);
	}
	
	/** 
	 * METODO PRUEBA ALTA ALCALDE
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testaltaAlcalde() {
		
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		String nombre = "Luis Perez";
		int edad = 26;
		
		boolean resultado = Funcionalidades.altaAlcalde(alcaldes,nombre,edad,entrada);
		
		assertTrue (resultado == true);
	}
	
	/** 
	 * METODO PRUEBA EXISTE ALCALDE
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testExisteAlcalde() {
		
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		Localidad localidad = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcalde1 = new Alcalde("Luis Martin",26,localidad);
		
		alcaldes.add(alcalde1);
		String nombre = "Luis Martin";
		
		boolean resultado = Funcionalidades.existeAlcalde(alcaldes,nombre);
		
		assertTrue (resultado == true);
	}
	
	/** 
	 * METODO PRUEBA EXISTE LOCALIDAD
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testExisteLocalidad() {
		
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		Localidad localidad = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcalde1 = new Alcalde("Luis Martin",26,localidad);
		
		alcaldes.add(alcalde1);
		String localidadAux = "Navalcarnero";
		
		boolean resultado = Funcionalidades.existeLocalidad(alcaldes,localidadAux);
		
		assertTrue (resultado == true);
	}
	
	/** 
	 * METODO PRUEBA ALTA LOCALIDAD
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testAltaLocalidad() {
		
		String localidadAux = "Navalcarnero";
		
		Localidad resultado = Funcionalidades.altaLocalidad(entrada,localidadAux);
		
		assertTrue (resultado.getNombre() == localidadAux);
	}

	/** 
	 * METODO PRUEBA BUSCAR POR NOMBRE ALCALDE
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testBuscarXNombreAlcalde() {
		
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		Localidad localidad = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcaldeAux = new Alcalde("Luis Martin",26,localidad);
		alcaldes.add(alcaldeAux);
		
		Alcalde resultado = Funcionalidades.buscarPorNombreAlcalde(alcaldes,"Luis Martin");
		
		Assert.assertNotNull(resultado);
		
	}
	
	/** 
	 * METODO PRUEBA CONSULTA
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testProcesoConsulta() {
		
		int resultado = Funcionalidades.procesoConsulta(entrada);
		
		assertTrue (resultado !=0);
	}
	
	/** 
	 * METODO PRUEBA CALCULO MEDIA
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testCalcularMedia() {
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		Localidad localidad1 = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcalde1 = new Alcalde("Luis Martin",26,localidad1);
		
		Localidad localidad2 = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcalde2 = new Alcalde("Luis Martin",28,localidad2);
		
		Localidad localidad3 = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcalde3 = new Alcalde("Luis Martin",30,localidad3);
		
		alcaldes.add(alcalde1);
		alcaldes.add(alcalde2);
		alcaldes.add(alcalde3);
		
		double resultado = Funcionalidades.calcularMedia(alcaldes);
		
		assertTrue (resultado == 28);
	}
}
