package practica1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
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
		int[] edadesAux = new int[20];
		
		
		int opcionMenu,guardados,edadAux,filtroBusqueda,posicionLocalidad,edadABuscar,posicionNombre,numeroGuardados,respuesta,posicionLocalidadAux,posicionAlcalde,cont;
		String nombreAux,localidadAux,nombreABuscar,localidadABuscar,localidadAModificar,localidadAEliminar,nombreAModificar,alcaldeAEliminar;
		boolean fin=false;
		
		boolean duplicadoNombre, duplicadaLocalidad,valido;
		
		int i=0;
		int sumaEdades = 0;
		float media = 0;
		posicionLocalidad = -1;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			System.out.println("*************************************************************");
			System.out.println("**************************** MENU ***************************");
			System.out.println("*************************************************************");
			System.out.println("*****     1 - AÑADIR NUEVO ALCALDE.                     *****");
			System.out.println("*****     2 - BUSCAR POR ALCALDE/EDAD/LOCALIDAD.        *****");
			System.out.println("*****     3 - MODIFICAR POR ALCALDE/LOCALIDAD.          *****");
			System.out.println("*****     4 - ELIMINAR REGISTRO POR LOCALIDAD/ALCALDE.   *****");
			System.out.println("*****     5 - SALIR.                                    *****");
			System.out.println("*************************************************************");
			
			opcionMenu=entrada.nextInt();
			entrada.nextLine(); 
			
			switch(opcionMenu) {
			
				/********************************************** BLOQUE INSERCCION ***************************************************************/
			
				case 1:
					
					guardados = Funcionalidades.contarGuardados(nombres);	
					edadAux = 0;
					
					if (guardados < 20) {
						
						duplicadoNombre = false;
						duplicadaLocalidad = false;
						valido=false;
						
						System.out.println("1º - NOMBRE DEL ALCADE A AÑADIR: ");
						nombreAux = entrada.nextLine();
							
						respuesta = Funcionalidades.buscarArrayString(nombreAux, nombres);
							
						if (respuesta != -1) {
							duplicadoNombre = true;
						}
						
						
						do {
							
							try {
								System.out.println("2º - INTRODUZCA SU EDAD: ");
								edadAux = entrada.nextInt();
								entrada.nextLine(); 
							
								if (edadAux <=0) {
									System.out.println("* EDAD NO VALIDA. VUELVE A INTENTARLO. *");
								}else {
									valido = true;
								}
							}catch(InputMismatchException e) {
								System.out.println("* LA EDAD DEBE DE SER NUMERICA *");
								entrada.nextLine(); 
							}
						}while(!valido);
						
							
						System.out.println("3º - LOCALIDAD QUE GOBIERNA: ");
						localidadAux = entrada.nextLine();
							
						respuesta = Funcionalidades.buscarArrayString(localidadAux, localidades);
							
						if (respuesta != -1) {
							duplicadaLocalidad = true;
						}
							
							
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
					
					valido=false;
					filtroBusqueda = 0;
					
					do {
						try {
							System.out.println("********************************************");
							System.out.println("*             ¿QUE DESEA HACER?            *");
							System.out.println("*      1 - BUSCAR POR NOMBRE ALCALDE.      *");
							System.out.println("*      2 - BUSCAR POR EDAD ALCALDE.        *");
							System.out.println("*      3 - BUSCAR POR LOCALIDAD.           *");
							System.out.println("*      4 - MEDIA EDAD ALCALDES.            *");
							System.out.println("*      5 - EDADES ALCALDES ORDENADAS DE    *");
							System.out.println("*          MENOR A MAYOR.                  *");
							System.out.println("*      6 - CONSULTAR LISTA ALCALDES Y      *");
							System.out.println("*          POBLACION DONDE GOBIERNA.       *");
							System.out.println("********************************************");
						
							filtroBusqueda = entrada.nextInt(); 
							entrada.nextLine();
							valido = true;
							
						}catch(InputMismatchException e){
							System.out.println("* LA OPCION DEBE SER NUMERICA. INTENTELO DE NUEVO*");
							entrada.nextLine();
						}
						
					}while(!valido);	
					
					switch(filtroBusqueda) {
						case 1:
							
							if (nombres[0] != null) {
								
								System.out.println("1º - NOMBRE DEL ALCADE A BUSCAR: ");
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
							
							
							if (edades[0] != 0) {
								
								System.out.println("1º - EDAD POR LA QUE BUSCAR: ");
								edadABuscar = entrada.nextInt();
								entrada.nextLine();
								
								busquedaEdad = Funcionalidades.obtenerPosiciones(edadABuscar,edades);
								int posicion = 0;
								
								while(busquedaEdad[posicion] != -1) {
									System.out.println(nombres[busquedaEdad[posicion]] + ": ALCADE DE " + localidades[busquedaEdad[posicion]]);
									posicion++;
								}
								
								if (posicion == 0) {
									System.out.println("* NO HAY NINGUN ALCALDE CON " + edadABuscar + " AÑOS. *");
								}
								
							}else{
								System.out.println("* NO HAY DATOS GUARDADOS *");
							}					
							
							break;
							
						case 3:
							
							System.out.println("1º - LOCALIDAD POR LA QUE BUSCAR: ");
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
							
						case 4: 
							
							sumaEdades = Funcionalidades.sumaInt(edades);
							guardados = Funcionalidades.contarGuardados(nombres);
							
							if (sumaEdades > 0 && guardados >0) {
							
								media = sumaEdades / guardados;
							}
							
							System.out.println("LA MEDIA DE EDAD ES: " + media);
							break;
						case 5:
							
							edadesAux = new int[20];
							
							for(int r=0; r<edades.length; r++) {
								edadesAux[r] = edades[r];
							}
							
							Arrays.sort(edadesAux);
							cont = 0;
				
							for (int y = 0; y<edadesAux.length;y++) {
								if (edadesAux[y] != 0) {
									cont++;
									System.out.print(edadesAux[y] + " - ");
								}
							}
							
							System.out.println();
							if (cont == 0) {
								System.out.println("* NO HAY DATOS QUE ORDENAR *");
							}
							
							break;
						case 6:
							numeroGuardados = Funcionalidades.contarGuardados(nombres);
							
							System.out.println("*------------------------------");
							System.out.println("* LISTA DE ALCALDES GUARDADOS *");
							System.out.println("*------------------------------");
							
							if (numeroGuardados != 0) {
								for (i=0;i<numeroGuardados;i++) {
									System.out.println(nombres[i] + " | " + edades[i] + " AÑOS | GOBIERNA EN: " + localidades[i] + ".");
								}
							}else {
								System.out.println("*******************************");
								System.out.println("* NO HAY ALCALDES EN LA LISTA *");
								System.out.println("*******************************");
							}
							
							break;
						default:
							System.out.println("* FILTRO DE BUSQUEDA INVALIDO. *");
							break;
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
							
							System.out.println("**************************************************");
							System.out.println("*  LOCALIDAD ENCONTRADA... ¿QUE DESEA MODIFICAR? *");
							System.out.println("*              1 - EDAD ALCALDE.                 *");
							System.out.println("*              2 - NOMBRE ALCALDE.               *");
							System.out.println("*              3 - AMBAS.                        *");
							System.out.println("**************************************************");
							
							filtroBusqueda = entrada.nextInt();entrada.nextLine();
							
							switch (filtroBusqueda) {
								case 1:
									System.out.println("1º - INTRODUCE NUEVA EDAD: ");
									
									edadAux = entrada.nextInt();
									entrada.nextLine();
									edades[posicionLocalidadAux] = edadAux;
									
									System.out.println("*********************************");
									System.out.println("* EDAD MODIFICADA CORRECTAMENTE *");
									System.out.println("*********************************");
									
									break;
								case 2:
									System.out.println("1º - INTRODUCE NOMBRE NUEVO ALCALDE: ");
									
									nombreAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(nombreAux, nombres) != -1) {
										System.out.println("* EL ALCALDE INTRODUCIDO YA ES ALCALDE DE " + localidades[Funcionalidades.buscarArrayString(nombreAux,nombres)] + ". INTRODUCE ALCALDE SIN CARGO EN OTRO AYUNTAMIENTO.");
									}else {
									
										nombres[posicionLocalidadAux] = nombreAux;
										System.out.println("**************************************************");
										System.out.println("*    NOMBRE ALCALDE MODIFICADO CORRECTAMENTE     *");
										System.out.println("**************************************************");
									}
									
									break;
								case 3:
									
									System.out.println("1ª - INTRODUCE NOMBRE NUEVO ALCALDE: ");
									nombreAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(nombreAux, nombres) != -1) {
										System.out.println("* EL ALCALDE INTRODUCIDO YA ES ALCALDE DE " + nombres[Funcionalidades.buscarArrayString(nombreAux,nombres)]);
									}else {
									
										nombres[posicionLocalidadAux] = nombreAux;
										System.out.println("**************************************************");
										System.out.println("*    NOMBRE ALCALDE MODIFICADO CORRECTAMENTE     *");
										System.out.println("**************************************************");
									}
									
									System.out.println("2º - INTRODUCE NUEVA EDAD: ");
									edadAux = entrada.nextInt();
									entrada.nextLine();
									edades[posicionLocalidadAux] = edadAux;
									
									System.out.println("**************************************************");
									System.out.println("*      EDAD ALCALDE MODIFICADA CORRECTAMENTE     *");
									System.out.println("**************************************************");
									
									break;
								
								default:
									System.out.println("**************************************************");
									System.out.println("*     OPCION NO VALIDA: NO SE HA MODIFICADO.     *");
									System.out.println("**************************************************");
									
									break;
								}
							
						}else {
							System.out.println("***********************************************************");
							System.out.println("* NO SE HA ENCONTRADO LOCALIDAD: NO ES POSIBLE MODIFICAR. *");
							System.out.println("***********************************************************");
						}
						
						break;
						
					case 2:
						System.out.println("¿QUE ALCALDE DESEA MODIFICAR?");
						
						nombreAModificar = entrada.nextLine();
						
						posicionNombre = Funcionalidades.buscarArrayString(nombreAModificar, nombres);
						
						if (posicionNombre != -1) {
							
							System.out.println("**************************************************");
							System.out.println("*  ALCALDE ENCONTRADO... ¿QUE DESEA MODIFICAR?   *");
							System.out.println("*              1 - EDAD ALCALDE.                 *");
							System.out.println("*              2 - LOCALIDAD.                    *");
							System.out.println("*              3 - AMBAS.                        *");
							System.out.println("**************************************************");
							
							filtroBusqueda = entrada.nextInt();entrada.nextLine();
							
							switch (filtroBusqueda) {
								case 1:
									System.out.println("1º - INTRODUCE NUEVA EDAD: ");
									
									edadAux = entrada.nextInt();
									entrada.nextLine();
									edades[posicionNombre] = edadAux;
									
									System.out.println("*********************************");
									System.out.println("* EDAD MODIFICADA CORRECTAMENTE *");
									System.out.println("*********************************");
									
									break;
								case 2:
									System.out.println("1º - INTRODUCE NUEVA LOCALIDAD: ");
									
									localidadAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(localidadAux, localidades) != -1) {
										System.out.println("* LA POBLACION YA TIENE ALCALDE: " + nombres[Funcionalidades.buscarArrayString(localidadAux,localidades)] + ". *");
									}else {
									
										localidades[posicionNombre] = localidadAux;
										
										System.out.println("*********************************************");
										System.out.println("* NOMBRE LOCALIDAD MODIFICADO CORRECTAMENTE *");
										System.out.println("*********************************************");
									}
									
									break;
								case 3:
									
									System.out.println("1º - INTRODUCE NUEVA EDAD: ");
									
									edadAux = entrada.nextInt();
									entrada.nextLine();
									edades[posicionNombre] = edadAux;
									
									System.out.println("*********************************");
									System.out.println("* EDAD MODIFICADA CORRECTAMENTE *");
									System.out.println("*********************************");
									
									System.out.println("2º - INTRODUCE NUEVA LOCALIDAD: ");
									localidadAux= entrada.nextLine();
									
									if (Funcionalidades.buscarArrayString(localidadAux, localidades) != -1) {
										System.out.println("* LA POBLACION YA TIENE ALCALDE: " + nombres[Funcionalidades.buscarArrayString(localidadAux,localidades)] + ". *");
									}else {
									
										localidades[posicionNombre] = localidadAux;
										
										System.out.println("*********************************************");
										System.out.println("*      LOCALIDAD MODIFICADO CORRECTAMENTE   *");
										System.out.println("*********************************************");
									}
									
									break;
								
								default:
									System.out.println("******************************************");
									System.out.println("* OPCION NO VALIDA: NO SE HA MODIFICADO. *");
									System.out.println("******************************************");
									break;
								}
							
						}else {
							System.out.println("***********************************************************");
							System.out.println("* NO SE HA ENCONTRADO LOCALIDAD: NO ES POSIBLE MODIFICAR. *");
							System.out.println("***********************************************************");
						}
						
						break;
					default:
						
						System.out.println("********************");
						System.out.println("* OPCION NO VALIDA *");
						System.out.println("********************");
						
						break;
					
					}
					
					
					break;
					
					
				/************************************************* BLOQUE ELIMINACION ******************************************************/	
					
				case 4:
					
					System.out.println("*******************************************");
					System.out.println("        ¿QUE REGISTRO DESEA BORRAR?        ");
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
							
							System.out.println("***************************************************");
							System.out.println("*          LOCALIDAD A ELIMINAR ENCONTRADA..      *");
							System.out.println("*             ELIMINANDO REGISTRO...              *");
							
							nombres[posicionLocalidad] = null;
							edades[posicionLocalidad] = 0;
							localidades[posicionLocalidad] = null;
							
							System.out.println("***************************************************");
							System.out.println("*          REGISTRO BORRADO CORRECTAMENTE         *");
							System.out.println("***************************************************");
							
							Funcionalidades.correrPosiciones(posicionLocalidad,nombres,edades,localidades);
							
						}else {
							System.out.println("*************************************************");
							System.out.println("* LOCALIDAD NO REGISTRADA: NO SE PUEDE ELIMINAR *");
							System.out.println("*************************************************");
						}
						break;
						
					case 2:
						
						System.out.println("¿QUE ALCALDE QUIERE ELIMINAR?");
						alcaldeAEliminar = entrada.nextLine();
						
						posicionAlcalde = Funcionalidades.buscarArrayString(alcaldeAEliminar, nombres);
						
						if (posicionAlcalde != -1) {
							
							System.out.println("***************************************************");
							System.out.println("*         ALCALDE A ELIMINAR ENCONTRADO..         *");
							System.out.println("*              ELIMINANDO REGISTRO...             *");        
							
							nombres[posicionAlcalde] = null;
							edades[posicionAlcalde] = 0;
							localidades[posicionAlcalde] = null;
							
							System.out.println("***************************************************");
							System.out.println("*          REGISTRO BORRADO CORRECTAMENTE         *");
							System.out.println("***************************************************");
							
							Funcionalidades.correrPosiciones(posicionAlcalde,nombres,edades,localidades);
							
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

				/************************************************* OPCION FIN ******************************************************/
				case 5:
					fin = true;
					break;
					
				/************************************************* OTRA OPCION ******************************************************/	
				default:
					
					System.out.println("*****************************************");
					System.out.println("* OPCION NO VALIDA, INTENTELO DE NUEVO. *");
					System.out.println("*****************************************");
					
					break;
			}
			
			
		}while(!fin);
		
		entrada.close();
		
		System.out.println("*********************************************");
		System.out.println("*                                           *");
		System.out.println("*     GRACIAS POR USAR LA APLICACIÓN :)     *");
		System.out.println("*                                           *");
		System.out.println("*********************************************");
	}
	
	
	
	

}