package ProyectoIng_Version8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

//POR DONDE CULLONS ME HE QUEDADO: Hay que acabar la función que imprime el fichero.
//Acabar así mismo el caso 2 que hará la llamada a la función. 




public class Proyecto_Ing_V8_Main {


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

	/*public static void imprimirBase (Vector<>) {
		System.out.println(" Ancho de Banda " + " Throughput " + " "
				+ "Latencia " + " BER " + " Flujo de Datos ");
		for (int i=0; i<)
	}*/





	public static void main(String[] args) {

		//Vectores para el guardado de cada columna. PRUEBA
		int longitud=10;
		Vector<String> vectorAnchoBanda = new Vector<String>();
		longitud= vectorAnchoBanda.size();
		Vector<String> vectorThroughput = new Vector<String>();
		Vector<String> vectorLatencia = new Vector<String>();
		Vector<String> vectorBER = new Vector<String>();
		Vector<String> vectorFlujoDatos = new Vector<String>();



		//Opciones de menú
		System.out.println ("Seleccione un opción: ");
		System.out.println (" [1] Recolectar parámetros de la red.");
		System.out.println (" [2] Visualizar base de datos.");
		System.out.println (" [3] Buscar errores en la base de datos de la red.");
		System.out.println (" [4] Hacer filtrado de la base de datos.");
		System.out.println (" [5] Salir del programa.");


		Scanner sc = new Scanner (System.in);//Habilitar teclado
		while(!sc.hasNextInt()) { //Evaluación del tipo de variable introducida por el usuario
			System.out.println("ERROR");
			sc.next();
		}
		int menu = sc.nextInt(); //Lectura de la opción 


		switch (menu) {

		case 1:
			int repeticiones=5;
			Recolecta_parametros_clase miRunnable = new Recolecta_parametros_clase(repeticiones);
			Thread miThread = new Thread (miRunnable);
			miThread.start();
			break;
		case 2:
			String nombreArchivo = "BaseDatos_v8.csv";
			List<String[]>datos= leerArchivoCSV(nombreArchivo);

			//comprobamos la dimension del array, del fichero en cuestión
			int dimension = datos.size();
			System.out.println("Dimensión del ArrayList: " + dimension);

			//IMPRESIÓN DE LA BASE DE DATOS
			int indice=5;
			for (int i=0; i<indice;i++) {
				if (indice>=0&&indice<datos.size()) {
					String[]linea=datos.get(i);
					for(String dato:linea) {//Bucle for-each
						System.out.print(dato + "    ");
					}
					System.out.println();
				}else {
					System.out.println("El índice de línea es invalido.");
				}
			}
			break;
		case 3: 


		}





	}//Llave class

}//Llave main
