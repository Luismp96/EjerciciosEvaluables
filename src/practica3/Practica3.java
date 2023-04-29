package practica3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CLASE PRACTICA EVALUABLE 2.
 * 
 * @author Luis Martin Portillo.
 * @version 1.1.1
 */
public class Practica3 {

	/**
	 * @author Luis Martin Portillo.
	 * @param args - args necesario main
	 * @version 1.1.1
	 */
	public static void main(String[] args) {

		boolean fin = false;

		int opcionMenu, edadAux;
		int opcionMenuConsulta = 0;
		double media;
		String nombreAux;

		Scanner entrada = new Scanner(System.in);

		do {

			Funcionalidades.mostrarMenu();

			opcionMenu = entrada.nextInt();
			entrada.nextLine();

			switch (opcionMenu) {
			case 1:
				Funcionalidades.altaAlcalde(entrada);
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
		} while (!fin);
	}
}
