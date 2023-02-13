package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica1{

	public static void main(String[] args) {
		
		String [] nombres = new String[20];
		int [] edades = new int[20];
		String[] localidades = new String[20];
		
		
		int opcionMenu,guardados,edadAux,filtroBusqueda,posicionEdad,posicionLocalidad,edadABuscar,posicionNombre,numeroGuardados,respuesta;
		String nombreAux,localidadAux,nombreABuscar,localidadABuscar,localidadAModificar,localidadAEliminar;
		boolean fin=false;
		
		boolean duplicadoNombre, duplicadaLocalidad;
		boolean finValidaciones;
		
		int i=0;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			System.out.println("*************************************************************");
			System.out.println("**************************** MENU ***************************");
			System.out.println("*************************************************************");
			System.out.println("*****     1 - AÑADIR ALCALDE/LOCALIDAD NUEVA.           *****");
			System.out.println("*****     2 - BUSCAR ALCALDE/EDAD/LOCALIDAD.            *****");
			System.out.println("*****     3 - MODIFICAR ALCALDE/EDAD.                   *****");
			System.out.println("*****     4 - ELIMINAR LOCALIDAD/ALCALDE.               *****");
			System.out.println("*****     5 - CONSULTAR LISTA ALCALDES Y POBLACION      *****");
			System.out.println("*****         DONDE GOBIERNA.                           *****");
			System.out.println("*****     6 - SALIR.                                    *****");
			System.out.println("*************************************************************");
			
			opcionMenu=entrada.nextInt();
			entrada.nextLine(); 
			
			switch(opcionMenu) {
				case 1:
					
					guardados = Funcionalidades.contarGuardados(nombres);	
					
					if (guardados < 20) {
						
						finValidaciones = false;
						duplicadoNombre = false;
						duplicadaLocalidad = false;
						
						do {
							System.out.println("NOMBRE DEL ALCADE A AÑADIR: ");
							nombreAux = entrada.nextLine();
							
							respuesta = Funcionalidades.buscarArrayString(nombreAux, nombres);
							
							if (respuesta != -1) {
								duplicadoNombre = true;
							}
							
							System.out.println("INTRODUZCA SU EDAD: ");
							edadAux = entrada.nextInt();
							entrada.nextLine(); 
							
							System.out.println("LOCALIDAD QUE GOBIERNA: ");
							localidadAux = entrada.nextLine();
							
							respuesta = Funcionalidades.buscarArrayString(localidadAux, localidades);
							
							if (respuesta != -1) {
								duplicadaLocalidad = true;
							}
							
							finValidaciones = true;
							
						}while(!duplicadoNombre && !finValidaciones && !duplicadaLocalidad);
						
						
						if (duplicadoNombre) {
							System.out.println("* ALCALDE YA GUARDADO, ENTRE POR MODIFICACION *");
							
						}else {
							if (duplicadaLocalidad) {
								System.out.println("* LOCALIDAD YA CON ALCALDE, ENTRE POR MODIFICACION *");
							}else {
								nombres[guardados] = nombreAux;
								edades[guardados] = edadAux;
								localidades[guardados] = localidadAux;
								
								System.out.println("* ALCALDE AÑADIDO CORRECTAMENTE *");
							}
						}
						
						
					}else {
						System.out.println("* ARRAYS COMPLETOS, ELIMINE UN ALCALDE ANTES *");
					}
					
					break;
					
				case 2:
					
					System.out.println("QUE DESEA HACER: ");
					System.out.println("1 - BUSCAR POR NOMBRE ALCALDE");
					System.out.println("2 - BUSCAR POR EDAD ALCALDE");
					System.out.println("3 - BUSCAR POR LOCALIDAD");
					
					filtroBusqueda = entrada.nextInt(); entrada.nextLine();
								    
					switch(filtroBusqueda) {
						case 1:
							
							System.out.println("NOMBRE A BUSCAR: ");
							nombreABuscar = entrada.nextLine();
							
							if (nombres[0] != null) {
								
								posicionNombre = Funcionalidades.buscarArrayString(nombreABuscar,nombres);
								
								if (posicionNombre == -1) {
									
									System.out.println("* NO HAY NINGUN ALCALDE QUE SE LLAME " + nombreABuscar + ". *");
									
								}else {
									System.out.println("* ALCALDE ENCONTRADO *");
									System.out.println(nombreABuscar + " TIENE " + edades[posicionNombre] + " AÑOS Y VIVE EN " + localidades[posicionNombre] + ".");
								}
								
							
							}else {
								System.out.println("* NO HAY NINGUN ALCALDE CON ESE NOMBRE. *");
							}
							
							break;
						case 2:
							
							System.out.println("EDAD A BUSCAR: ");
							edadABuscar = entrada.nextInt();
							entrada.nextLine();
							
							if (nombres[0] != null) {
								posicionEdad = Funcionalidades.buscarArrayInt(edadABuscar,edades);
								
								if (posicionEdad != -1) {
									System.out.println("* ALCALDE ENCONTRADO *");
									System.out.println("EL ALCALDE QUE TIENE " + edadABuscar + " AÑOS ES " + nombres[posicionEdad] + " Y GOBIERNA EN " + localidades[posicionEdad] + ".");
								}else {
									System.out.println("* NO HAY NINGUN ALCALDE CON " + edadABuscar + " AÑOS. *");
								}
							}else {
								System.out.println("* NO HAY INFORMACION DE NINGUN ALCALDE. *");
							}
							
							break;
						case 3:
							
							System.out.println("LOCALIDAD A BUSCAR: ");
							localidadABuscar = entrada.nextLine();

							if (nombres[0] != null) {
								posicionLocalidad = Funcionalidades.buscarArrayString(localidadABuscar,localidades);
								
								if (posicionLocalidad != -1) {
									System.out.println("* ALCALDE ENCONTRADO *");
									System.out.println("EN " + localidadABuscar + " GOBIERNA " + nombres[posicionLocalidad] + " Y TIENE " + edades[posicionLocalidad] + " AÑOS.");
								}else {
									System.out.println("* NO HAY ALCALDE ELEGIDO EN " + localidadABuscar + ".");
								}
							}else {
								System.out.println("* NO HAY INFORMACION DE NINGUN ALCALDE. *");
							}
							
							break;
							
						default:
							System.out.println("FILTRO DE BUSQUEDA INVÁLIDO.");
					}
					
				    
					
					break;
					
				case 3:
					System.out.println("¿QUE LOCALIDAD DESEA MODIFICAR?");
						
					localidadAModificar = entrada.nextLine();
					posicionLocalidad = -1;
					
					posicionLocalidad = Funcionalidades.buscarArrayString(localidadAModificar, localidades);
					
					if (posicionLocalidad != -1) {
						System.out.println("* LOCALIDAD ENCONTRADA... ¿QUE DESEA MODIFICAR?");
						System.out.println("1 - EDAD ALCALDE");
						System.out.println("2 - NOMBRE ALCALDE");
						System.out.println("3 - AMBAS");
						
						filtroBusqueda = entrada.nextInt();
						
						switch (filtroBusqueda) {
							case 1:
								System.out.println("INTRODUCE NUEVA EDAD: ");
								edades[posicionLocalidad] = entrada.nextInt();
								entrada.nextLine();
								System.out.println("* EDAD MODIFICADA CORRECTAMENTE *");
								break;
							case 2:
								System.out.println("INTRODUCE NOMBRE NUEVO ALCALDE: ");
								entrada.nextLine();
								nombres[posicionLocalidad] = entrada.nextLine();
								System.out.println("* NOMBRE ALCALDE MODIFICADO CORRECTAMENTE *");
								
								break;
							case 3:
								
								System.out.println("INTRODUCE NOMBRE NUEVO ALCALDE: ");
								nombres[posicionLocalidad] = entrada.nextLine();
								
								System.out.println("INTRODUCE NUEVA EDAD: ");
								edades[posicionLocalidad] = entrada.nextInt();
								entrada.nextLine();
								System.out.println("* NOMBRE Y EDAD ALCALDE MODIFICADO CORRECTAMENTE *");
								
								break;
							
							default:
								System.out.println("* OPCION NO VALIDA: NO SE HA MODIFICADO. *");
								break;
							}
						
					}else {
						System.out.println("* NO SE HA ENCONTRADO LOCALIDAD: NO SE HA MODIFICADO. *");
					}
					break;
				case 4:
					
					System.out.println("¿QUE LOCALIDAD QUIERE ELIMINAR?");
					localidadAEliminar = entrada.nextLine();
					
					posicionLocalidad = Funcionalidades.buscarArrayString(localidadAEliminar, nombres);
					
					if (posicionLocalidad != -1) {
						
						System.out.println("* LOCALIDAD A ELIMINAR ENCONTRADA.. ELIMINANDO... *");
						nombres[posicionLocalidad] = null;
						edades[posicionLocalidad] = 0;
						localidades[posicionLocalidad] = null;
						
						System.out.println("* LOCALIDAD BORRADA CORRECTAMENTE *)");
						
						Funcionalidades.correrPosiciones(posicionLocalidad,nombres,edades,localidades);
						
					}else {
						System.out.println("* LOCALIDAD NO ENCONTRADA: NO SE PUEDE ELIMINAR *");
					}
					break;
					
				case 5:
					
					numeroGuardados = Funcionalidades.contarGuardados(nombres);
					
					System.out.println("*LISTA DE ALCALDES GUARDADOS*");
					System.out.println("*---------------------------");
					
					if (numeroGuardados != 0) {
						for (i=0;i<numeroGuardados;i++) {
							System.out.println(nombres[i] + " | " + edades[i] + " AÑOS | GOBIERNA EN: " + localidades[i] + ".");
						}
					}else {
						System.out.println("* NO HAY ALCALDES EN LA LISTA *");
					}
					
					System.out.println("");
					
					break;
					
				case 6:
					fin = true;
					break;
				default:
					System.out.println("* OPCION NO VALIDA, INTENTELO DE NUEVO. *");
					
					break;
			}
			
			
		}while(!fin);
		
		entrada.close();
		System.out.println("***** GRACIAS POR USAR LA APLICACIÓN :) *****");
	}
	
	
	
	

}