package ProyectoIng_Version8;

import java.util.Scanner;

//POR DONDE CULLONS ME HE QUEDADO: Hay que acabar la funci�n que imprime el fichero.
//Acabar as� mismo el caso 2 que har� la llamada a la funci�n. 




public class Proyecto_Ing_V8_Main {

	public static void imprimirBase (Vector<>) {
		System.out.println(" Ancho de Banda " + " Throughput " + " "
				+ "Latencia " + " BER " + " Flujo de Datos ");
		for (int i=0; i<)
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		//Opciones de men�
		System.out.println ("Seleccione un opci�n: ");
		System.out.println (" [1] Recolectar par�metros de la red.");
		System.out.println (" [2] Visualizar base de datos.");
		System.out.println (" [3] Buscar errores en la base de datos de la red.");
		System.out.println (" [4] Hacer filtrado de la base de datos.");
		System.out.println (" [5] Salir del programa.");
		
		
		Scanner sc = new Scanner (System.in);//Habilitar teclado
		while(!sc.hasNextInt()) { //Evaluaci�n del tipo de variable introducida por el usuario
			System.out.println("ERROR");
			sc.next();
		}
		int menu = sc.nextInt(); //Lectura de la opci�n 
		
		
		switch (menu) {
		
		case 1:
			int repeticiones=5;
			Recolecta_parametros_clase miRunnable = new Recolecta_parametros_clase(repeticiones);
			Thread miThread = new Thread (miRunnable);
			miThread.start();
			break;
		case 2:
			
			
		
		
		}
		
		
		
		
		
	}//Llave class

}//Llave main
