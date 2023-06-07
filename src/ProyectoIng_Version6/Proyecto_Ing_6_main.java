package ProyectoIng_Version6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;


/*ESPECIFICACIONES DE LA VERSIÓN:
 * Se han implementado nuevas funciones para facilitar el fragmento del main.
 * Se generan 2 ficheros, uno con los datos y otro con las cabeceras, siendo este último donde metemos el primer fichero
 * obteniendo como resultado el fichero con nombres y datos.
 * 
 */



public class Proyecto_Ing_6_main {
	
	
	//Función que genera valores aleatorios con decimales: Ancho de Banda, Throughput y Latencia
	public static String generaRandomFLOAT() {
		Random random = new Random();
		float anchoBanda = random.nextFloat(1000-20 +1)+20;
		float throughput = random.nextFloat(1000-20 +1)+20;
		float latencia = random.nextFloat(500-0 +1)+0;
		return anchoBanda + " " + throughput + " " + latencia;
	}
	
	//Función que genera valores aleatorios enteros: BER y Flujo de Datos (además, añade la primera función de valores con decimales)
	public static String generaRandomINTyFLOAT() {
		Random random = new Random();
		String llamadaDatosFloat = generaRandomFLOAT();
		float BER = random.nextInt(10-0 +1)+0;
		float FlujoDatos = random.nextInt(1-0 +1)+0;
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
						Thread.sleep(4000);
						//Realizamos las operaciones:
						System.out.println("Guardando datos, espere...");
						int x=0;
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(datos,true))) {
							File fichero = new File (datos);
							if (!fichero.exists()) {
								fichero.createNewFile();
							}
							//Escribir aleatorios en el registro
							String filaDeDatos= generaRandomINTyFLOAT();//Ojo, si quitamos el guardado en una variable no compila
							//Genera un vector con los datos
							Vector v = new Vector();
							v.add(new String (generaRandomINTyFLOAT()));
							String Guardado = " ";//datos por posiciones
							Guardado=(String)v.get(x);//Llamada a cada vector
							bw.write(Guardado + "\r\n");
							bw.close();
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
				bw.write(cabeceraNombres [i] + "    ");
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
	
	//Función MAIN del programa
			public static void main(String[] args) {

				//DECLARACIÓN DE VARIABLES PARA NOMBRAR LOS FICHEROS
				String dataFileName = "datosVersion6.csv"; //Fichero que guarda los datos aleatorios
				String headerFileName = "pruebaVersion6.csv"; //Fichero que guarda: las cabeceras + fichero anterior (FICHERO COMPLETO)
				
				//Llamada a las funciones que generan los ficheros
				generaRegistrosAleatorios(dataFileName);
				creadorFicheroCabecera (dataFileName,headerFileName);
			
			}//Llave main. DU NOT WIPE DOWN
	
	
}//Llave class. DU NOT WIPE DOWN
