package practica2;

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
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return int - DEVUELVE EDAD QUE INTRODUCE USUARIO POR PANTALLA.
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
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return String - DEVUELVE EL NOMBRE DE LOCALIDAD QUE INTRODUCE USUARIO POR PANTALLA.
	 * @version 1.1.1
	 */
	
	public static String pedirNombreLocalidad(Scanner entrada) {
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
	
	/** 
	 * @author Luis Martin Portillo.
	 * @param listaAlcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @param nombre - NOMBRE ALCALDE.
	 * @param edad - EDAD ALCALDE.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @return ArrayList - DEVUELVE ARRAYLIST DESPUES DEL ALTA.
	 * @version 1.1.1
	 */
	public static boolean altaAlcalde(ArrayList<Alcalde> listaAlcaldes, String nombre, int edad, Scanner entrada){
		
		boolean encontradoLocalidad = false;
		boolean encontradoAlcalde = false;
		Localidad localidad;
		Alcalde alcaldeNuevo;
		String nombreLocalidad = "";
		boolean altaCorrecta = false;
		
		encontradoAlcalde = existeAlcalde(listaAlcaldes, nombre);
		
		if (!encontradoAlcalde) {
			nombreLocalidad = pedirNombreLocalidad(entrada);
			encontradoLocalidad = existeLocalidad(listaAlcaldes,nombreLocalidad);
			
			if (!encontradoLocalidad) {
				
				localidad = altaLocalidad(entrada,nombreLocalidad);
				alcaldeNuevo = new Alcalde(nombre, edad, localidad);
				
				listaAlcaldes.add(alcaldeNuevo);
				altaCorrecta = true;
				
			}
		}else {
			System.out.println("**************************************");
			System.out.println("* YA ESXISTE ALCALDE CON ESE NOMBRE. *");
			System.out.println("**************************************");
		}
		
		return altaCorrecta;
	}
	
	/** 
	 * METODO QUE DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE O NO EL NOMBRE EN EL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param listaAlcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @param nombre - NOMBRE ALCALDE A BUSCAR.
	 * @return boolean - DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE NOMBRE.
	 * @version 1.1.1
	 */
	public static boolean existeAlcalde (ArrayList<Alcalde> listaAlcaldes, String nombre) {
		boolean encontradoAlcalde = false;
		
		for(Alcalde alcaldeRecorrido : listaAlcaldes) {
			if(alcaldeRecorrido.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("* EL ALCALDE YA EXISTE *");
				encontradoAlcalde = true;
			}
		}
		
		return encontradoAlcalde;
	}
	
	/** 
	 * METODO QUE DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE O NO EL NOMBRE DE LA LOCALIDAD EN EL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param listaAlcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @param nombreLocalidad - NOMBRE LOCALIDAD A BUSCAR.
	 * @return boolean - DEVUELVE TRUE/FALSE EN FUNCION DE SI EXISTE NOMBRE DE LA LOCALIDAD.
	 * @version 1.1.1
	 */
	public static boolean existeLocalidad(ArrayList<Alcalde> listaAlcaldes,String nombreLocalidad) {
		boolean encontradoLocalidad = false;
		
		for (Alcalde alcalde : listaAlcaldes) {
			
			if (alcalde.getLocalidad().getNombre().equalsIgnoreCase(nombreLocalidad)) {
				System.out.println("* LA LOCALIDIDAD YA ES GOBERNADA POR EL ALCALDE " + alcalde.getNombre() + " *");
				encontradoLocalidad = true;
			}
		}
		
		return encontradoLocalidad;
	}
	
	/** 
	 * METODO QUE DEVUELVE OBJETO DE LA CLASE LOCALIDAD AL SER DADA DE ALTA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @param nombreLocalidad - NOMBRE LOCALIDAD A DAR DE ALTA.
	 * @return Localidad - DEVUELVE OBJETO DE LA CLASE LOCALIDAD AL SER DADA DE ALTA.
	 * @version 1.1.1
	 */
	public static Localidad altaLocalidad(Scanner entrada, String nombreLocalidad) {
		Localidad localidad;
		int poblacion,codPostal;
		
		poblacion = pedirPoblacion(entrada);
		codPostal = pedirCodPostal(entrada);
		localidad = new Localidad(nombreLocalidad, poblacion, codPostal);
		
		return localidad;
	}
	
	/** 
	 * METODO QUE DEVUELVE UN ALCALDE BUSCADO.
	 * @author Luis Martin Portillo.
	 * @param listaAlcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @param nombre - NOMBRE ALCALDE A BUSCAR.
	 * @return Alcalde - DEVUELVE OBJETO DE LA CLASE ALCALDE BUSCADO. SI NO EXISTE -> VACIO.
	 * @version 1.1.1
	 */	
	public static Alcalde buscarPorNombreAlcalde (ArrayList<Alcalde> listaAlcaldes, String nombre) {
		
		Alcalde salida = null;
		
		for (Alcalde alcaldeX : listaAlcaldes) {
			
			if(alcaldeX.getNombre().equalsIgnoreCase(nombre)) {
				salida = alcaldeX;
			}
		}
		
		return salida;
		
	}
	
	/** 
	 * METODO QUE BUSCA POR NOMBRE INTRODUCIDO POR PANTALLA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void buscarPorNombreMenu(Scanner entrada, ArrayList<Alcalde> alcaldes) {
		
		String nombreAux;
		
		System.out.println("BUSQUEDA POR NOMBRE DE ALCALDE...");
		System.out.println("¿QUE ALCALDE QUIERES BUSCAR?");
		
		nombreAux = entrada.nextLine();
		Alcalde buscado = buscarPorNombreAlcalde(alcaldes,nombreAux);
		
		if (buscado != null) {
			System.out.println("*********************************************");
			System.out.println("* LOS DATOS DEL ALCALDE SON LOS SIGUIENTES: *");
			System.out.println("* NOMBRE: " +  buscado.getNombre());
			System.out.println("* EDAD:   " + buscado.getEdad());
			System.out.println("* LOCALIDAD: " + buscado.getLocalidad().getNombre());
			System.out.println("* POBLACION: " + buscado.getLocalidad().getHabitantes());
			System.out.println("* COD.POSTAL: " + buscado.getLocalidad().getCodPostal());
			System.out.println("*********************************************");
		}else{
			System.out.println("*****************************************");
			System.out.println("*        ALCALDE NO ENCONTRADO          *");
			System.out.println("*****************************************");
		};
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
		
		do {
			try {
				
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
	 * METODO ORDENA ELEMENTOS ARRAYLIST ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param listaAlcaldes - ARRAYLIST DE LA CLASE ALCALDE A ORDENAR.
	 * @version 1.1.1
	 */
	public static void ordenarAlcaldesPorEdad (ArrayList<Alcalde> listaAlcaldes) {
		
		listaAlcaldes.sort(Comparator.comparing(Alcalde::getEdad));	
		
		for (Alcalde alcaldeX : listaAlcaldes) {
			System.out.println(alcaldeX.toString());
		}
	}
	
	/** 
	 * METODO QUE REALIZA SUBMENU CONSULTA POR EDAD.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void buscarPorEdadMenu(Scanner entrada, ArrayList<Alcalde> alcaldes) {
		
		int edadAux;
		ArrayList<Alcalde> arraySalida = new ArrayList<Alcalde>();
		
		System.out.println("BUSQUEDA POR EDAD DE ALCALDE...");
		System.out.println("¿QUE EDAD QUIERES BUSCAR?");
		
		edadAux = entrada.nextInt();
		entrada.nextLine();
		
		for(Alcalde alcaldeX : alcaldes) {
			if (alcaldeX.getEdad() == edadAux) {
				arraySalida.add(alcaldeX);
			}
		}
		
		
		if (arraySalida.size() == 0) {
			System.out.println("***************************************************");
			System.out.println("*          NO HAY ALCALDES CON ESA EDAD           *");
			System.out.println("***************************************************");
		}else {
			for(Alcalde alcaldeX : arraySalida) {
				System.out.println(alcaldeX.toString());
			}
		}
		
	}
	
	/** 
	 * METODO QUE REALIZA SUBMENU CONSULTA POR LOCALIDAD.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void buscarPorLocalidadMenu(Scanner entrada, ArrayList<Alcalde> alcaldes) {
		
	    String localidadAux;
	    ArrayList<Alcalde> arraySalida = new ArrayList<Alcalde>();
		
		System.out.println("BUSQUEDA POR LOCALIDAD DE ALCALDE...");
		System.out.println("¿QUE LOCALIDAD QUIERES BUSCAR?");
		
		localidadAux = entrada.nextLine();
		
		for(Alcalde alcaldeX : alcaldes) {
			if (alcaldeX.getLocalidad().getNombre().equalsIgnoreCase(localidadAux)) {
				arraySalida.add(alcaldeX);
			}
		}
		
		
		if (arraySalida.size() == 0) {
			System.out.println("***************************************************");
			System.out.println("*        NO HAY ALCALDE EN ESA LOCALIDAD          *");
			System.out.println("***************************************************");
		}else {
			for(Alcalde alcaldeX : arraySalida) {
				System.out.println(alcaldeX.toString());
			}
		}
		
	}
	
	/** 
	 * METODO QUE DEVUELVE LA MEDIA DE EDAD DEL ARRAYLIST ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @return double - MEDIA ARRAYLIST ENTRADA.
	 * @version 1.1.1
	 */
	public static double calcularMedia(ArrayList<Alcalde> alcaldes) {
		
		double cociente =0;
		double divisor = 0;
		double resultado = 0;
		
		for (Alcalde alcaldeX : alcaldes) {
			cociente = cociente + alcaldeX.getEdad();
			divisor++;
		}
		
		if (cociente > 0 && divisor > 0) {
			resultado = cociente/divisor;
		}
		
		return resultado;
	}
	
	/** 
	 * METODO QUE DEVUELVE TODOS LOS ELEMENTOS DEL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void mostrarTodo(ArrayList<Alcalde> alcaldes) {
		
		for (Alcalde alcaldeX : alcaldes) {
			System.out.println(alcaldeX.toString());
		}
		
		if (alcaldes.size() == 0) {
			System.out.println("***************************************************");
			System.out.println("*           NO HAY ALCALDES GUARDADOS             *");
			System.out.println("***************************************************");
		}
		
	}
	
	/** 
	 * METODO QUE ELIMINA REGISTRO INTRODUCIDO POR PANTALLA DEL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void eliminarRegistro(Scanner entrada, ArrayList<Alcalde> alcaldes) {
		
		int opcionAux = 0;
		String nombreAux,localidadAux;
		boolean funcionValida = false;
		int contador = 0;
		int contadorAux = 0;
		boolean registroEncontrado = false;
		
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
			
			System.out.println("*************************************");
			System.out.println("*         ¿CUAL ES SU NOMBRE?       *");
			System.out.println("*************************************");
			
			nombreAux = entrada.nextLine();
			
			for (Alcalde alcaldeX : alcaldes) {
				if (alcaldeX.getNombre().equalsIgnoreCase(nombreAux)) {
					
					contadorAux = contador;
					registroEncontrado = true;
				};
				contador++;
			}
			
			if (!registroEncontrado) {
				System.out.println("******************************************************");
				System.out.println("*    NO EXISTE REGISTRO CON ESE NOMBRE DE ALCALDE    *");
				System.out.println("******************************************************");
			}else {
				alcaldes.remove(contadorAux);
				System.out.println("*************************************************************************");
				System.out.println("*         REGISTRO CON ALCALDE LLAMADO " + nombreAux + " BORRADO CORRECTAMENTE       *");
				System.out.println("*************************************************************************");
			}
			
		}else {
			
			System.out.println("*************************************");
			System.out.println("*          ¿QUE LOCALIDAD?          *");
			System.out.println("*************************************");
			
			localidadAux = entrada.nextLine();
			
			for (Alcalde alcaldeX : alcaldes) {
				
				if (alcaldeX.getLocalidad().getNombre().equalsIgnoreCase(localidadAux)) {
					
					contadorAux = contador;
					registroEncontrado = true;
				};
				contador++;
			}
			
			if (!registroEncontrado) {
				System.out.println("******************************************************");
				System.out.println("*         NO EXISTE REGISTRO CON ESA LOCALIDAD       *");
				System.out.println("******************************************************");
			}else{
				alcaldes.remove(contadorAux);
				System.out.println("*************************************************************************");
				System.out.println("*         REGISTRO CON LOCALIDAD " + localidadAux + " BORRADO CORRECTAMENTE       *");
				System.out.println("*************************************************************************");
			}
			
		}
	    
	}
	
	/** 
	 * METODO QUE MODIFICA REGISTRO INTRODUCIDO POR PANTALLA DEL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param entrada - CLASE SCANNER PARA LEER DATOS POR PANTALLA.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void modificarRegistro(Scanner entrada, ArrayList<Alcalde> alcaldes) {
		
		int opcionAux = 0;
		String nombreAux,localidadAux;
		boolean funcionValida = false;
		int contador = 0;
		boolean registroEncontrado = false;
		
		do {
			try {
				
				System.out.println("**************************************");
				System.out.println("*         ¿QUE DESEA MODIFICAR?      *");
				System.out.println("* 1- EDAD DEL ALCALDE.               *");
				System.out.println("* 2- POBLACION LOCALIDAD.            *");
				System.out.println("**************************************");
				
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
			
			System.out.println("*************************************");
			System.out.println("*         ¿CUAL ES EL NOMBRE?       *");
			System.out.println("*************************************");
			
			nombreAux = entrada.nextLine();
			
			do {
				for (Alcalde alcaldeX : alcaldes) {
					if (alcaldeX.getNombre().equalsIgnoreCase(nombreAux)) {
						
						alcaldes.get(contador).setEdad(pedirEdad(entrada));
						registroEncontrado = true;
					};
					contador++;
				}
				
			}while(!registroEncontrado && contador<alcaldes.size());
			
			if (!registroEncontrado) {
				System.out.println("******************************************************");
				System.out.println("*    NO EXISTE REGISTRO CON ESE NOMBRE DE ALCALDE    *");
				System.out.println("******************************************************");
			}
		
		}else {
			System.out.println("*************************************");
			System.out.println("*      ¿CUAL ES LA LOCALIDAD?       *");
			System.out.println("*************************************");
			
			localidadAux = entrada.nextLine();
			
			do {
				for (Alcalde alcaldeX : alcaldes) {
					if (alcaldeX.getLocalidad().getNombre().equalsIgnoreCase(localidadAux)) {
						
						alcaldes.get(contador).getLocalidad().setHabitantes(pedirPoblacion(entrada));
						registroEncontrado = true;
					};
					contador++;
				}
				
			}while(!registroEncontrado && contador<alcaldes.size());
			
			if (!registroEncontrado) {
				System.out.println("******************************************************");
				System.out.println("*           NO EXISTE REGISTRO CON LOCALIDAD         *");
				System.out.println("******************************************************");
			}
			
		}
	}
	
	/** 
	 * METODO QUE MUESTRA TODOS LAS LOCALIDADES DEL ARRAYLIST DE ENTRADA.
	 * @author Luis Martin Portillo.
	 * @param alcaldes - ARRAYLIST DE LA CLASE ALCALDE.
	 * @version 1.1.1
	 */
	public static void mostrarLocalidades(ArrayList<Alcalde> alcaldes) {
		
		for (Alcalde alcaldeX : alcaldes) {
			System.out.println(alcaldeX.getLocalidad().toString());
		}
		
	}
	
	/** 
	 * METODO QUE MUESTRA MENSAJE FINAL DEL PROGRAMA.
	 * @author Luis Martin Portillo.
	 * @version 1.1.1
	 */
	public static void finalizarApp() {
		
		System.out.println("*********************************************");
		System.out.println("*                                           *");
		System.out.println("*     GRACIAS POR USAR LA APLICACIÓN :)     *");
		System.out.println("*                                           *");
		System.out.println("*********************************************");
	}
	
}
