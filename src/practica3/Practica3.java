package practica3;

import java.util.ArrayList;
import java.util.Scanner;

import practica3.Funcionalidades;

/**
 * CLASE PRACTICA EVALUABLE 3.
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

		double media = 0;
		int opcionMenu;
		int opcionMenuConsulta = 0;
		ArrayList<Alcalde> listaResultados = new ArrayList<Alcalde>();

		Scanner entrada = new Scanner(System.in);

		//SE MOSTRARA EL MENU HASTA QUE EL USUARIO DECIDA FINALIZAR LA APLICACION.
		do {

			Funcionalidades.mostrarMenu();

			opcionMenu = entrada.nextInt();
			entrada.nextLine();

			switch (opcionMenu) {
			
			//OPCION ALTA ALCALDE.
			case 1:
				Funcionalidades.altaAlcalde(entrada);
				break;
			//OPCION DE BUSQUEDA.
			case 2:
				opcionMenuConsulta = Funcionalidades.procesoConsulta(entrada);
			    
				switch (opcionMenuConsulta) {
					case 1:	
						listaResultados = Funcionalidades.buscarPorNombre(entrada);
						
						for(Alcalde alcaldeX : listaResultados) {
							System.out.println(alcaldeX.toString());
						}
						
						break;	
					case 2:
						
						listaResultados = Funcionalidades.buscarPorEdad(entrada);
						
						for(Alcalde alcaldeX : listaResultados) {
							System.out.println(alcaldeX.toString());
						}
						break;
					case 3:
						
						listaResultados = Funcionalidades.buscarPorLocalidad(entrada);
						
						for(Alcalde alcaldeX : listaResultados) {
							System.out.println(alcaldeX.toString());
						}
						
						break;
					case 4:
					    media = Funcionalidades.calcularMedia();
					    
					    if (media > 0){
							   System.out.println("********************************************" );
							   System.out.println("* LA MEDIA DE EDAD ES DE " + media + " AÑOS." );
							   System.out.println("********************************************" );
						   }
						break;
					case 5:
						listaResultados = Funcionalidades.ordenarPorEdad();
						
						for(Alcalde alcaldeX : listaResultados) {
							System.out.println(alcaldeX.toString());
						}
						
						break;	
					case 6:
					    listaResultados = Funcionalidades.consultarTodo();
					    
					    for(Alcalde alcaldeX : listaResultados) {
							System.out.println(alcaldeX.toString());
						}
						break;
					case 7:	
						Funcionalidades.consultarLocalidades();
						break;
					default:
						System.out.println("OPCION NO VALIDA");
						break;
				}
				break;
			//OPCION DE MODIFICACION.
			case 3:
				Funcionalidades.modificarRegistro(entrada);
				break;
			//OPCION DE BORRADO.
			case 4:
				Funcionalidades.eliminarRegistro(entrada);
				break;
			//OPCION FIN.
			case 5:
				Funcionalidades.finApp();
				fin = true;
				break;
			//OTRA OPCION.
			default:
	
				System.out.println("*****************************************");
				System.out.println("* OPCION NO VALIDA, INTENTELO DE NUEVO. *");
				System.out.println("*****************************************");
				break;
			}
			
		} while (!fin);
	}
}
