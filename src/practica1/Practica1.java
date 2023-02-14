package practica1;

import java.util.Scanner;

/**
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */

public class Practica1{
	
	/**
	 * @author Luis Martin Portillo.
	 * @param args - args necesario main
	 * @version 1.1.1
	 */

	public static void main(String[] args) {
		
		String [] nombres = new String[20];
		int [] edades = new int[20];
		String[] localidades = new String[20];
		
		int[] busquedaEdad = new int[20];
		
		
		int opcionMenu,guardados,edadAux,filtroBusqueda,posicionLocalidad,edadABuscar,posicionNombre,numeroGuardados,respuesta,posicionLocalidadAux,posicionAlcalde;
		String nombreAux,localidadAux,nombreABuscar,localidadABuscar,localidadAModificar,localidadAEliminar,nombreAModificar,alcaldeAEliminar;
		boolean fin=false;
		
		boolean duplicadoNombre, duplicadaLocalidad;
		boolean finValidaciones,finBusqueda;
		
		int i=0;
		posicionLocalidad = -1;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			System.out.println("*************************************************************");
			System.out.println("**************************** MENU ***************************");
			System.out.println("*************************************************************");
			System.out.println("*****     1 - AÑADIR NUEVO ALCALDE.                     *****");
			System.out.println("*****     2 - BUSCAR POR ALCALDE/EDAD/LOCALIDAD.        *****");
			System.out.println("*****     3 - MODIFICAR POR ALCALDE/LOCALIDAD.          *****");
			System.out.println("*****     4 - ELIMINAR REGISTRO POR LOCALIDAD/ALCALDE.  *****");
			System.out.println("*****     5 - CONSULTAR LISTA ALCALDES Y POBLACION      *****");
			System.out.println("*****         DONDE GOBIERNA.                           *****");
			System.out.println("*****     6 - SALIR.                                    *****");
			System.out.println("*************************************************************");
			
			opcionMenu=entrada.nextInt();
			entrada.nextLine(); 
			
			switch(opcionMenu) {
			
				/********************************************** BLOQUE INSERCCION ***************************************************************/
			
				case 1:
					
					guardados = Funcionalidades.contarGuardados(nombres);	
					
					if (guardados < 20) {
						
						finValidaciones = false;
						duplicadoNombre = false;
						duplicadaLocalidad = false;
						
						do {
							System.out.println("1º - NOMBRE DEL ALCADE A AÑADIR: ");
							nombreAux = entrada.nextLine();
							
							respuesta = Funcionalidades.buscarArrayString(nombreAux, nombres);
							
							if (respuesta != -1) {
								duplicadoNombre = true;
							}
							
							System.out.println("2º - INTRODUZCA SU EDAD: ");
							edadAux = entrada.nextInt();
							entrada.nextLine(); 
							
							System.out.println("3º - LOCALIDAD QUE GOBIERNA: ");
							localidadAux = entrada.nextLine();
							
							respuesta = Funcionalidades.buscarArrayString(localidadAux, localidades);
							
							if (respuesta != -1) {
								duplicadaLocalidad = true;
							}
							
							finValidaciones = true;
							
						}while(!duplicadoNombre && !finValidaciones && !duplicadaLocalidad);
						
						
						if (duplicadoNombre) {
							System.out.println("*****************************************************");
							System.out.println("* ALCALDE INTRODUCIDO YA GOBIERNA EN OTRA LOCALIDAD *");
							System.out.println("*          NO SE PUEDE DAR DE ALTA                  *");
							System.out.println("*****************************************************");
							
						}else {
							if (duplicadaLocalidad) {
								System.out.println("*******************************");
								System.out.println("*   LOCALIDAD YA CON ALCALDE  *");
								System.out.println("*   NO SE PUEDE DAR DE ALTA   *");
								System.out.println("*******************************");
							}else {
								nombres[guardados] = nombreAux;
								edades[guardados] = edadAux;
								localidades[guardados] = localidadAux;
								
								
								System.out.println("* --- ¡ALCALDE AÑADIDO CORRECTAMENTE! --- *");
							}
						}
						
						
					}else {
						System.out.println("**********************************************");
						System.out.println("* ARRAYS COMPLETOS, ELIMINE UN ALCALDE ANTES *");
						System.out.println("**********************************************");
					}
					
					break;
				
				/********************************************** BLOQUE CONSULTA ***************************************************************/
					
				case 2:
					
					System.out.println("¿QUE DESEA HACER? ");
					System.out.println("1 - BUSCAR POR NOMBRE ALCALDE");
					System.out.println("2 - BUSCAR POR EDAD ALCALDE");
					System.out.println("3 - BUSCAR POR LOCALIDAD");
					
					filtroBusqueda = entrada.nextInt(); entrada.nextLine();
								    
					switch(filtroBusqueda) {
						case 1:
							
							if (nombres[0] != null) {
								
								System.out.println("NOMBRE A BUSCAR: ");
								nombreABuscar = entrada.nextLine();
								
								posicionNombre = Funcionalidades.buscarArrayString(nombreABuscar,nombres);
								
								if (posicionNombre == -1) {
									
									System.out.println("* NO HAY NINGUN ALCALDE QUE SE LLAME " + nombreABuscar + ". *");
									
								}else {
									System.out.println("* ALCALDE ENCONTRADO *");
									System.out.println(nombreABuscar + " TIENE " + edades[posicionNombre] + " AÑOS Y GOBIERNA EN " + localidades[posicionNombre] + ".");
								}
								
							
							}else {
								System.out.println("* NO HAY DATOS GUARDADOS. *");
							}
							
							break;
						case 2:
							
							finBusqueda = false;
							i = 0;
							
							if (edades[0] != 0) {
								
								System.out.println("EDAD A BUSCAR: ");
								edadABuscar = entrada.nextInt();
								entrada.nextLine();
								
								busquedaEdad = Funcionalidades.obtenerPosiciones(edadABuscar,edades);
								
								System.out.println(busquedaEdad[i]);
								if (busquedaEdad[i] == -1) {
									finBusqueda = true;
								}
								
								if (!finBusqueda) {
									System.out.println("* LOS SIGUIENTES ALCALDES TIENEN " + edadABuscar + " AÑOS: *");
								}
								
								do {
									
									System.out.println(nombres[busquedaEdad[i]] + " DE " + localidades[busquedaEdad[i]]);
									i++;
									
									if (busquedaEdad[i] == 0) {
										finBusqueda = true;
									}
									
									
								}while(!finBusqueda);
								
							}else {
								System.out.println("* NO HAY DATOS GUARDADOS *");
							}
							
							break;
						case 3:
							
							System.out.println("LOCALIDAD A BUSCAR: ");
							localidadABuscar = entrada.nextLine();

							if (nombres[0] != null) {
								posicionLocalidad = Funcionalidades.buscarArrayString(localidadABuscar,localidades);
								
								if (posicionLocalidad != -1) {
									System.out.println("* LOCALIDAD ENCONTRADA *");
									System.out.println("EN " + localidadABuscar + " GOBIERNA " + nombres[posicionLocalidad] + " Y TIENE " + edades[posicionLocalidad] + " AÑOS.");
								}else {
									System.out.println("* NO HAY ALCALDE ELEGIDO EN " + localidadABuscar + ".");
								}
							}else {
								System.out.println("* NO HAY DATOS GUARDADOS. *");
							}
							
							break;
							
						default:
							System.out.println("FILTRO DE BUSQUEDA INVALIDO.");
					}
					
				    
					
					break;
				
				/********************************************** BLOQUE MODIFICACION ***************************************************************/
					
				case 3:
					System.out.println("*******************************************");
					System.out.println("            ¿QUE OPCION DESEA?             ");
					System.out.println("                                           ");
					System.out.println("   1 - MODIFICACION POR LOCALIDAD.         ");
					System.out.println("   2 - MODIFICACION POR NOMBRE DEL ALCALDE.");
					System.out.println("                                           ");
					System.out.println("*******************************************");
					
					opcionMenu = entrada.nextInt();entrada.nextLine();
					
					switch (opcionMenu) {
					
					case 1:
						System.out.println("¿QUE LOCALIDAD DESEA MODIFICAR?");
						
						localidadAModificar = entrada.nextLine();
						
						posicionLocalidadAux = Funcionalidades.buscarArrayString(localidadAModificar, localidades);
						
						if (posicionLocalidadAux != -1) {
							
							System.out.println("* LOCALIDAD ENCONTRADA... ¿QUE DESEA MODIFICAR?");
							System.out.println("1 - EDAD ALCALDE");
							System.out.println("2 - NOMBRE ALCALDE");
							System.out.println("3 - AMBAS");
							
							filtroBusqueda = entrada.nextInt();entrada.nextLine();
							
							switch (filtroBusqueda) {
								case 1:
									System.out.println("INTRODUCE NUEVA EDAD: ");
									edades[posicionLocalidadAux] = entrada.nextInt();
									entrada.nextLine();
									System.out.println("* EDAD MODIFICADA CORRECTAMENTE *");
									break;
								case 2:
									System.out.println("INTRODUCE NOMBRE NUEVO ALCALDE: ");
									entrada.nextLine();
									
									nombreAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(nombreAux, nombres) != -1) {
										System.out.println("* EL ALCALDE INTRODUCIDO YA ES ALCALDE DE " + nombres[Funcionalidades.buscarArrayString(nombreAux,nombres)]);
									}else {
									
										nombres[posicionLocalidadAux] = entrada.nextLine();
										System.out.println("* NOMBRE ALCALDE MODIFICADO CORRECTAMENTE *");
									}
									
									break;
								case 3:
									
									System.out.println("INTRODUCE NOMBRE NUEVO ALCALDE: ");
									nombres[posicionLocalidadAux] = entrada.nextLine();
									
									System.out.println("INTRODUCE NUEVA EDAD: ");
									edades[posicionLocalidadAux] = entrada.nextInt();
									entrada.nextLine();
									System.out.println("* NOMBRE Y EDAD ALCALDE MODIFICADO CORRECTAMENTE *");
									
									break;
								
								default:
									System.out.println("* OPCION NO VALIDA: NO SE HA MODIFICADO. *");
									break;
								}
							
						}else {
							System.out.println("* NO SE HA ENCONTRADO LOCALIDAD: NO ES POSIBLE MODIFICAR. *");
						}
						
						break;
						
					case 2:
						System.out.println("¿QUE ALCALDE DESEA MODIFICAR?");
						
						nombreAModificar = entrada.nextLine();
						
						posicionNombre = Funcionalidades.buscarArrayString(nombreAModificar, nombres);
						
						if (posicionNombre != -1) {
							System.out.println("* ALCALDE ENCONTRADO... ¿QUE DESEA MODIFICAR?");
							System.out.println("1 - EDAD ALCALDE");
							System.out.println("2 - LOCALIDAD");
							System.out.println("3 - AMBAS");
							
							filtroBusqueda = entrada.nextInt();entrada.nextLine();
							
							switch (filtroBusqueda) {
								case 1:
									System.out.println("INTRODUCE NUEVA EDAD: ");
									edades[posicionNombre] = entrada.nextInt();
									entrada.nextLine();
									System.out.println("* EDAD MODIFICADA CORRECTAMENTE *");
									break;
								case 2:
									System.out.println("INTRODUCE NUEVA LOCALIDAD: ");
									entrada.nextLine();
									
									localidadAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(localidadAux, localidades) != -1) {
										System.out.println("* LA POBLACION YA TIENE ALCALDE: " + nombres[Funcionalidades.buscarArrayString(localidadAux,localidades)]);
									}else {
									
										localidades[posicionNombre] = localidadAux;
										System.out.println("* NOMBRE LOCALIDAD MODIFICADO CORRECTAMENTE *");
									}
									
									break;
								case 3:
									
									System.out.println("INTRODUCE NUEVA EDAD: ");
									edades[posicionNombre] = entrada.nextInt();
									entrada.nextLine();
									
									System.out.println("INTRODUCE NUEVA LOCALIDAD: ");
									entrada.nextLine();
									
									localidadAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(localidadAux, localidades) != -1) {
										System.out.println("* LA POBLACION YA TIENE ALCALDE: " + nombres[Funcionalidades.buscarArrayString(localidadAux,localidades)]);
									}else {
									
										localidades[posicionNombre] = localidadAux;
									
									}
									
									System.out.println("* NOMBRE Y EDAD ALCALDE MODIFICADO CORRECTAMENTE *");
									
									break;
								
								default:
									System.out.println("* OPCION NO VALIDA: NO SE HA MODIFICADO. *");
									break;
								}
							
						}else {
							System.out.println("* NO SE HA ENCONTRADO LOCALIDAD: NO ES POSIBLE MODIFICAR. *");
						}
						
