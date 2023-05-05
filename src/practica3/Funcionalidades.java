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

import practica2.Alcalde;

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
	 * METODO QUE REALIZA SUBMENU CONSULTA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return int - DEVUELVE OPCION DE SUBMENU CONSULTA SELECCIONADO.
	 * @version 1.1.1
	 */
	public static int procesoConsulta(Scanner entrada) {
		
		int opcionMenuConsulta = 0;
		boolean busquedaValida = false;
		
		//PEDIREMOS UNA OPCION DE MENU HASTA QUE SEA VALIDO EL DATO INTRODUCIDO.
		do {
			try {
				//LLAMADA AL METODO PARA MOSTRAR MENU DE CONSULTA
				mostrarMenuConsulta();
				opcionMenuConsulta = entrada.nextInt();
				entrada.nextLine(); 
				
				if (opcionMenuConsulta >= 1 && opcionMenuConsulta <=7) {
					busquedaValida = true;
				}
				
			}catch(InputMismatchException e){
				System.out.println("***************************************************");
				System.out.println("* LA OPCION DEBE SER NUMERICA. INTENTELO DE NUEVO *");
				System.out.println("***************************************************");
				
				entrada.nextLine();
			}
			
		}while(!busquedaValida);
		
		return opcionMenuConsulta;
	}
	
	/** 
	 * METODO QUE DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE O NO EL NOMBRE DEL ALCALDE
	 * @author Luis Martin Portillo.
	 * @param nombre - NOMBRE ALCALDE A BUSCAR.
	 * @return boolean - DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE NOMBRE.
	 * @version 1.1.1
	 */
	public static boolean existeAlcalde (String nombre) {
		
		//CONEXION BBDD.
		Connection conexion = conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL
		ResultSet rs  = null;
		boolean encontrado = false;
		
		try {
			 //ALMACENO EL RESULTADO DE LA SELECT EN UN RESULTSET
			 rs = sentenciaSQL.executeQuery("SELECT * FROM alcaldes WHERE nombre = '" + nombre +"';");
		     
			 //PREGUNTO POR EL PRIMER REGISTRO DEVUELTO
		     while(rs.next()) {
		       //SI HAY RESULTADO MUESTRO VALOR Y BOOLEANO ENCONTRADO A TRUE. 
		        System.out.println(rs.getString(1) + " - " + rs.getString(2)+ " - " + rs.getString(3) + " - " + rs.getString(4)+ 
		        " - " + rs.getString(5));
		    
		        encontrado = true;
		     }
		     
		} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("Error");
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return encontrado;
	}
	
	/** 
	 * METODO QUE DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE O NO ALCALDE DE UNA LOCALIDAD
	 * @author Luis Martin Portillo.
	 * @param localidad - NOMBRE LOCALIDAD A BUSCAR.
	 * @return boolean - DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE LOCALIDAD.
	 * @version 1.1.1
	 */
	public static boolean existeLocalidad (String localidad) {
		
		//CONEXION BBDD.
		Connection conexion = conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL.
		ResultSet rs  = null;
		boolean encontrado = false;
		
		try {
			//ALMACENO EL RESULTADO DE LA SELECT EN UN RESULTSET
			 rs = sentenciaSQL.executeQuery("SELECT * FROM alcaldes WHERE localidad = '" + localidad +"';");
			//PREGUNTO POR EL PRIMER REGISTRO DEVUELTO
		     while(rs.next()) {
		    	//SI HAY RESULTADO MUESTRO VALOR Y BOOLEANO ENCONTRADO A TRUE. 
		        System.out.println(rs.getString(1) + " - " + rs.getString(2)+ " - " + rs.getString(3) + " - " + 
		    	rs.getString(4)+ " - " + rs.getString(5));
		        encontrado = true;
		     }
		     
		} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("Error");
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return encontrado;
	}
		
	/** 
	 * METODO QUE ESTABLECE CONEXION CON LA BBDD
	 * @author Luis Martin Portillo.
	 * @return Connection - DEVUELVE LA CONEXION ESTABLECIDA CON LA BASE DE DATOS.
	 * @version 1.1.1
	 */
	public static Connection conexionBD() {
		Connection conexion = null;
		
		try {
			
		//CONEXION CON BBDD
		 Class.forName("com.mysql.jdbc.Driver");
		 conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica3",
				"root", "");// DIRECCION, ADMINISTRADOR Y PASSWORD.
		
		 } catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				System.out.println("Error");
		}
	
		return conexion;
			 
	}
	
	/** 
	 * METODO QUE GENERA LA DECLARACION DE SENTENCIA SQL.
	 * @author Luis Martin Portillo.
	 * @param conexion - CONEXION CON BBDD.
	 * @return Statement - DEVUELVE LA DECLARACION DE SENTENCIA SQL.
	 * @version 1.1.1
	 */
	public static Statement statementBD(Connection conexion) {
		
		Statement sentenciaSQL=null;
		
		try {
		 //CREACION DE SENTENCIAS SQL
		 sentenciaSQL = conexion.createStatement();
		 } catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("Error");
		}
	
		return sentenciaSQL;
			 
	}
	
	/** 
	 * METODO QUE DA DE ALTA UN ALCALDE EN LA BASE DE DATOS.
	 * @author Luis Martin Portillo.
	 * @param entrada - OBJETO DE LA CLASE SCANNER.
	 * @version 1.1.1
	 */
	public static void altaAlcalde(Scanner entrada) {
		
		int edadAux, poblacionAux,codPostalAux,rs;
		String localidadAux;
		
		//CONEXION BBDD.
		Connection conexion = conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		
        //SE PIDE NOMBRE Y SE COMPRUEBA CON EL METODO EXISTE ALCALDE.
		String nombreAux = pedirNombre(entrada);
		
		if (existeAlcalde(nombreAux)) {
			System.out.println("***********************************");
			System.out.println("* YA EXISTE ALCALDE CON ESE NOMBRE*");
			System.out.println("***********************************");
		}else {
			
		     edadAux = pedirEdad(entrada);
		     
		     // SI ALCALDE VALIDO, PEDIMOS LOCALIDAD
		     localidadAux = pedirLocalidad(entrada);
		     
		     if (existeLocalidad(localidadAux)) {
		    	 System.out.println("***************************************************************");
		    	 System.out.println("* LA LOCALIDAD " + localidadAux + " YA ES GOBERNADA POR OTRO ALCALDE");
		    	 System.out.println("***************************************************************");
		     }else {
		    	 
		    	 // SI LOCALIDAD VALIDA PEDIMOS POBLACION Y COD.POSTAL
		    	 poblacionAux = pedirPoblacion(entrada);
			     codPostalAux = pedirCodPostal(entrada);
			     
			     try {
			    	 
			    	 //SENTENCIA SQL
			    	 String sentencia = "INSERT INTO alcaldes (nombre,edad,localidad,poblacion,codPostal)"
			    	 		+ " VALUES ('" + nombreAux + "',"+ edadAux + ",'"+localidadAux+"',"+poblacionAux+","+codPostalAux+");";
			    	 rs = sentenciaSQL.executeUpdate(sentencia);
			    	 
			    	 //SI SE DEVUELVE 1 -> CORRECTO.
			    	 if (rs == 1) {
			    		 System.out.println("**************************************");
						 System.out.println("* ALCALDE DADO DE ALTA CORRECTAMENTE *");
						 System.out.println("**************************************");
			    	 }else {
			    		 System.out.println("**************************************");
						 System.out.println("* ERROR AL DAR DE ALTA = " + rs);
						 System.out.println("**************************************");
			    	 }
			    	 
			     }catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
			     }
		     }
	    }
		
		try {
			conexion.close();
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		
	}
	
	/** 
	 * METODO QUE PIDE EL NOMBRE DEL ALCALDE Y LO DEVUELVE COMO STRING
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
	
	/** 
	 * METODO QUE PIDE LA EDAD DEL ALCALDE Y LO DEVUELVE COMO INT.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return int - DEVUELVE LA EDAD QUE INTRODUCE USUARIO POR PANTALLA.
	 * @version 1.1.1
	 */
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
	 * METODO QUE PIDE LA LOCALIDAD DEL ALCALDE Y DEVUELVE EL STRING.
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
	 * METODO QUE PUDE LA POBLACION DE UNA LOCALIDAD Y DEVUELVE EL INT.
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
	 * METODO QUE PIDE EL COD. POSTAL DE LA LOCALIDAD Y DEVUELVE EL INT.
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
	
	/** 
	 * METODO QUE BUSCA POR NOMBRE INTRODUCIDO POR PANTALLA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @version 1.1.1
	 */
	public static void buscarPorNombre(Scanner entrada) {
		
		String nombreAux;
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		// RESULTADO SENTENCIA SQL.
		ResultSet rs;
		
		System.out.println("BUSQUEDA POR NOMBRE DE ALCALDE...");
		System.out.println("¿QUE ALCALDE QUIERES BUSCAR?");
		
		nombreAux = entrada.nextLine();
		
		//COMPROBAMOS QUE EXISTA
		if (existeAlcalde(nombreAux)) {
			
			 try {
				 //SENTENCIA SQL
		    	 String sentencia = "SELECT * FROM alcaldes WHERE (nombre = '" + nombreAux + "');";
		    	 rs = sentenciaSQL.executeQuery(sentencia);
		    	 
		    	 //MOSTRAMOS RESULTADOS EN CASO DE QUE HAYA
		    	 while(rs.next()) {
		    		 System.out.println("**********************************************");
		    		 System.out.println("* NOMBRE ALCALDE: " + rs.getString(2));
		    		 System.out.println("* EDAD ALCALDE: " + rs.getInt(3));
		    		 System.out.println("* LOCALIDAD ALCALDE: " + rs.getString(4));
		    		 System.out.println("* POBLACION: " + rs.getInt(5));
		    		 System.out.println("* COD.POSTAL: " + rs.getInt(6));
		    		 System.out.println("**********************************************");
		    	 }
		     }catch(SQLException ex) {
				ex.printStackTrace();
				System.out.println("Error");
		    	 
		     }finally {
		    	 try {
					conexion.close();
				 } catch (SQLException e) {
					e.printStackTrace();
				 }
		     }
		}else{
			System.out.println("*****************************************");
			System.out.println("*        ALCALDE NO ENCONTRADO          *");
			System.out.println("*****************************************");
		};
	}
	
	/** 
	 * METODO QUE BUSCA POR EDAD INTRODUCIDA POR PANTALLA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @version 1.1.1
	 */
	public static void buscarPorEdad(Scanner entrada) {
		
		int edadAux;
		int contador = 0;
		
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL.
		ResultSet rs;
		
		System.out.println("BUSQUEDA POR EDAD DE ALCALDE...");
		System.out.println("¿QUE EDAD QUIERES BUSCAR?");
		
		edadAux = entrada.nextInt();
		entrada.nextLine();
			
	    try {
	       //SENTENCIA SQL.
		   String sentencia = "SELECT * FROM alcaldes WHERE (edad = " + edadAux + ");";
		   rs = sentenciaSQL.executeQuery(sentencia);
		   
		   //MOSTRAMOS LOS RESULTADOS SI LOS HAY.
		   while(rs.next()) {
			   System.out.println("**********************************************");
			   System.out.println("* NOMBRE ALCALDE: " + rs.getString(2));
			   System.out.println("* EDAD ALCALDE: " + rs.getInt(3));
			   System.out.println("* LOCALIDAD ALCALDE: " + rs.getString(4));
			   System.out.println("* POBLACION: " + rs.getInt(5));
			   System.out.println("* COD.POSTAL: " + rs.getInt(6));
			   System.out.println("**********************************************");
			   contador ++;
		   }
		   
		   if (contador == 0) {
			   System.out.println("************************************");
			   System.out.println("* NO EXISTEN ALCALDES CON ESA EDAD *");
			   System.out.println("************************************");
		   }
		   
		 }catch(SQLException ex) {
		     ex.printStackTrace();
		     System.out.println("Error");
		    	 
		 }finally {
		      try {
				 conexion.close();
			  } catch (SQLException e) {
					
				 e.printStackTrace();
			  }
		  }

	}
	
	/** 
	 * METODO QUE BUSCA POR LOCALIDAD INTRODUCIDA POR PANTALLA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @version 1.1.1
	 */
	public static void buscarPorLocalidad(Scanner entrada) {
		
		String localidadAux;
		int contador = 0;
	
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL.
		ResultSet rs;
		
		System.out.println("BUSQUEDA POR LOCALIDAD DE ALCALDE...");
		System.out.println("¿QUE LOCALIDAD QUIERES BUSCAR?");
		
		localidadAux = entrada.nextLine();
			
	    try {
	       //SENTENCIA SQL
		   String sentencia = "SELECT * FROM alcaldes WHERE (localidad = '" + localidadAux + "');";
		   rs = sentenciaSQL.executeQuery(sentencia);
		   
		   //MOSTRAMOS RESULTADOS SI LOS HAY.
		   while(rs.next()) {
			   System.out.println("**********************************************");
			   System.out.println("* NOMBRE ALCALDE: " + rs.getString(2));
			   System.out.println("* EDAD ALCALDE: " + rs.getInt(3));
			   System.out.println("* LOCALIDAD ALCALDE: " + rs.getString(4));
			   System.out.println("* POBLACION: " + rs.getInt(5));
			   System.out.println("* COD.POSTAL: " + rs.getInt(6));
			   System.out.println("**********************************************");
			   contador ++;
		   }
		   
		   if (contador == 0) {
			   System.out.println("*****************************************");
			   System.out.println("* NO EXISTEN ALCALDES CON ESA LOCALIDAD *");
			   System.out.println("*****************************************");
		   }
		   
		 }catch(SQLException ex) {
		     ex.printStackTrace();
		     System.out.println("Error");
		    	 
		 }finally {
		      try {
				 conexion.close();
			  } catch (SQLException e) {
					
				 e.printStackTrace();
			  }
		  }

	}
	
	/** 
	 * METODO QUE CALCULA LA MEDIA DE EDAD DE LOS ALCALDES.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void calcularMedia() {
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL.
		ResultSet rs;
		
		double sumatorio = 0;
		double media = 0;
		double mediaRedondeada = 0;
		int contador = 0;
		
		try {
			   //SENTENCIA SQL.
			   String sentencia = "SELECT * FROM alcaldes;";
			   rs = sentenciaSQL.executeQuery(sentencia);
			   
			   //ACUMULAMOS POR CADA REGISTRO DEVUELTO EL VALOR DE LA EDAD EN SUMATORIO Y SUMAMOS 1 AL CONTADOR DE RESULTADOS.
			   while(rs.next()) {
				   sumatorio = sumatorio + rs.getInt(3);
				   contador ++;
			   }
			   
			   //SI SE ENCUANTRAN DATOS MAYORES QUE 0 SE REALIZA LA DIVISION Y SE REDONDEA.
			   if (sumatorio>0 && contador>0) {
				   media = sumatorio/contador;
				   
				   mediaRedondeada = Math.round(media * 100.0)/100.0;
			   }
			   
			   if (contador == 0) {
				   System.out.println("*****************************************");
				   System.out.println("*         NO EXISTEN ALCALDES           *");
				   System.out.println("*****************************************");
			   }else {
				   System.out.println("********************************************" );
				   System.out.println("* LA MEDIA DE EDAD ES DE " + mediaRedondeada + " AÑOS." );
				   System.out.println("********************************************" );
			   }
			   
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
			    	 
		}finally {
			try {
			    conexion.close();
	        } catch (SQLException e) {
						
			    e.printStackTrace();
		    }
	    }
	}
	
	/** 
	 * METODO QUE CONSULTA TODO EL CONTENIDO DE LA TABLA DE ALCALDES.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void consultarTodo() {
		
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL.
		ResultSet rs;
		
		int contador = 0;
		
		try {
			   //SENTENCIA SQL.
			   String sentencia = "SELECT * FROM alcaldes;";
			   rs = sentenciaSQL.executeQuery(sentencia);
			   
			   //MOSTRAMOS LOS RESULTADOS SI LOS HAY.
			   while(rs.next()) {
				   System.out.println("**********************************************");
				   System.out.println("* NOMBRE ALCALDE: " + rs.getString(2));
				   System.out.println("* EDAD ALCALDE: " + rs.getInt(3));
				   System.out.println("* LOCALIDAD ALCALDE: " + rs.getString(4));
				   System.out.println("* POBLACION: " + rs.getInt(5));
				   System.out.println("* COD.POSTAL: " + rs.getInt(6));
				   System.out.println("**********************************************");
				   contador ++;
			   }
			   
			   if (contador>0) {
				   System.out.println("**********************************************");
				   System.out.println("* TOTAL DE ALCALDES GUARDADOS = " + contador);
				   System.out.println("**********************************************");
			   }else {
				   System.out.println("*****************************************");
				   System.out.println("*         NO EXISTEN ALCALDES           *");
				   System.out.println("*****************************************");
			   }
			   
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
			    	 
		}finally {
			try {
			    conexion.close();
	        } catch (SQLException e) {
						
			    e.printStackTrace();
		    }
	    }
	}
	
	/** 
	 * METODO QUE ORDENA POR EDAD LA TABLA DE ALCALDES.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void ordenarPorEdad() {
		
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL
		ResultSet rs;
		
		int contador = 0;
		
		try {
			   //SENTENCIA SQL.
			   String sentencia = "SELECT * FROM alcaldes ORDER BY edad ASC;";
			   rs = sentenciaSQL.executeQuery(sentencia);
			   //MOSTRAMOS RESULTADO SI HAY DATOS DEVUELTOS.
			   while(rs.next()) {
				   System.out.println("**********************************************");
				   System.out.println("* NOMBRE ALCALDE: " + rs.getString(2));
				   System.out.println("* EDAD ALCALDE: " + rs.getInt(3));
				   System.out.println("* LOCALIDAD ALCALDE: " + rs.getString(4));
				   System.out.println("* POBLACION: " + rs.getInt(5));
				   System.out.println("* COD.POSTAL: " + rs.getInt(6));
				   System.out.println("**********************************************");
				   contador ++;
			   }
			   
			   if (contador>0) {
				   System.out.println("**********************************************");
				   System.out.println("* TOTAL DE ALCALDES ORDENADOS = " + contador);
				   System.out.println("**********************************************");
			   }else {
				   System.out.println("*****************************************");
				   System.out.println("*         NO EXISTEN ALCALDES           *");
				   System.out.println("*****************************************");
			   }
			   
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
			    	 
		}finally {
			try {
			    conexion.close();
	        } catch (SQLException e) {
						
			    e.printStackTrace();
		    }
	    }
	}	
	
	/** 
	 * METODO QUE CONSULTA TODAS LAS LOCALIDADES QUE TIENEN ALCALDE REGISTRADO.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void consultarLocalidades() {
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL.
		ResultSet rs;
		
		int contador = 0;
		
		try {
			   //SENTENCIA SQL.
			   String sentencia = "SELECT * FROM alcaldes;";
			   rs = sentenciaSQL.executeQuery(sentencia);
			   
			   //MOSTRAMOS RESULTADOS SI HAY.
			   while(rs.next()) {
				   System.out.println("**********************************************");
				   System.out.println("* NOMBRE LOCALIDAD: " + rs.getString(4));
				   System.out.println("* POBLACION: " + rs.getInt(5));
				   System.out.println("* COD.POSTAL: " + rs.getInt(6));
				   System.out.println("* ------------------------------");
				   System.out.println("* EL NOMBRE DE SU ALCALDE ES -> " + rs.getString(2));
				   System.out.println("**********************************************");
				   contador ++;
			   }
			   
			   if (contador>0) {
				   System.out.println("**********************************************");
				   System.out.println("* TOTAL DE LOCALIDADES CON ALCALDE = " + contador);
				   System.out.println("**********************************************");
			   }else {
				   System.out.println("*****************************************");
				   System.out.println("*         NO EXISTEN ALCALDES           *");
				   System.out.println("*****************************************");
			   }
			   
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
			    	 
		}finally {
			try {
			    conexion.close();
	        } catch (SQLException e) {	
			    e.printStackTrace();
		    }
	    }
	}
	
	/** 
	 * METODO PARA MODIFICAR DATOS DE LA TABLA ALCALDES.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @version 1.1.1
	 */
	public static void modificarRegistro(Scanner entrada) {
		//CONEXION BBDD.
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO SENTENCIA SQL (INT POR UPDATE)
		int rs;
		
		int opcionAux = 0;
		boolean funcionValida = false;
		String nombreAux,localidadAux;
		int edadAux, poblacionAux, codPostalAux;
		
		//PEDIMOS OPCION HASTA QUE NO SEA VALIDA.
		do {
			try {
				
				System.out.println("**************************************");
				System.out.println("*         ¿QUE DESEA MODIFICAR?      *");
				System.out.println("**************************************");
				System.out.println("* 1- EDAD DEL ALCALDE.               *");
				System.out.println("* 2- LOCALIDAD.                      *");
				System.out.println("* 3- POBLACION.                      *");
				System.out.println("* 4- CODIGO POSTAL.                  *");
				System.out.println("**************************************");
				
				opcionAux = entrada.nextInt();
				entrada.nextLine(); 
				
				if (opcionAux >= 1 && opcionAux <=4) {
					funcionValida = true;
				}else {
					System.out.println("***************************************************");
					System.out.println("*     LA OPCION NO ES VALIDA. PRUEBE CON 1/2      *");
					System.out.println("***************************************************");
				}
				
			}catch(InputMismatchException e){
				System.out.println("***************************************************");
				System.out.println("* LA OPCION DEBE SER NUMERICA. INTENTELO DE NUEVO *");
				System.out.println("***************************************************");
				
				entrada.nextLine();
			}
			
		}while(!funcionValida);
		
		System.out.println("*********************************************");
		System.out.println("*     ¿CUAL ES EL NOMBRE DEL ALCALDE?       *");
		System.out.println("*********************************************");
		
		nombreAux = entrada.nextLine();
		
		//SI NO EXISTE ALCALDE NO SE PUEDE MODIFICAR.
		if (!existeAlcalde(nombreAux)) {
			System.out.println("*********************************************");
			System.out.println("*  NO EXISTE ALCALDE. NO SE PUEDE MODIFICAR *");
			System.out.println("*********************************************");
		}else {
			switch(opcionAux){
			case 1:
				System.out.println("***************************************");
				System.out.println("*       ¿CUAL ES LA NUEVA EDAD?       *");
				System.out.println("***************************************");
				
				edadAux = pedirEdad(entrada);
				
				try {
					//SENTENCIA SQL.
					String sentencia = "UPDATE alcaldes SET edad = " + edadAux + " WHERE nombre = '" + nombreAux + "';";
					rs = sentenciaSQL.executeUpdate(sentencia);
					
					//SI SENTENCIA NOS DEVUELVE 1 -> CORRECTO.
					if (rs == 1) {
						System.out.println("***************************************");
						System.out.println("*   EDAD ACTUALIZADA CORRECTAMENTE    *");
						System.out.println("***************************************");
					}else {
						System.out.println("***************************************");
						System.out.println("*       ERROR AL MODIFICAR EDAD       *");
						System.out.println("***************************************");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
				}
				break;
			case 2:
				System.out.println("********************************************");
				System.out.println("*       ¿CUAL ES LA NUEVA LOCALIDAD?       *");
				System.out.println("********************************************");
				
				localidadAux = pedirLocalidad(entrada);
				
				try {
					//SENTENCIA SQL.
					String sentencia = "UPDATE alcaldes SET localidad = '" + localidadAux + "' WHERE nombre = '" + nombreAux + "';";
					rs = sentenciaSQL.executeUpdate(sentencia);
					
					//SI SENTENCIA DEVUELVE 1 -> CORRECTO.
					if (rs == 1) {
						System.out.println("*******************************************************");
						System.out.println("*   LOCALIDAD DE ALCALDE ACTUALIZADA CORRECTAMENTE    *");
						System.out.println("*******************************************************");
					}else {
						System.out.println("********************************************");
						System.out.println("*       ERROR AL MODIFICAR LOCALIDAD       *");
						System.out.println("********************************************");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
				}
				
				break;
			case 3:
				System.out.println("********************************************");
				System.out.println("*       ¿CUAL ES LA NUEVA POBLACION?       *");
				System.out.println("********************************************");
				
				poblacionAux = pedirPoblacion(entrada);
				
				try {
					//SENTENCIA SQL.
					String sentencia = "UPDATE alcaldes SET poblacion = " + poblacionAux + " WHERE nombre = '" + nombreAux + "';";
					rs = sentenciaSQL.executeUpdate(sentencia);
					
					//SI SENTENCIA DEVUELVE 1 -> CORRECTO.
					if (rs == 1) {
						System.out.println("*********************************************");
						System.out.println("*    POBLACION ACTUALIZADA CORRECTAMENTE    *");
						System.out.println("*********************************************");
					}else {
						System.out.println("********************************************");
						System.out.println("*       ERROR AL MODIFICAR POBLACION       *");
						System.out.println("********************************************");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
				}
				
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("*       ¿CUAL ES LA NUEVO COD.POSTAL?       *");
				System.out.println("*********************************************");
				
				codPostalAux = entrada.nextInt();
				entrada.nextLine();
				
				try {
					//SENTENCIA SQL.
					String sentencia = "UPDATE alcaldes SET codPostal = " + codPostalAux + " WHERE nombre = '" + nombreAux + "';";
					rs = sentenciaSQL.executeUpdate(sentencia);
					
					//SI SENTENCIA DEVUELVE 1 -> CORRECTO.
					if (rs == 1) {
						System.out.println("**********************************************");
						System.out.println("*    COD.POSTAL ACTUALIZADO CORRECTAMENTE    *");
						System.out.println("**********************************************");
					}else {
						System.out.println("*********************************************");
						System.out.println("*       ERROR AL MODIFICAR COD.POSTAL       *");
						System.out.println("*********************************************");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
				}
				
				break;
			default:
				System.out.println("****************************");
				System.out.println("*     OPCION NO VALIDA     *");
				System.out.println("****************************");
			}
		}
		
	}
	
	/** 
	 * METODO PARA ELIMINAR REGISTROS DE LA TABLA ALCALDES.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @version 1.1.1
	 */
	public static void eliminarRegistro(Scanner entrada) {
		
		int opcionAux = 0;
		boolean funcionValida = false;
		String nombreAux,localidadAux;
		
		//CONEXION BBDD
		Connection conexion= conexionBD();
		//SENTENCIA SQL.
		Statement sentenciaSQL = statementBD(conexion);
		//RESULTADO DELETE
		int rs;
		
		//PEDIMOS OPCION HASTA QUE NO SEA VALIDA.
		do {
			try {
				
				System.out.println("*************************************");
				System.out.println("* ¿POR QUE ATRIBUTO DESEA ELIMINAR? *");
				System.out.println("* 1- NOMBRE ALCALDE.                *");
				System.out.println("* 2- NOMBRE LOCALIDAD.              *");
				System.out.println("*************************************");
				
				opcionAux = entrada.nextInt();
				entrada.nextLine(); 
				
				if (opcionAux >= 1 && opcionAux <=2) {
					funcionValida = true;
				}else {
					System.out.println("***************************************************");
					System.out.println("*     LA OPCION NO ES VALIDA. PRUEBE CON 1/2      *");
					System.out.println("***************************************************");
				}
				
			}catch(InputMismatchException e){
				System.out.println("***************************************************");
				System.out.println("* LA OPCION DEBE SER NUMERICA. INTENTELO DE NUEVO *");
				System.out.println("***************************************************");
				
				entrada.nextLine();
			}
			
		}while(!funcionValida);
		
		if(opcionAux == 1) {
			
			System.out.println("*********************************************************");
			System.out.println("*         ¿CUAL ES NOMBRE DEL ALCALDE A ELIMINAR?       *");
			System.out.println("*********************************************************");
			
			nombreAux = entrada.nextLine();
			
			//SI EXISTE ALCALDE PODEMOS ELIMINAR, SI NO NO.
			if (existeAlcalde(nombreAux)) {
				try {
					//SENTENCIA SQL.
					String sentencia = "DELETE FROM alcaldes WHERE nombre = '" + nombreAux + "';";
					rs = sentenciaSQL.executeUpdate(sentencia);

					//SI SENTENCIA SQL DEVUELVE 1 -> CORRECTO.
					if (rs == 1) {
						System.out.println("**********************************************");
						System.out.println("*         REGISTRO BORRADO CORRECTAMENTE     *");
						System.out.println("**********************************************");
					}else {
						System.out.println("**********************************************");
						System.out.println("*          ERROR AL ELIMINAR REGISTRO        *");
						System.out.println("**********************************************");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
				}
			}else {
				System.out.println("********************************************************************");
				System.out.println("*     NO EXISTE REGISTRO CON ESE NOMBRE. NO SE PUEDE ELIMINAR      *");
				System.out.println("********************************************************************");
			}				
			
		}else {
			
			System.out.println("***************************************************************");
			System.out.println("*     ¿EL ALCALDE DE QUE LOCALIDAD QUIERES ELIMINAR?          *");
			System.out.println("***************************************************************");
			
			localidadAux = entrada.nextLine();
			
			//SI EXISTE LOCALIDAD PODEMOS ELIMINAR, SI NO NO.
			if (existeLocalidad(localidadAux)) {
				try {
					//SENTENCIA SQL.
					String sentencia = "DELETE FROM alcaldes WHERE localidad = '" + localidadAux + "'; ";
					rs = sentenciaSQL.executeUpdate(sentencia);
					
					//SI SENTENCIA DEVUELVE 1 -> CORRECTO.
					if (rs == 1) {
						System.out.println("**********************************************");
						System.out.println("*         REGISTRO BORRADO CORRECTAMENTE     *");
						System.out.println("**********************************************");
					}else {
						System.out.println("**********************************************");
						System.out.println("*          ERROR AL ELIMINAR REGISTRO        *");
						System.out.println("**********************************************");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Error");
				}
			}else {
				System.out.println("********************************************************************");
				System.out.println("*     NO EXISTE REGISTRO CON ESA LOCALIDAD. NO SE PUEDE ELIMINAR   *");
				System.out.println("********************************************************************");
			}
			
		}
		
	}
	
	/** 
	 * METODO FIN DE LA APP.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void finApp() {
		System.out.println("**********************************************");
		System.out.println("*    GRACIAS POR UTILIZAR LA APLICACION :)   *");
		System.out.println("**********************************************");
	}
	
}