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
		System.out.println("5 - CONSULTAR LISTA PERSONAS.");
		System.out.println("6 - SALIR.");
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
	public static int correrPosiciones(int posicion,String[] nombres,int[] edades,String[] localidadesArray) {
		
		boolean encontrado = false;
		
		return posicion;
	}
	

	}
