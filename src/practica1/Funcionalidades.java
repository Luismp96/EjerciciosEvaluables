package practica1;

import java.util.Scanner;

public class Funcionalidades {
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void mostrarMenu() {
		System.out.println("MENU:");
		System.out.println("1 - AÑADIR PERSONA.");
		System.out.println("2 - BUSCAR PERSONA.");
		System.out.println("3 - MODIFICAR PERSONA.");
		System.out.println("4 - ELIMINAR PERSONA.");
		System.out.println("5 - SALIR.");
	}
	
	public static int contarGuardados(String[] nombres){
		
		int i=0;
		
		System.out.println("contarGuardados");
		
		do {
			if(nombres[i] != null) {
				i++;
			}
		}while(nombres[i] != null);
			
		return i;
	}
	
	public static void addPersona(String nombre, int edad, String localidad,int posicion,String[] nombres, int[] edades,String[] localidades) {
		
		System.out.println("addPersona");
		
		nombres[posicion] = nombre;
		edades[posicion] = edad;
		localidades[posicion] = localidad;
		
	}
	
	public static int buscarXNombre(String nombre, String[] nombresArray) {
		
		boolean encontrado = false;
		int posicion = -1;
		int i = 0;
		
		do {
			if (nombresArray[i].equalsIgnoreCase(nombre)){
				encontrado = true;
				posicion = i;
			}
			
			i++;
			
		}while(!encontrado);
		
		return posicion;
	}
	

}
