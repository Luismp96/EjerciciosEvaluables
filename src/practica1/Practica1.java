package practica1;

import java.util.Scanner;

public class Practica1{

	public static void main(String[] args) {
		
		String [] nombres = new String[20];
		int [] edades = new int[20];
		String[] localidades = new String[20];
		
		
		int opcion,guardados,edadAux,filtroBusqueda,posicionEdad,posicionLocalidad,edadABuscar,posicionNombre,numeroGuardados;
		String nombreAux,localidadAux,nombreABuscar,localidadABuscar,nombreAModificar,personaAEliminar;
		boolean fin=false;
		boolean finNombres;
		boolean finPersonas = false;
		int i=0;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			Funcionalidades.mostrarMenu();
			
			opcion=entrada.nextInt();
			entrada.nextLine(); 
			
			switch(opcion) {
				case 1:
					
					guardados = Funcionalidades.contarGuardados(nombres);	
					System.out.println(guardados);
					
					if (guardados < 20) {
						
						System.out.println("Nombre de la Persona a añadir: ");
						nombreAux = entrada.nextLine();
						
						System.out.println("Introduzca su edad: ");
						edadAux = entrada.nextInt();
						entrada.nextLine(); 
						
						System.out.println("Localidad donde reside: ");
						localidadAux = entrada.nextLine();
						
						Funcionalidades.addPersona(nombreAux,edadAux,localidadAux,guardados,nombres,edades,localidades);
					}else {
						System.out.println("ARRAYS COMPLETOS, ELIMINE UNO ANTES");
					}
					
					break;
					
				case 2:
					
					System.out.println("QUE DESEA HACER: ");
					System.out.println("1 - BUSCAR POR NOMBRE");
					System.out.println("2 - BUSCAR POR EDAD");
					System.out.println("3 - BUSCAR POR LOCALIDAD");
					
					filtroBusqueda = entrada.nextInt(); entrada.nextLine();
					
				    try {
					switch(filtroBusqueda) {
						case 1:
							
							System.out.println("Nombre a buscar");
							nombreABuscar = entrada.nextLine();
							
							if (nombres[0] != null) {
								
								posicionNombre = Funcionalidades.buscarXNombre(nombreABuscar,nombres);
								
								if (posicionNombre == -1) {
									System.out.println("No hay ninguna persona que se llame " + nombreABuscar + ".");
									
								}else {
									System.out.println(nombreABuscar + " tiene " + edades[posicionNombre] + " años y vive en " + localidades[posicionNombre]);
								}
								
							
							}else {
								System.out.println("No hay información de ninguna persona.");
							}
							
							break;
						case 2:
							
							System.out.println("Edad a buscar");
							edadABuscar = entrada.nextInt();
							entrada.nextLine();
							
							if (nombres[0] != null) {
								posicionEdad = Funcionalidades.buscarXEdad(edadABuscar,edades);
								
								if (posicionEdad != -1) {
									System.out.println("La persona que tiene " + edadABuscar + " años es " + nombres[posicionEdad] + " y vive en " + localidades[posicionEdad]);
								}else {
									System.out.println("No hay ninguna persona con " + edadABuscar + " años.");
								}
							}else {
								System.out.println("No hay información de ninguna persona.");
							}
							
							break;
						case 3:
							
							System.out.println("Localidad a buscar");
							localidadABuscar = entrada.nextLine();

							if (nombres[0] != null) {
								posicionLocalidad = Funcionalidades.buscarXLocalidad(localidadABuscar,localidades);
								
								if (posicionLocalidad != -1) {
									System.out.println("En " + localidadABuscar + " vive " + nombres[posicionLocalidad] + " y tiene " + edades[posicionLocalidad] + " años.");
								}else {
									System.out.println("No hay ninguna persona que viva en " + localidadABuscar +".");
								}
							}else {
								System.out.println("No hay información de ninguna persona.");
							}
							
							break;
							
						default:
							System.out.println("FILTRO DE BUSQUEDA INVÁLIDO.");
					}
					
				    }catch(Exception e){
				    	System.out.println("EL DATO INTRODUCIDO NO ES NUMERICO");
				    }
					
					break;
					
				case 3:
					System.out.println("¿Que persona desea modificar?");
						
					nombreAModificar = entrada.nextLine();
					posicionNombre = -1;
					
					posicionNombre = Funcionalidades.buscarXNombre(nombreAModificar, nombres);
					
					if (posicionNombre != -1) {
						System.out.println("Nombre encontrado... ¿Que desea modificar?");
						System.out.println("1 - EDAD");
						System.out.println("2 - LOCALIDAD");
						System.out.println("3 - AMBAS");
						
						filtroBusqueda = entrada.nextInt();
						
						switch (filtroBusqueda) {
							case 1:
								System.out.println("Introduce nueva Edad: ");
								edades[posicionNombre] = entrada.nextInt();
								entrada.nextLine();
								break;
							case 2:
								System.out.println("Introduce nueva Localidad: ");
								entrada.nextLine();
								localidades[posicionNombre] = entrada.nextLine();
								
								break;
							case 3:
								System.out.println("Introduce nueva Edad: ");
								edades[posicionNombre] = entrada.nextInt();
								entrada.nextLine();
							
								System.out.println("Introduce nueva Localidad: ");
								localidades[posicionNombre] = entrada.nextLine();
								break;
							
							default:
								System.out.println("OPCION NO VALIDA");
								break;
							}
						
					}else {
						System.out.println("No se ha encontrado a nadie con ese nombre.");
					}
					break;
				case 4:
					
					System.out.println("¿Que persona desea eliminar?");
					personaAEliminar = entrada.nextLine();
					
					posicionNombre = Funcionalidades.buscarXNombre(personaAEliminar, nombres);
					
					if (posicionNombre != -1) {
						
						System.out.println("Nombre a borrar encontrado.. ELIMINANDO...");
						nombres[posicionNombre] = null;
						edades[posicionNombre] = 0;
						localidades[posicionNombre] = null;
						
						System.out.println("NOMBRE BORRADO CORRECTAMENTE :)");
						
						Funcionalidades.correrPosiciones(posicionNombre,nombres,edades,localidades);
						
					}else {
						System.out.println("Persona no encontrada.");
					}
					break;
					
				case 5:
					
					numeroGuardados = Funcionalidades.contarGuardados(nombres);
					if (numeroGuardados != 0) {
						for (i=0;i<numeroGuardados;i++) {
							System.out.println(nombres[i] + " tiene " + edades[i] + " años y vive en " + localidades[i] + ".");
						}
					}else {
						System.out.println("No hay personas en la Lista");
					}
					
					break;
					
				case 6:
					fin = true;
					break;
				default:
					System.out.println("OPCION NO VALIDA, INTENTELO DE NUEVO.");
					
					break;
			}
			
			
		}while(!fin);
		
		entrada.close();
		System.out.println("GRACIAS POR USAR LA APLICACIÓN");
	}
	
	
	
	

}
