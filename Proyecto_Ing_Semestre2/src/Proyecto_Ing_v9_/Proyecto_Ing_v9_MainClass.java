package Proyecto_Ing_v9_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Proyecto_Ing_v9_.Proyecto_Ing_v9_AlertasClass;
import Proyecto_Ing_v9_.Proyecto_Ing_v9_RecolectaParametrosClass;

public class Proyecto_Ing_v9_MainClass {

	//Función de lectura del Archivo de datos
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
		String nombreArchivo = "BaseDatos_v9.2.csv";

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
			Proyecto_Ing_v9_RecolectaParametrosClass miRunnable = new Proyecto_Ing_v9_RecolectaParametrosClass(repeticiones);
			Thread miThread = new Thread (miRunnable);
			miThread.start();
			break;
		case 2:
			List<String[]>datos= leerArchivoCSV(nombreArchivo);

			//comprobamos la dimension del array, del fichero en cuestión
			int dimension = datos.size();
			System.out.println("Dimensión del ArrayList: " + dimension);

			//IMPRESIÓN DE LA BASE DE DATOS
			int indice=4;
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
			try {
				//Declaramos las variables que almacenarán los valores de las columnas del fichero
				float[][] matrizFloat = null;
				boolean primeraLineaLeida = false;//Si no usamos esta bandera, con el while sobreescribimos siempre la primera linea. De esta manera nos aseguramos de leer la primera linea

				try {
					BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo)); 
					//Almacenan cada linea y fila del fichero mientras se lee:
					String linea;
					int fila = 0;
					//Iniciamos un blucle que se ejecuta mientras haya líneas que leer.
					while ((linea = reader.readLine()) != null) {
						String[] valores = linea.split(";");//Dividimos cada línea en subcadenas, y se almacenan en el Array: valores (separa linea en columnas)
						//Verificamos si se ha leido la primera línea
						if (!primeraLineaLeida) {
							matrizFloat = new float[valores.length][];//Instanciamo longitud de la columna (que no de la fila)
							primeraLineaLeida = true;
						}
						//Recorremos los valores de la línea y los incluimos en el Array de columnas. Además de evaluarlos.
						for (int columna = 0; columna < valores.length; columna++) {
							if (columna < matrizFloat.length) {
								if (matrizFloat[columna] == null) {
									matrizFloat[columna] = new float[valores.length];
								}
								matrizFloat[columna][fila] = Float.parseFloat(valores[columna]);
								if (matrizFloat[columna][fila] >= 700 && matrizFloat[columna][fila] <= 800) {
									System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
								}
							} 
						}
						fila++;
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			finally {

			}

			/*	Map<String,List<String>> Vector= Proyecto_Ing_v9_AlertasClass.separarDatosCSV("BaseDatos_v9.csv");

			//System.out.println(Vector);
			//Lista que ordena las entradas del mapa
			List<Map.Entry<String, List<String>>> entradasOrdenadas = new ArrayList<>(Vector.entrySet());
	        entradasOrdenadas.sort(Map.Entry.comparingByKey());

	        String [] miVector;
	        int i;
			for (Map.Entry<String,List<String>>entry:entradasOrdenadas) {
				String componente=entry.getKey();
				List<String>datos1=entry.getValue();

				if (componente=="Ancho de Banda") {
					//System.out.println(datos1);
				 List<String>listaSubelementos= Proyecto_Ing_v9_AlertasClass.dividirElementos(datos1);
				 List<Float> listaFlotantes = new ArrayList<>();	
				 for (String subelementos : listaSubelementos) {
						float numero = Float.parseFloat(subelementos);
						float [] listaNumeros = new float[4];
						//listaFlotantes.add(numero+";");
			 */	
			//System.out.print(numero + ";");
			/*if (subelementos>=880) {
							System.out.println("ERROR EN ANCHO DE BANDA");
						}*/
			/*		}

				}
				if (componente=="BER") {
					 System.out.println("aaaaaaaaaaak");
					}
			}*/

			/*for (int i = 0; i < Vector.length; i++) {
				if (Vector[i]==Vector[0]) {//anchobanda
					float [] vectorABfloat = new float [Vector.length];
					//vectorABfloat[0]=Float.parseFloat(Vector[0]);

					for (int j=1;i<Vector.length;j++) {
						vectorABfloat[j]=Float.parseFloat(Vector[j]);
						System.out.println(Vector[j]);
					}

					for (int j=1;j<Vector.length;j++) {
						if (vectorABfloat[j]<= 882f) {
							System.out.println("ERROR");
						}
						else {
							System.out.println("El ancho de banda está en valores normales.");
						}
					}
			 */

			//break;

		case 4:


		}

}//Llave main

}//Llave class
