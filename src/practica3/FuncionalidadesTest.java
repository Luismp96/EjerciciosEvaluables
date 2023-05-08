package practica3;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practica3.Funcionalidades;

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
	 * METODO PRUEBA PROCESO DE CONSULTA.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testProcesoConsulta() {
		
		int resultado = Funcionalidades.procesoConsulta(entrada);
		assertTrue (resultado >= 1 && resultado <=7);
	}
	
	/** 
	 * METODO PRUEBA METODO COMPROBACION EXISTE O NO ALCALDE.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testExisteAlcalde() {
		String nombreAux = "LUIS MARTIN";
		String nombreAux1 = "PEPITO FLORES";
		
		boolean resultado = Funcionalidades.existeAlcalde(nombreAux);
		boolean resultado1 = Funcionalidades.existeAlcalde(nombreAux1);
		
		assertTrue (resultado == true);
		assertTrue (resultado1 == false);
	}
	
	/** 
	 * METODO PRUEBA COMPROBACION EXISTE O NO LOCALIDAD.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testExisteLocalidad() {
		String localidadAux = "NAVALCARNERO";
		String localidadAux1 = "MALAGA";
		
		boolean resultado = Funcionalidades.existeLocalidad(localidadAux);
		boolean resultado1 = Funcionalidades.existeLocalidad(localidadAux1);
		
		assertTrue (resultado == true);
		assertTrue (resultado1 == false);
	}
	
	
	/** 
	 * METODO PRUEBA CONEXION BBDD.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testConexionBD() {
		
		Connection conexion = Funcionalidades.conexionBD();
		
		assertTrue (conexion != null);

	}
		
	/** 
	 * METODO PRUEBA SENTENCIA SQL.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testStatementBD() {
		
		Connection conexion = Funcionalidades.conexionBD();
		Statement statement = Funcionalidades.statementBD(conexion);
		
		assertTrue (statement != null);

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
	 * METODO PRUEBA PEDIR LOCALIDAD
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testPedirLocalidad() {
		
		String resultado = Funcionalidades.pedirLocalidad(entrada);
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
	void testPedirCodPostal() {
		
		int resultado = Funcionalidades.pedirCodPostal(entrada);
		assertTrue (resultado > 0);
	}
	
	/** 
	 * METODO PRUEBA PEDIR COD.POSTAL
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	@Test
	void testCalcularMedia() {
		
		double resultado1 = 45.0;
		double resultado2 = 46.0;

		assertTrue ((Funcionalidades.pedirCodPostal(entrada) > resultado1 )
				&& (Funcionalidades.pedirCodPostal(entrada) < resultado2));
	}

}
