package ProyectoIng_Version4;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.ArrayList;


/*ESPECIFICACIONES DE LA VERSIÓN:
 * Versión 3, pero con vectores y alguna otra mejora. 
 * Nos hemos dado cuenta de que no podemos almacenar los datos en arrays ya que nos impide generar datos de manera
 * ilimitada, para mejorarlo, hemos implementado vectores. 
 * No obstante, también hemos investigado acerca de ArrayLists.
 */


public class Proyecto_Ing_4_Main {

	//Función genérica para generar números aleatorios FLOAT (Usada en: Ancho de Banda; Throughput; Latencia):
	public static float generaNumAleatorioFLOAT (float minimo, float maximo) {
		return (float)(Math.random()*(minimo-(maximo+1))+(maximo+1));
	}//llave (aleatorios con decimales)


	public static void main(String[] args) {


		//ANCHO DE BANDA
		float minAnchoBanda=20;
		float maxAnchoBanda=1000;
		

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// Esto se ejecuta en segundo plano una única vez
				while (true) {
					// Pero usamos un truco y hacemos un ciclo infinito
					try {
						// En él, hacemos que el hilo duerma
						Thread.sleep(1000);
						// Y después realizamos las operaciones
						System.out.println("Guardando datos, espere...");
						float valorAnchoBanda=generaNumAleatorioFLOAT(minAnchoBanda,maxAnchoBanda);
						int x=0;//Variable que nos permite guardar las posiciones del vector

						try {
							File fichero = new File ("pruebaVersion4.csv");
							if (!fichero.exists()) {
								fichero.createNewFile();
							}
							FileWriter fw = new FileWriter (fichero.getAbsoluteFile(), true);
							BufferedWriter bw = new BufferedWriter (fw);
							/*Instancia del vector, sin dimensiones específicas, 
							 * si se rebasa la dimensión inicial, la dimensión se duplica*/
							Vector Datos = new Vector();
							Datos.add(new Float (valorAnchoBanda));
							float GuardadoAnchoBanda=0;//Almacenamiento del dato por posiciones para poder guardarlo en fichero
							GuardadoAnchoBanda=(Float)Datos.get(x);//Llamada a cada posición del vector.
							bw.write(GuardadoAnchoBanda + "\r\n");//Escritura en el fichero del valor ancho de banda
							bw.close();

						} catch (Exception e) {
							System.out.println("Se ha producido un error en la creacción del fichero.");
						} 
						x++;//Incrementamos la posición del vector para que se generen tantos datos como se deseen sin que se pisen

					} catch (InterruptedException e) {
						e.printStackTrace();
					}//Llave catch del try del Thread
				}//Llave bucle while(true)
			}//Llave public void run
		};//Llave de la interface runnable

		// Creamos un hilo y le pasamos el runnable
		Thread hilo = new Thread(runnable);
		hilo.start();

		// Y aquí podemos hacer cualquier cosa, en el hilo principal del programa
		System.out.println("Impresión de mensajes....");
		
		




	}//Llave main. DU NOT WIPE DOWN

}//Llave class. DU NOT WIPE DOWN

