package practica1;

import java.util.Scanner;

public class Funcionalidades {
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void mostrarMenu() {
		System.out.println("MENU:");
		System.out.println("1 - AÑADIR ALCALDE/LOCALIDAD NUEVA.");
		System.out.println("2 - BUSCAR ALCALDE/EDAD/LOCALIDAD.");
		System.out.println("3 - MODIFICAR ALCALDE/EDAD.");
		System.out.println("4 - ELIMINAR LOCALIDAD/ALCALDE.");
		System.out.println("5 - CONSULTAR LISTA ALCALDES Y POBLACION DONDE GOBIERNA.");
		System.out.println("6 - SALIR.");
	}
	
	public static int contarGuardados(String[] nombres){
		
		int i=0;
		
		do {
			if(nombres[i] != null) {
				i++;
			}
		}while(nombres[i] != null);
			
		return i;
	}
	
	public static void addPersona(String nombre, int edad, String localidad,int posicion,String[] nombres, int[] edades,String[] localidades) {
		
		nombres[posicion] = nombre;
		edades[posicion] = edad;
		localidades[posicion] = localidad;
		
	}
	
	public static int buscarXNombre(String nombre, String[] nombresArray) {
		
		boolean encontrado = false;
		boolean finArray = false;
		int posicion = -1;
		int i = 0;
		
		do {
			
			if (nombresArray[i] != null) {
				if (nombresArray[i].equalsIgnoreCase(nombre)){
					posicion= i;
					encontrado = true;
				}
			}else {
				finArray = true;
			}
			i++;
			
		}while(!encontrado && !finArray);
		
		return posicion;
	}
	
	public static int buscarXEdad(int edad, int[] edadesArray) {
		
		boolean encontrado = false;
		boolean finArray = false;
		int posicion = -1;
		int i = 0;
		
		do {
			if (edadesArray[i] != 0){
				if (edadesArray[i] == edad){
					encontrado = true;
					posicion = i;
				}
			}else {
				finArray = true;
			}
			i++;
			
		}while(!encontrado && !finArray);
		
		return posicion;
	}
	
	public static int buscarXLocalidad(String localidad, String[] localidadesArray) {
		
		boolean encontrado = false;
		boolean finArray = false;
		int posicion = -1;
		int i = 0;
		
		do {
			if (localidadesArray[i] != null) {
				if (localidadesArray[i].equalsIgnoreCase(localidad)){
					encontrado = true;
					posicion = i;
				}
			}else {
				finArray = true;
			}
			i++;
			
		}while(!encontrado && !finArray);
		
		return posicion;
	}
	
	public static void correrPosiciones(int posicion,String[] nombres,int[] edades,String[] localidades) {
		
		boolean finDatos = false;
		int siguiente = posicion + 1;
		
		
		if (nombres[siguiente] != null)
			do {
				nombres[posicion] = nombres[siguiente];
				edades[posicion] = edades[siguiente];
				localidades[posicion] = localidades[siguiente];
				
				nombres[siguiente] = null;
				edades[siguiente] = 0;
				localidades[siguiente] = null;
				
				posicion++;
				siguiente++;
				
				if (nombres[siguiente] == null) {
					finDatos = true;
				}
			
			}while(!finDatos);
		
	}
	

}