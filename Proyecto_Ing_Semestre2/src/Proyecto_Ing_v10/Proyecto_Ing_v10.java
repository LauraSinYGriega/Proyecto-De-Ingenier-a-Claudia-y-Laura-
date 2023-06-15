package Proyecto_Ing_v10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Proyecto_Ing_v10 implements Runnable {



	//INSTANCIACIÓN DE VARIABLES GENERALES
	private static String nombreArchivo = "BaseDatos_v10.csv";
	private static int repeticiones;//función para poder utilizar la variable repeticiones y también usarla en el main
	public Proyecto_Ing_v10 (int repeticiones) {
		this.repeticiones=repeticiones;
	} 

	//Función que genera valores aleatorios con decimales: Ancho de Banda, Throughput y Latencia
	public static String generaRandomFLOAT() {
		Random random = new Random();
		float anchoBanda = random.nextFloat()*(1000-20 +1)+20;
		float throughput = random.nextFloat()*(1000-20 +1)+20;
		return anchoBanda + ";" + throughput;
	}   

	//Función que genera valores aleatorios enteros: BER y Flujo de Datos (además, añade la primera función de valores con decimales)
	public static String generaRandomINTyFLOAT() {
		Random random = new Random();
		String llamadaDatosFloat = generaRandomFLOAT();
		int latencia = random.nextInt(500-0 +1)+0;
		int BER = random.nextInt(10-0 +1)+0;
		int FlujoDatos = random.nextInt(1-0 +1)+0;
		return llamadaDatosFloat + ";" + latencia+ ";" + BER + ";" + FlujoDatos;
	}

	//Función runnable que genera y guarda parámetros cada x tiempo en un archivo csv.
	@Override
	public void run() {
		for (int i=0; i<repeticiones;i++) {
			try {
				Thread.sleep(1000);
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo,true))) {
					File fichero = new File (nombreArchivo);
					if (!fichero.exists()) {
						fichero.createNewFile();
					}
					int x=0;
					//Genera un vector con los datos
					Vector<String> v = new Vector<String>();
					v.add(new String (generaRandomINTyFLOAT()));
					String Guardado = " ";//datos por posiciones
					Guardado=v.get(x);//Llamada a cada vector
					bw.write(Guardado + "\r\n"); 
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


	//FUNCIÓN QUE GENERA LAS ALERTAS
	public static float [][] buscarAlertas (String nombreArchivo){
		float[][] matrizFloat = null;
		boolean primeraLineaLeida = false;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
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
								System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
							}
							break;
						case 1:
							if (matrizFloat[columna][fila] <= 480f) {
								System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
							}
							break;
						case 2:
							if (matrizFloat[columna][fila] > 100) {
								System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
							}
							break;
						case 3:
							if (matrizFloat[columna][fila] >= 20 && matrizFloat[columna][fila] <= 1000) {
								System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
							}
							break;
						case 4:
							if (matrizFloat[columna][fila] == 1) {
								System.out.println("En la fila " + fila + ", la columna " + columna + " contiene un número entre 20 y 30: " + matrizFloat[columna][fila]);
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

	//Función que realiza el filtrado del parámetro a solicitud de usuario
	public static Map<String, String[]> filtrarParametro(String nombreArchivo) {
		Map<String, String[]> columnas = new HashMap<>();
		String [] nombresColumnas=null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
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

				Scanner sc = new Scanner (System.in);//Habilitar teclado
				while(!sc.hasNextInt()) { //Evaluación del tipo de variable introducida por el usuario
					System.out.println("ERROR");
					sc.next();
				}
				int menu = sc.nextInt(); //Lectura de la opción 

				switch (menu) {

				case 1:
					repeticiones=5;
					Proyecto_Ing_v10 miRunnable = new Proyecto_Ing_v10(repeticiones);
					Thread miThread = new Thread (miRunnable);
					miThread.start();
					salirMenusIndividuales=false;
					break;
				case 2:
					List<String[]>datos= leerArchivoCSV(nombreArchivo);
					
					int indice = Math.min(repeticiones, datos.size());
					
					 for (int i = 0; i < indice; i++) {
					        String[] linea = datos.get(i);
					        for (String dato : linea) {
					            System.out.print(dato + "    ");
					        }
					        System.out.println();
					    }
					
					//comprobamos la dimension del array, del fichero en cuestión
					int dimension = datos.size();
					System.out.println("Dimensión del ArrayList: " + dimension);

					//IMPRESIÓN DE LA BASE DE DATOS
					indice=dimension-1;
					for (int i=0; i<=indice;i++) {
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
					salirMenusIndividuales=false;
					break;
				case 3: 
					float [][] matrizFloat = buscarAlertas(nombreArchivo);
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
						Map<String,String[]>columnas=filtrarParametro (nombreArchivo);

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
				default:
					System.out.println("ERROR \n");
					break;
				}//switch menu (opciones de menú)
			}//while salir de cada menu: (boolean salirMenusIndividuales)
		}//while salir cuando el usuario indique que quiere salir: (boolean salirUsuario)


	}//main

}//class

