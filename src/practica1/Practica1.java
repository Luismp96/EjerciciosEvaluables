package practica1;

import java.util.Scanner;

public class Practica1{

	public static void main(String[] args) {
		
		String [] nombres = new String[20];
		int [] edades = new int[20];
		String[] localidades = new String[20];
		
		int opcion,guardados,edadAux,filtroBusqueda,posicionNombre,edadABuscar;
		String nombreAux,localidadAux,nombreABuscar,localidadABuscar;
		boolean fin=false;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			Funcionalidades.mostrarMenu();
			
			opcion=entrada.nextInt();
			entrada.nextLine(); 
			
			switch(opcion) {
				case 1:
					
					guardados = Funcionalidades.contarGuardados(nombres);	
					System.out.println(guardados);
					
					System.out.println("Nombre de la Persona a añadir: ");
					nombreAux = entrada.nextLine();
					
					System.out.println("Introduzca su edad: ");
					edadAux = entrada.nextInt();
					entrada.nextLine(); 
					
					System.out.println("Localidad donde reside: ");
					localidadAux = entrada.nextLine();
					
					if (guardados < 20) {
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
					
					switch(filtroBusqueda) {
						case 1:
							System.out.println("Nombre a buscar");
							nombreABuscar = entrada.nextLine();
							if (nombres[0] != null) {
								posicionNombre = Funcionalidades.buscarXNombre(nombreABuscar,nombres);
								
								if (posicionNombre != -1) {
									System.out.println("La edad de " + nombreABuscar + " es de " + edades[posicionNombre] + " y vive en " + localidades[posicionNombre]);
								}else {
									System.out.println("Nombre no encontrado");
								}
							}else {
								System.out.println("No hay información de ninguna Persona");
							}
							
							break;
						case 2:
							System.out.println("Edad a buscar");
							edadABuscar = entrada.nextInt();
							entrada.nextLine();
							
						case 3:
							
							System.out.println("Localidad a buscar");
							localidadABuscar = entrada.nextLine();

						default:
							
					}
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
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
