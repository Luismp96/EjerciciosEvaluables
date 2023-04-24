package practica2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FuncionalidadesTest {

	Scanner entrada = new Scanner(System.in);
	
	@Test
	void testPedirEdad() {
		
		int resultado = Funcionalidades.pedirEdad(entrada);
		assertTrue (resultado != 0);
	}
	
	@Test
	void testPedirNombre() {
		
		String resultado = Funcionalidades.pedirNombre(entrada);
		assertTrue (resultado != null);
	}
	
	@Test
	void testPedirNombreLocalidad() {
		
		String resultado = Funcionalidades.pedirNombreLocalidad(entrada);
		assertTrue (resultado != null);
	}
	
	@Test
	void testPedirPoblacion() {
		
		int resultado = Funcionalidades.pedirPoblacion(entrada);
		assertTrue (resultado > 0);
	}
	
	@Test
	void testPedirCodigoPostal() {
		
		int resultado = Funcionalidades.pedirCodPostal(entrada);
		assertTrue (resultado > 0);
	}
	
	@Test
	void testaltaAlcalde() {
		
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		String nombre = "Luis Perez";
		int edad = 26;
		
		boolean resultado = Funcionalidades.altaAlcalde(alcaldes,nombre,edad,entrada);
		
		assertTrue (resultado == true);
	}
	
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
	
	@Test
	void testAltaLocalidad() {
		
		String localidadAux = "Navalcarnero";
		
		Localidad resultado = Funcionalidades.altaLocalidad(entrada,localidadAux);
		
		assertTrue (resultado.getNombre() == localidadAux);
	}

	@Test
	void testBuscarXNombreAlcalde() {
		
		ArrayList<Alcalde> alcaldes = new ArrayList<Alcalde>();
		Localidad localidad = new Localidad("Navalcarnero",20000,28600);
		Alcalde alcaldeAux = new Alcalde("Luis Martin",26,localidad);
		alcaldes.add(alcaldeAux);
		
		Alcalde resultado = Funcionalidades.buscarPorNombreAlcalde(alcaldes,"Luis Martin");
		
		Assert.assertNotNull(resultado);
		
	}
	
	@Test
	void testProcesoConsulta() {
		
		int resultado = Funcionalidades.procesoConsulta(entrada);
		
		assertTrue (resultado !=0);
	}
	
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
