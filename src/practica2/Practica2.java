package practica2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CLASE PRACTICA EVALUABLE 2.
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */
public class Practica2 {

	/**
	 * @author Luis Martin Portillo.
	 * @param args - args necesario main
	 * @version 1.1.1
	 */
	public static void main(String[] args) {

		boolean fin = false;
		
		int opcionMenu,edadAux;
		int opcionMenuConsulta = 0;
		double media;
		String nombreAux;
		
		ArrayList<Alcalde> alcaldes= new ArrayList<Alcalde>();
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			Funcionalidades.mostrarMenu();
			
			opcionMenu = entrada.nextInt();
			entrada.nextLine(); 
			
			switch (opcionMenu) {
				case 1:
					
					nombreAux = Funcionalidades.pedirNombre(entrada);
					edadAux = Funcionalidades.pedirEdad(entrada);	
					
					Funcionalidades.altaAlcalde(alcaldes,nombreAux,edadAux,entrada);
					
					break;
				case 2:
					
					opcionMenuConsulta = Funcionalidades.procesoConsulta(entrada);
				    
					switch (opcionMenuConsulta) {
						case 1:
							
							Funcionalidades.buscarPorNombreMenu(entrada, alcaldes);
							break;
							
						case 2:
							
							Funcionalidades.buscarPorEdadMenu(entrada, alcaldes);
							break;
							
						case 3:
							Funcionalidades.buscarPorLocalidadMenu(entrada,alcaldes);
							break;
						case 4:
							media = Funcionalidades.calcularMedia(alcaldes);
							
							System.out.println("******************************************");
							System.out.println("* LA MEDIA DE EDAD ES DE " + media + " AÑOS. *");
							System.out.println("******************************************");
							break;
						case 5:
							
							Funcionalidades.ordenarAlcaldesPorEdad(alcaldes);
							break;
							
						case 6:
							Funcionalidades.mostrarTodo(alcaldes);
							break;
							
						case 7:	
							
							Funcionalidades.mostrarLocalidades(alcaldes);
							break;
						default:
							
							System.out.println("OPCION NO VALIDA");
							break;
					}
	
					break;
				case 3:
					Funcionalidades.modificarRegistro(entrada,alcaldes);
					break;
				case 4:
					Funcionalidades.eliminarRegistro(entrada,alcaldes);
					break;
				case 5:
					fin = true;
					break;
				default:
		
					System.out.println("*****************************************");
					System.out.println("* OPCION NO VALIDA, INTENTELO DE NUEVO. *");
					System.out.println("*****************************************");
					break;
		    }
			
		}while(!fin);
		
		//* SE CIERRA EL SCANNER
		entrada.close();
		
		Funcionalidades.finalizarApp();
		
	}

}
