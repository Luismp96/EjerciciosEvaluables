package practica3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */

public class Funcionalidades {

	
	/** 
	 * METODO QUE MUESTRA MENU
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void mostrarMenu() {
		
		System.out.println("*************************************************************");
		System.out.println("**************************** MENU ***************************");
		System.out.println("*************************************************************");
		System.out.println("*****     1 - AÑADIR NUEVO ALCALDE.                     *****");
		System.out.println("*****     2 - REALIZAR CONSULTAS.                       *****");
		System.out.println("*****     3 - MODIFICAR POR ALCALDE/LOCALIDAD.          *****");
		System.out.println("*****     4 - ELIMINAR REGISTRO POR ALCALDE/LOCALIDAD.  *****");
		System.out.println("*****     5 - SALIR.                                    *****");
		System.out.println("*************************************************************");
		
	}
	
	/** 
	 * METODO QUE MUESTRA MENU DE CONSULTA
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	*/
	public static void mostrarMenuConsulta() {
		
		System.out.println("********************************************");
		System.out.println("*             ¿QUE DESEA HACER?            *");
		System.out.println("*      1 - BUSCAR POR NOMBRE ALCALDE.      *");
		System.out.println("*      2 - BUSCAR POR EDAD ALCALDE.        *");
		System.out.println("*      3 - BUSCAR POR LOCALIDAD.           *");
		System.out.println("*      4 - MEDIA EDAD ALCALDES.            *");
		System.out.println("*      5 - ALCALDES ORDENADOS POR EDAD.    *");
		System.out.println("*      6 - CONSULTAR LISTA ALCALDES Y      *");
		System.out.println("*          POBLACION DONDE GOBIERNA.       *");
		System.out.println("*      7 - CONSULTA LOCALIDADES.           *");
		System.out.println("********************************************");
		
	}
	
	/** 
	 * METODO QUE DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE O NO EL NOMBRE EN EL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param listaAlcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @param nombre - NOMBRE ALCALDE A BUSCAR.
	 * @return boolean - DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE NOMBRE.
	 * @version 1.1.1
	 */
	public static boolean existeAlcalde (String nombre) {
		
		Connection conexion = conexionBD();
		Statement sentenciaSQL = statementBD(conexion);
		ResultSet rs  = null;
		
		boolean encontrado = false;
		
		try {
			
			 //almaceno el resultado de la sql en un resulset (conjunto de registros)
			 rs = sentenciaSQL.executeQuery("SELECT * FROM alcaldes WHERE nombre = " + nombre);
		     // chequeo que el result set no sea vacío, moviendo el cursor a la 
		     // primer fila. (El cursor inicia antes de la primer fila)
		     while(rs.next()) {
		       //Si hay resultados obtengo el valor. 
		        System.out.println(rs.getString(1) + " - " + rs.getString(2)+ " - " + rs.getString(3) + " - " + rs.getString(4));
		        encontrado = true;
		     }
		     
		     
		} catch (SQLException ex) {
				ex.printStackTrace();
				//System.out.println("Error");
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return encontrado;
	}
		
	public static Connection conexionBD() {
		Connection conexion = null;
		
		try {
			
		//conectar con la base de datos
			System.out.println("Hola2");
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Hola");
		 conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica3",
				"root", "");// proporcionamos la dirección, el administrador y la clave
		 System.out.println("Holaa");
		 System.out.println(conexion);

		
		 } catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				//System.out.println("Error");
		}
	
