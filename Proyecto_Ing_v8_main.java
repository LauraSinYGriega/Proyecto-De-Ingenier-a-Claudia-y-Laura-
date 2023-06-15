package ProyectoIng_v8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import ProyectoIng_v8.Generar_Alertas_v8_class;
import ProyectoIng_v8.Recolecta_Parametros_class_v8;

/*ESPECIFICACIONES DE  LA VERSI�N: Esta versi�n implementa los 3 primeros men�s. El men� 3 est� incacabado, solo imprime por comonentes con 
el m�todo map. No est� arreglado el problema de las cabeceras.*/

public class Proyecto_Ing_v8_main {

	public static List<String[]> leerArchivoCSV(String nombreArchivo){
		List<String[]> datos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader (new FileReader(nombreArchivo))){
			String linea;
			while ((linea=br.readLine())!=null) {
				String[]fila=linea.split(";");
				datos.add(fila);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}


	
	public static void main(String[] args) {

		//Vectores para el guardado de cada columna. PRUEBA
		int longitud=10;
		Vector<String> vectorAnchoBanda = new Vector<String>();
		longitud= vectorAnchoBanda.size();
		Vector<String> vectorThroughput = new Vector<String>();
		Vector<String> vectorLatencia = new Vector<String>();
		Vector<String> vectorBER = new Vector<String>();
		Vector<String> vectorFlujoDatos = new Vector<String>();

		//Variables utilizadas a lo largo del programa:
		String nombreArchivo = "BaseDatos_v8.2.csv";

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
			Recolecta_Parametros_class_v8 miRunnable = new Recolecta_Parametros_class_v8(repeticiones);
			Thread miThread = new Thread (miRunnable);
			miThread.start();
			break;
		case 2:
			//String nombreArchivo = "BaseDatos_v8.2.csv";
			List<String[]>datos= leerArchivoCSV(nombreArchivo);

			//comprobamos la dimension del array, del fichero en cuesti�n
			int dimension = datos.size();
			System.out.println("Dimensi�n del ArrayList: " + dimension);

			//IMPRESI�N DE LA BASE DE DATOS
			int indice=4;
			for (int i=0; i<indice;i++) {
				if (indice>=0&&indice<datos.size()) {
					String[]linea=datos.get(i);
					for(String dato:linea) {//Bucle for-each
						System.out.print(dato + "    ");
					}
					System.out.println();
				}else {
					System.out.println("El �ndice de l�nea es invalido.");
				}
			}
			break;
		case 3: 
			Generar_Alertas_v8_class procesado = new Generar_Alertas_v8_class();//Creamos la instancia de la clase
	        procesado.procesarArchivoCSV(nombreArchivo);//Llamado al m�todo para procesar el archivo pasando por la ruta
	        break;
	        
		case 4:


		}





	}//Llave class

}//Llave main