					default:
						System.out.println("* OPCION NO VALIDA *");
						break;
					
					}
					
					
					break;
					
					
				/************************************************* BLOQUE ELIMINACION ******************************************************/	
					
				case 4:
					
					System.out.println("*******************************************");
					System.out.println("        ¿QUE REGISTRO DESEA BOORAR?        ");
					System.out.println("                                           ");
					System.out.println("   1 - ELIMINAR POR LOCALIDAD.             ");
					System.out.println("   2 - ELIMINAR POR NOMBRE DEL ALCALDE.    ");
					System.out.println("                                           ");
					System.out.println("*******************************************");
					
					opcionMenu = entrada.nextInt();
					entrada.nextLine();
					
					
					switch(opcionMenu) {
					case 1:
						System.out.println("¿QUE LOCALIDAD QUIERE ELIMINAR?");
						localidadAEliminar = entrada.nextLine();
						
						posicionLocalidad = Funcionalidades.buscarArrayString(localidadAEliminar, localidades);
						
						if (posicionLocalidad != -1) {
							
							System.out.println("* LOCALIDAD A ELIMINAR ENCONTRADA.. ELIMINANDO... *");
							nombres[posicionLocalidad] = null;
							edades[posicionLocalidad] = 0;
							localidades[posicionLocalidad] = null;
							
							System.out.println("* LOCALIDAD BORRADA CORRECTAMENTE *)");
							
							Funcionalidades.correrPosiciones(posicionLocalidad,nombres,edades,localidades);
							
						}else {
							System.out.println("* LOCALIDAD NO REGISTRADA: NO SE PUEDE ELIMINAR *");
						}
						break;
					case 2:
						
						System.out.println("¿QUE ALCALDE QUIERE ELIMINAR?");
						alcaldeAEliminar = entrada.nextLine();
						
						posicionAlcalde = Funcionalidades.buscarArrayString(alcaldeAEliminar, nombres);
						
						if (posicionAlcalde != -1) {
							
							System.out.println("* ALCALDE A ELIMINAR ENCONTRADO.. ELIMINANDO REGISTRO... *");
							nombres[posicionAlcalde] = null;
							edades[posicionAlcalde] = 0;
							localidades[posicionAlcalde] = null;
							
							System.out.println("* REGISTRO BORRADO CORRECTAMENTE *)");
							
							Funcionalidades.correrPosiciones(posicionLocalidad,nombres,edades,localidades);
							
						}else {
							System.out.println("* ALCALDE NO REGISTRADO: NO SE PUEDE ELIMINAR *");
						}
						
						break;
					default:
						System.out.println("**************************");
						System.out.println("*    OPCION NO VALIDA    *");
						System.out.println("**************************");
						break;
					}
					
					break;
					
				/************************************************* CONTENIDO ARRAY ******************************************************/
					
				case 5:
					
					numeroGuardados = Funcionalidades.contarGuardados(nombres);
					
					System.out.println("* LISTA DE ALCALDES GUARDADOS *");
					System.out.println("*------------------------------");
					
					if (numeroGuardados != 0) {
						for (i=0;i<numeroGuardados;i++) {
							System.out.println(nombres[i] + " | " + edades[i] + " AÑOS | GOBIERNA EN: " + localidades[i] + ".");
						}
					}else {
						System.out.println("* NO HAY ALCALDES EN LA LISTA *");
					}
					
					System.out.println("");
					
					break;
				
				/************************************************* OPCION FIN ******************************************************/
				case 6:
					fin = true;
					break;
					
				/************************************************* OTRA OPCION ******************************************************/	
				default:
					System.out.println("* OPCION NO VALIDA, INTENTELO DE NUEVO. *");
					
					break;
			}
			
			
		}while(!fin);
		
		entrada.close();
		
		System.out.println("***** GRACIAS POR USAR LA APLICACIÓN :) *****");
	}
	
	
	
	

}