		return conexion;
			 
	}
	
	public static Statement statementBD(Connection conexion) {
		
		Statement sentenciaSQL=null;
		
		try {
		 //creamos sentencias ejecutables sobre esa conexión
		 sentenciaSQL = conexion.createStatement();
		 } catch (SQLException ex) {
				ex.printStackTrace();
				//System.out.println("Error");
		}
	
		return sentenciaSQL;
			 
	}
	
	public static void altaAlcalde(Scanner entrada) {
		
		int edadAux, poblacionAux,codPostalAux;
		String localidadAux;
		Connection conexion = conexionBD();
		Statement sentenciaSQL = statementBD(conexion);
		
		String nombreAux = pedirNombre(entrada);
		
		if (existeAlcalde(nombreAux)) {
			System.out.println("***********************************");
			System.out.println("* YA EXISTE ALCALDE CON ESE NOMBRE*");
			System.out.println("***********************************");
		}else {
			
		     edadAux = pedirEdad(entrada);
		     localidadAux = pedirLocalidad(entrada);
		     poblacionAux = pedirPoblacion(entrada);
		     codPostalAux = pedirCodPostal(entrada);
		     
		     try {
		    	 String sentencia = "INSERT INTO alcaldes (idAlcalde,nombre,edad,localidad,poblacion,codPostal)"
		    	 		+ " VALUES ('','" + nombreAux + "',"+ edadAux + ",'"+localidadAux+"',"+poblacionAux+","+codPostalAux+");";
		    	 sentenciaSQL.executeUpdate(sentencia);
		     }catch(SQLException ex) {
				ex.printStackTrace();
				//System.out.println("Error");
		    	 
		     }finally {
		    	 try {
					conexion.close();
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
		     }
	    }
		
	}
	
	/** 
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return String - DEVUELVE EL NOMBRE QUE INTRODUCE USUARIO POR PANTALLA.
	 * @version 1.1.1
	 */
	public static String pedirNombre(Scanner entrada) {
		String nombreAux = "";
		
		System.out.println("INTRODUZCA EL NOMBRE: ");
		nombreAux = entrada.nextLine();
		
		return nombreAux;
	}
	
	public static int pedirEdad(Scanner entrada) {
		int edadAux = 0;
		boolean edadValida = false;
		
		do {
			
			try {
				System.out.println("INTRODUZCA SU EDAD: ");
				edadAux = entrada.nextInt();
				entrada.nextLine(); 
			
				if (edadAux <=0) {
					System.out.println("* EDAD NO VALIDA. VUELVE A INTENTARLO. *");
				}else {
					edadValida = true;
				}
			}catch(InputMismatchException e) {
				System.out.println("* LA EDAD DEBE DE SER NUMERICA *");
				entrada.nextLine(); 
			}
			
		}while(!edadValida);
		
		
		return edadAux;
	}
	
	/** 
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return String - DEVUELVE EL NOMBRE DE LOCALIDAD QUE INTRODUCE USUARIO POR PANTALLA.
	 * @version 1.1.1
	 */
	
	public static String pedirLocalidad(Scanner entrada) {
		String nombreLocAux = "";
		
		System.out.println("INTRODUZCA EL NOMBRE DE LA LOCALIDAD: ");
		nombreLocAux = entrada.nextLine();
		
		return nombreLocAux;
	}
	
	/** 
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return int - DEVUELVE EL NUMERO DE HABITANTES QUE INTRODUCE USUARIO POR PANTALLA.
	 * @version 1.1.1
	 */
	public static int pedirPoblacion(Scanner entrada) {
		int poblacionAux = 0;
		boolean poblacionValida = false;
		
		do {
			
			try {
				System.out.println("INTRODUZCA POBLACION: ");
				poblacionAux = entrada.nextInt();
				entrada.nextLine(); 
			
				if (poblacionAux <=0) {
					System.out.println("* POBLACION NO VALIDA. VUELVE A INTENTARLO. *");
				}else {
					poblacionValida = true;
				}
			}catch(InputMismatchException e) {
				System.out.println("* LA POBLACION DEBE DE SER NUMERICA *");
				entrada.nextLine(); 
			}
			
		}while(!poblacionValida);
		
		
		return poblacionAux;
	}
	
	/** 
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return int - DEVUELVE EL COD.POSTAL QUE INTRODUCE USUARIO POR PANTALLA.
	 * @version 1.1.1
	 */
	public static int pedirCodPostal(Scanner entrada) {
		int codigoAux = 0;
		boolean codigoValida = false;
		
		do {
			
			try {
				System.out.println("INTRODUZCA EL CODIGO POSTAL: ");
				codigoAux = entrada.nextInt();
				entrada.nextLine(); 
			
				if (codigoAux <=0) {
					System.out.println("* CODIGO POSTAL NO VALIDO. VUELVE A INTENTARLO. *");
				}else {
					codigoValida = true;
				}
			}catch(InputMismatchException e) {
				System.out.println("* EL CODIGO POSTAL DEBE DE SER NUMERICA *");
				entrada.nextLine(); 
			}
			
		}while(!codigoValida);
		
		
		return codigoAux;
	}
	
}