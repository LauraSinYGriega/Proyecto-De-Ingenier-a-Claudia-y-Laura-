package Proyecto_Ing_v12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Proyecto_Ing_v12_classMain implements Runnable {
	//INSTANCIACIÓN DE VARIABLES GENERALES
	private static final String nombreArchivoRAW = "BaseDatosRAW_v12.csv";
	private static final String nombreArchivoOficial = "BaseDatosOficial_v12.csv";
	private static int repeticiones;//función para poder utilizar la variable repeticiones y también usarla en el main
	public Proyecto_Ing_v12_classMain (int repeticiones) {
		this.repeticiones=repeticiones;
	} 
	//MÉTODO QUE GENERA VALORES ALEATORIOS CON DECIMALES - FLOAT: Ancho de Banda, Throughput
	public static String generaRandomFLOAT() {
		Random random = new Random();
		float anchoBanda = random.nextFloat()*(1000-20 +1)+20;
		float throughput = random.nextFloat()*(1000-20 +1)+20;
		return anchoBanda + ";" + throughput;
	}   
	//MÉTODO QUE GENERA VALORES ALEATORIOS ENTEROS: Latencia, BER y Flujo de Datos (además, añade los decimales)
	public static String generaRandomINTyFLOAT() {
		Random random = new Random();
		String llamadaDatosFloat = generaRandomFLOAT();
		int latencia = random.nextInt(500-0 +1)+0;
		int BER = random.nextInt(10-0 +1)+0;
		int FlujoDatos = random.nextInt(1-0 +1)+0;
		return llamadaDatosFloat + ";" + latencia+ ";" + BER + ";" + FlujoDatos;
	}
	//MÉTODO RUNNABLE CREACCIÓN DE BASE DE DATOS (se guardan los valores aleatorios)
	@Override
	public void run() {
		for (int i=0; i<repeticiones;i++) {
			try {
				Thread.sleep(1000);
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoRAW,true))) {
					File fichero = new File (nombreArchivoRAW);
					if (!fichero.exists()) {
						fichero.createNewFile();
					}
					int x=0;
					/*if (i == 0) {
						bw.write("\r\n");// Imprimir línea en blanco solo en la primera iteración
					}*/
					//Genera un vector con los datos
					Vector<String> v = new Vector<String>();
					v.add(new String (generaRandomINTyFLOAT()));
					String Guardado = " ";//datos por posiciones
					Guardado=v.get(x);//Llamada a cada vector
					bw.write(Guardado + "\r\n");
					LocalDateTime horaActual = LocalDateTime.now();
					ArchivoCSVoficial (nombreArchivoRAW, nombreArchivoOficial, horaActual);
					bw.close();
					x++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};//cierre 
	//MÉTODO DE LECTURA DE LA BASE DE DATOS EN RAW (crudo, solo valores)
	public static List<String[]> leerArchivoCSV(String nombreArchivoOriginal){
		List<String[]> datos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader (new FileReader(nombreArchivoOriginal))){
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

	//MÉTODO DE GUARDADO DE LA BASE DE DATOS OFICIAL (incluye cabeceras, horas, valores)
	public static void ArchivoCSVoficial (String nombreArchivoRAW, String nombreArchivoOficial, LocalDateTime hora) {
		try (BufferedWriter bw = new BufferedWriter (new FileWriter(nombreArchivoOficial))){
			String [] nombreCabeceras = {" Fecha / Hora;"  + "Ancho de Banda;", "Throughput;" , "Latencia;", "BER;", "Flujo de Datos"};
			for (int i=0;i<5;i++) { 
				bw.write(nombreCabeceras [i] + "  ");
			}
			bw.newLine();
			//Llamada del fichero RAW de valores
			try (BufferedReader br = new BufferedReader (new FileReader(nombreArchivoRAW))){
				String line;
					while ((line=br.readLine())!=null) {
						if (!line.isEmpty()){
							bw.write(hora.toString() + ";" + line);
							bw.newLine();
						}
						/*bw.write(hora.toString() + ";" + line);
						bw.newLine(); */
					}
				
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	//MÉTODO QUE GENERA LAS ALERTAS
	public static float [][] buscarAlertas (String nombreArchivoRAW){
		float[][] matrizFloat = null;
		boolean primeraLineaLeida = false;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivoRAW));
			String linea;
			int fila = 0;

			while ((linea = reader.readLine()) != null) {
				String[] valores = linea.split(";");
				if (!primeraLineaLeida) {
					matrizFloat = new float[valores.length][];
					primeraLineaLeida = true;
				}

				for (int columna = 0; columna < valores.length; columna++) {
					if (columna < matrizFloat.length) {
						if (matrizFloat[columna] == null) {
							matrizFloat[columna] = new float[valores.length];
						}
						matrizFloat[columna][fila] = Float.parseFloat(valores[columna]);
						switch (columna) {
						case 0:
							if (matrizFloat[columna][fila] >= 882f) {
								System.out.println("La red ha superado el 90% de uso de su ancho de banda. Ha podido presentar problemas en este momento: " + matrizFloat[columna][fila]);
							}
							break;
						case 1:
							if (matrizFloat[columna][fila] <= 480f) {
								System.out.println("El throughput es elevado, la conexión puede que se realentice en este momento: " + matrizFloat[columna][fila]);
							}
							break;
						case 2:
							if (matrizFloat[columna][fila] > 100) {
								System.out.println("La latencia ha superado los 100 ms en este momento: " + matrizFloat[columna][fila]+ ". La conexión no es estable.");
							}
							break;
						case 3:
							if (matrizFloat[columna][fila] >= 20 && matrizFloat[columna][fila] <= 1000) {
								System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
							}
							break;
						case 4:
							if (matrizFloat[columna][fila] == 1) {
								System.out.println("La red está totalmente ocupada durante este momento de medición: " + matrizFloat[columna][fila]);
							}
							break;
						}
					}
				}
				fila++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matrizFloat;
	}
	//MÉTODO QUE REALIZA EL FILTRADO DE LOS VALORES QUE SOLICITE EL USUARIO
	public static Map<String, String[]> filtrarParametro(String nombreArchivoRAW) {
		Map<String, String[]> columnas = new HashMap<>();
		String [] nombresColumnas=null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivoRAW));
			String linea;

			if ((linea = reader.readLine()) != null) {
				nombresColumnas = linea.split(";");
				for (String nombreColumna : nombresColumnas) {
					columnas.put(nombreColumna, new String[0]);
				}
			}

			while ((linea = reader.readLine()) != null) {
				String[] valores = linea.split(";");
				for (int i = 0; i < valores.length; i++) {
					String columna = nombresColumnas[i];
					String[] datosColumna = columnas.get(columna);
					String[] nuevosDatosColumna = new String[datosColumna.length + 1];
					System.arraycopy(datosColumna, 0, nuevosDatosColumna, 0, datosColumna.length);
					nuevosDatosColumna[datosColumna.length] = valores[i];
					columnas.put(columna, nuevosDatosColumna);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return columnas;
	}

	//MÉTODO PARA BORRAR LAS BASES DE DATOS
	private static void borrarDatosFichero(File fichero) {
		try {
			// Crear un objeto FileWriter en modo de escritura para borrar los datos
			FileWriter writer = new FileWriter(fichero);
			writer.write("");//Escribir una cadena vacía en el fichero
			writer.close();
		} catch (IOException e) {
			System.out.println("Error al borrar los datos del fichero " + fichero.getName() + ": " + e.getMessage());
		}
	}


	public static void main(String[] args) {
		boolean salirUsuario=false;
		while (salirUsuario==false){
			boolean salirMenusIndividuales=true;//Bandera que permite salir de cada opción
			while(salirMenusIndividuales==true) {
				//Opciones de menú
				System.out.println ();
				System.out.println ("Seleccione un opción: ");
				System.out.println (" [1] Recolectar parámetros de la red.");
				System.out.println (" [2] Visualizar base de datos.");
				System.out.println (" [3] Buscar errores en la base de datos de la red.");
				System.out.println (" [4] Hacer filtrado de la base de datos.");
				System.out.println (" [5] Salir del programa.");
				System.out.println (" [6] Borrar la Base de Datos de la red.");

				Scanner sc = new Scanner (System.in);//Habilitar teclado
				while(!sc.hasNextInt()) { //Evaluación del tipo de variable introducida por el usuario
					System.out.println("ERROR");
					sc.next();
				}
				int menu = sc.nextInt(); //Lectura de la opción 

				switch (menu) {
				case 1:
					repeticiones=5;
					Proyecto_Ing_v12_classMain miRunnable = new Proyecto_Ing_v12_classMain(repeticiones);
					Thread miThread = new Thread (miRunnable);
					miThread.start();
					//ArchivoCSVoficial(nombreArchivoRAW, nombreArchivoOficial);
					salirMenusIndividuales=false;
					break;
				case 2:
					List<String[]>datos= leerArchivoCSV(nombreArchivoOficial);

					//comprobamos la dimension del array, del fichero en cuestión
					int dimension = datos.size();
					System.out.println("Dimensión del ArrayList: " + dimension);
					
					
					int indice = Math.min(repeticiones, datos.size());
					for (int i = 0; i < indice; i++) {
						String[] linea = datos.get(i);
						for (String dato : linea) {
							System.out.print("   " + dato + "   ");
						}
						System.out.println();
					}


					//IMPRESIÓN DE LA BASE DE DATOS
					indice=dimension-1;
					for (int i=0; i<=indice;i++) {
						if (indice>=0&&indice<datos.size()) {
							String[]linea=datos.get(i);
							for(String dato:linea) {//Bucle for-each
								System.out.print("    " + dato + "    ");
							}
							System.out.println();
						}else {
							System.out.println("El índice de línea es invalido.");
						}
					}
					salirMenusIndividuales=false;
					break;
				case 3: 
					float [][] matrizFloat = buscarAlertas(nombreArchivoRAW);
					salirMenusIndividuales=false;
					break;
				case 4:
					boolean salirBuscador = true;
					int menuBuscador = 0;
					while (salirBuscador==true) {
						System.out.println ();
						System.out.println(" ¿Que parámetro desea filtrar?");
						System.out.println("[1] Ancho de Banda");
						System.out.println("[2] Throughput ");
						System.out.println("[3] Latencia ");
						System.out.println("[4] BER ");
						System.out.println("[5] Flujo de Datos ");
						System.out.println("[6] Salir del Buscador ");
						System.out.println();
						System.out.println("Intoduzca el índice de parámetro: ");
						sc = new Scanner (System.in); //Habilitar teclado
						while(!sc.hasNextInt()) { //Evaluación del tipo de variable introducida por el usuario 
							System.out.println("ERROR");
							sc.next();
						}
						menuBuscador = sc.nextInt (); //Lectura de la Opción
						String nombreFiltrado = " ";
						switch (menuBuscador) {
						case 1:
							nombreFiltrado="Ancho de Banda";
							break;
						case 2:
							nombreFiltrado="Throughput";
							break;
						case 3:
							nombreFiltrado="Latencia";
							break;
						case 4:
							nombreFiltrado="BER";
							break;
						case 5:
							nombreFiltrado="Flujo de Datos";
							break;
						case 6:
							salirBuscador=false;
						}
						Map<String,String[]>columnas=filtrarParametro (nombreArchivoRAW);

						if (columnas.containsKey(nombreFiltrado)) {
							String[] columnaEjemplo = columnas.get(nombreFiltrado);
							for (String dato : columnaEjemplo) {
								System.out.println(dato);
							}
						} else {
							System.out.println("La columna especificada no existe en el archivo.");
						}
					}//while salirBuscador
					salirMenusIndividuales=false;
					break;
				case 5:
					salirMenusIndividuales=false;
					salirUsuario = true;
					System.out.println("Programa terminado...");
					salirMenusIndividuales=false;
					break;
				case 6:
					//Crear objetos File para representar los ficheros
					File ficheroRAW = new File(nombreArchivoRAW);
					File ficheroORIGINAL = new File(nombreArchivoOficial);
					//Borrar los datos de los ficheros
					borrarDatosFichero(ficheroRAW);
					borrarDatosFichero(ficheroORIGINAL);
					System.out.println("Los datos de los ficheros se han borrado correctamente.");
					salirMenusIndividuales=false;
					break;
				default:
					System.out.println("ERROR \n");
					break;
				}//switch menu (opciones de menú)
			}//while salir de cada menu: (boolean salirMenusIndividuales)
		}//while salir cuando el usuario indique que quiere salir: (boolean salirUsuario)


	}//main

}//class


