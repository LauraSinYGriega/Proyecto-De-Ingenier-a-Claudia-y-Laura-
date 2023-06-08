package ProyectoIng_Version7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
//import java.util.Vector;
//import java.util.ArrayList;
//import java.util.List;

/*ESPECIFICACIONES DE LA VERSIÓN:
 * ...
 */



public class Proyecto_Ing_V7_Main {
	
	
	//Función MAIN del programa
		public static void main(String[] args) {

			//DECLARACIÓN DE VARIABLES PARA NOMBRAR LOS FICHEROS
			String dataFileName = "datosVersion7.csv"; //Fichero que guarda los datos aleatorios
			String headerFileName = "pruebaVersion7.csv"; //Fichero que guarda: las cabeceras + fichero anterior (FICHERO COMPLETO)
			String filteredDataFileName = "datosFiltradosV7.csv";
			
			//Llamada a las funciones que generan los ficheros
			generaRegistrosAleatorios(dataFileName);
			creadorFicheroCabecera (dataFileName,headerFileName);
			
			//Llamada a la función que filtra y al fichero que guarda el filtrado. 
			filtrarDatos (dataFileName,filteredDataFileName);
		
			
			
		}//Llave main. DU NOT WIPE DOWN


	//Función que genera valores aleatorios con decimales: Ancho de Banda, Throughput y Latencia
	public static String generaRandomFLOAT() {
		Random random = new Random();
		float anchoBanda = random.nextFloat()*(1000-20 +1)+20;
		float throughput = random.nextFloat()*(1000-20 +1)+20;
		float latencia = random.nextFloat()*(500-0 +1)+0;
		return anchoBanda + " " + throughput + " " + latencia;
	}
	
	//Función que genera valores aleatorios enteros: BER y Flujo de Datos (además, añade la primera función de valores con decimales)
	public static String generaRandomINTyFLOAT() {
		Random random = new Random();
		String llamadaDatosFloat = generaRandomFLOAT();
		int BER = random.nextInt(10-0 +1)+0;
		int FlujoDatos = random.nextInt(1-0 +1)+0;
		return llamadaDatosFloat + " " + BER + " " + FlujoDatos;
	}
	
	//Función que reune todos los valores aleatorios en un vector, y los imprime en un bucle cada 4 segundos
	public static void generaRegistrosAleatorios (String datos) {
		Runnable runnable =new Runnable() {
			@Override
			public void run() {
				// Esto se ejecuta en segundo plano una única vez
				while (true) {
					// Pero usamos un truco y hacemos un ciclo infinito
					try {
						//Hacemos que el hilo duerma
						Thread.sleep(1000);
						//Realizamos las operaciones:
						System.out.println("Guardando datos, espere...");
						int x=0;
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(datos,true))) {
							File fichero = new File (datos);
							if (!fichero.exists()) {
								fichero.createNewFile();
							}
							//Escribir aleatorios en el registro
							String filaDeDatos= generaRandomINTyFLOAT();//Si no guardamos la fila de aleatorios, nos aparece un error a la hora de compilar
							
							//Genera un vector con los datos
							/*Vector v = new Vector();
							v.add(new String (generaRandomINTyFLOAT()));*/
							
							/*String Guardado = " ";//datos por posiciones
							Guardado=(String)v.get(x);*///Llamada a cada vector
							bw.write(filaDeDatos + "\r\n"); 
							bw.flush();
						 } catch (IOException e) {
					            e.printStackTrace();
					     }
						x++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}//Llave catch del try del Thread
				}//Llave del while true
			}//llave public run
		};//LLAVE DE LA INTERFACE RUNNABLE
		
		//CHAT A PUESTO EL HILO FUERA.................................
		// Creamos un hilo y le pasamos el runnable
		Thread hilo = new Thread(runnable);
		hilo.start();
		// Y aquí podemos hacer cualquier cosa, en el hilo principal del programa
		System.out.println("Impresión de mensajes....");
	}//Llave de la funcio principal

	
	
	//Función que imprime los rótulos en un nuevo fichero, y además, llama al fichero de datos y lo imprime a continuación en este nuevo fichero
	private static void creadorFicheroCabecera (String dataFileName, String headerFileName) {
		try (BufferedWriter bw = new BufferedWriter (new FileWriter(headerFileName))){
			String [] cabeceraNombres = {" Ancho de Banda ", " Throughput ", " Latencia ", " BER ", " Flujo de Datos"};
			for (int i=0;i<5;i++) { 
				bw.write(cabeceraNombres [i] + " ");
			}
			bw.newLine();
			try (BufferedReader br = new BufferedReader (new FileReader(dataFileName))){
				String line;
				while ((line=br.readLine())!=null) {
					bw.write(line);
					bw.newLine(); 
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtrarDatos (String datos, String datosFiltrados) {
		try (BufferedReader br = new BufferedReader (new FileReader(datos));
				BufferedWriter bw= new BufferedWriter (new FileWriter (datosFiltrados))){
			String line;
			while ((line=br.readLine())!=null) {
				if (cumpleFiltro(line)) {
					System.out.println ("Se cumple filtro en la línea: "  + line);
					bw.write(line);
                    bw.newLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static boolean cumpleFiltro (String datos) {
		String[] valores = datos.split(" ");
		float anchoBanda = Float.parseFloat(valores[0]);
		float throughput = Float.parseFloat(valores[1]);
		float latencia = Float.parseFloat(valores[2]);
		int BER = Integer.parseInt(valores[3]);
		int flujoDatos = Integer.parseInt(valores[4]);
		
		//Definir rangos de filtrado:
		boolean cumpleAnchoBanda = anchoBanda >= 882; //Mayor del 90% presenta problemas
		boolean cumpleThroughput = throughput <= 480; //Menor que 480 (50%) es más bajo de lo deseado y esto puede afectar la eficacia de la red.
		boolean cumpleLatencia = latencia > 100;//Latencia por encima de 100 ms da problemas
		boolean cumpleBER = BER == 0; //NI IDEA DE CÓMO HACER ESTE
		boolean cumpleFlujoDatos = flujoDatos == 1;//Cuando el flujo es 1 erlang, la red está totalmente ocupada
		
		return cumpleAnchoBanda && cumpleThroughput && cumpleLatencia && cumpleBER && cumpleFlujoDatos;
		
	}
	

}//Llave class. DU NOT WIPE DOWN
