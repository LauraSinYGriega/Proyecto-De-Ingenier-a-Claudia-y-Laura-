package ProyectoIng_Version2;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/*ESPECIFICACIONES DE LA VERSI�N:
 * Se implementa en la creacci�n del fichero la funci�n de hacer guardados de manera peri�dica.
 * Se usan Threads-Hilos
 */

public class Proyecto_Ing_V2_Main {

	//Funci�n gen�rica para generar n�meros aleatorios FLOAT (Usada en: Ancho de Banda; Throughput; Latencia):
	public static float generaNumAleatorioFLOAT (float minimo, float maximo) {
		return (float)(Math.random()*(minimo-(maximo+1))+(maximo+1));
	}//llave (aleatorios con decimales)

	//Funci�n gen�rica para generar n�meros aleatorios INT (Usada en: Tasa de error de bits/BER ; Tr�fico de Datos/Flujo de Datos):
	public static int generaNumAleatorioINT (int minimo, int maximo) {
		return (int)(Math.random()*(minimo-(maximo+1))+(maximo+1));
	}//llave (aleatorios int)


	public static void main(String[] args) {	


		////BLOQUE DE CONSTRUCCI�N DE VALORES ALEATORIOS////

		//ANCHO DE BANDA
		float minAnchoBanda=20;
		float maxAnchoBanda=1000;
		float valorAnchoBanda=generaNumAleatorioFLOAT(minAnchoBanda,maxAnchoBanda);
		System.out.println ("El Ancho de Banda es " + valorAnchoBanda + " Mbps.");	
		//THROUGHPUT
		float minThroughput=20;
		float maxThroughput=1000;
		float valorThroughput=generaNumAleatorioFLOAT(minThroughput,maxThroughput);
		System.out.println ("El Throughput es " + valorThroughput + " Mbps.");	
		//LATENCIA
		float minLatencia=0;
		float maxLatencia=500;
		float valorLatencia=generaNumAleatorioFLOAT(minLatencia,maxLatencia);
		System.out.println ("La Latencia es de " + valorLatencia + " miliSegundos(ms).");	
		//TASA DE ERROR DE BITS (BER) **************************NO ACABADO, SERIAS DUDAS********************************************
		int minBER=0;
		int maxBER=0;
		int valorBER = generaNumAleatorioINT(minBER,maxBER);
		System.out.println ("La Tasa de Error de Bits es de " + valorBER + "%.");
		//TR�FICO DE DATOS O FLUJO DE DATOS
		int minFlujoDatos=0;
		int maxFlujoDatos=1;
		int valorFlujoDatos = generaNumAleatorioINT(minFlujoDatos,maxFlujoDatos);
		System.out.println ("El Tr�fico de Datos es de " + valorFlujoDatos + " erlang/horas.");


		////BLOQUE DE CREACCI�N DE FICHERO CSV////

		//Llamado al fichero (previamente creado): 'prueba.csv'
		FileWriter fichero=null;
		//Estructura try-catch para asegurar que no hay fallas en el llamado del fichero.
		try {
			fichero = new FileWriter ("prueba.csv");
			//Declaramos un Array de nombres para guardarlo en el fichero como cabeceras.
			String [] cabeceraNombres = {" Ancho de Banda ", " Throughput ", " Latencia ", " BER ", " Flujo de Datos"};
			//Bucle que escribe las cabeceras:
			for (int i=0;i<5;i++) { 
				fichero.write(cabeceraNombres [i] + "    ");
			}
			fichero.write("\n"); //pasamos a la siguiente l�nea en el fichero.
			//Declaramos un Array con los elementos generados aleatoriamente.
			float [] Datos= {valorAnchoBanda, valorThroughput, valorLatencia, valorBER, valorFlujoDatos};
			//Bucle que escrie los par�metros:
			for (int i=0; i<5; i++) {
				fichero.write(Datos[i] + "    ");
			}
			fichero.close(); //cerramos el stream
		} catch (Exception e) { 
			System.out.println ("Se ha producido un error."); 
		}//fin catch

		//Lectura del fichero CSV
		try {
			FileReader historial = new FileReader ("prueba.csv");
			System.out.println("... Se lee el fichero ...");
			Scanner lectura = new Scanner(historial); // Configura para leer de fichero
			while(lectura.hasNextLine()) { 
				String linea= lectura.nextLine(); // Guardar en String
				System.out.println(linea); // Imprimimos l�nea
			}
			lectura.close();//cerramos fichero
		} catch(Exception ex) { 
			System.out.println("ERROR");
		}


		////BLOQUE DE EVALUACI�N DE VALORES////

		//ANCHO DE BANDA (variable: valorAnchoBanda)
		//THROUGHPUT (variable: valorThroughput)
		//LATENCIA (variable: valorLatencia)
		//TASA DE ERROR DE BITS (BER) (variable: valorBER)
		//TR�FICO DE DATOS O FLUJO DE DATOS (variable: valorFlujoDatos)


		////BLOQUE DE FILTRADO/AN�LISIS DE FICHERO////










	}//Llave del main

}//Llave de la class
