package ProyectoIng_Version3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

/*ESPECIFICACIONES T�CNICAS DE LA VERSI�N:
 * En esta versi�n se ha conseguido implementar la funci�in Runnable que nos permitir� guardar datos cada x tiempo.
 * Es una versi�n de prueba por lo que solo lo hace un valor (Ancho de Banda).
 */



public class Proyecto_Ing_V3_Main {

	//Funci�n gen�rica para generar n�meros aleatorios FLOAT (Usada en: Ancho de Banda; Throughput; Latencia):
	public static float generaNumAleatorioFLOAT (float minimo, float maximo) {
		return (float)(Math.random()*(minimo-(maximo+1))+(maximo+1));
	}//llave (aleatorios con decimales)


	
	public static void main(String[] args) { 
		
		
		////BLOQUE DE CONSTRUCCI�N DE VALORES ALEATORIOS////
		
		//ANCHO DE BANDA
		float minAnchoBanda=20;
		float maxAnchoBanda=1000;
			//Valores que usaremos en la creacci�n de los Arrays de datos aleatorios que guardaremos y analizaremos
		float[] Datos = new float [10];//ESTO TIENE QUE CAMBIAR CON VECTORES
		
		
		
		////BLOQUE DE CREACCI�N DE FICHERO CSV////
		
		//Declaramos
		Runnable runnable = new Runnable() {
			@Override
			  public void run() {
				//Bucle infinito que se ejecuta cada vez que tenga un start
				while (true) {
					try {
						Thread.sleep(4000); //Creamos un hilo y hacemos que duerma durante 4 segundos.
						//Posteriormente, escribimos las acciones que realizar� "cuando despierte":
						 System.out.println("Guardando datos, espere..."); //BORRAR CUANDO ACABE, SOLO ES PARA VERIFICAR
						 float valorAnchoBanda=generaNumAleatorioFLOAT (minAnchoBanda, maxAnchoBanda);
						 //CREAR EL VECTOR QUE HAGA LO SIGUIENTE:
						 int x=0;
						 Datos [x] =valorAnchoBanda;
						 try {
							 File fichero = new File ("pruebaVersion3.csv");
							 //Aseguramos que el fichero existe, si no, lo creamos:
							 if (!fichero.exists()) {
								 fichero.createNewFile();
							 }//Llave if: �fichero, existes?
							 FileWriter fw = new FileWriter (fichero.getAbsoluteFile(),true);
							 BufferedWriter bw = new BufferedWriter (fw);
							 bw.write(Datos[x]+ "\r\n");
							 bw.close();
						 }catch (Exception e) {
							  System.out.println("Se ha producido un error en la creacci�n del fichero.");
						 }//Llave catch del try del fichero 
						  x++;//Acumulador del vector en el que se guarda el valor aleatorio. 			 
					}catch (InterruptedException e) {
						e.printStackTrace();
					}//Llave catch del try del Thread
				}//Llave bucle while(true)
			}//Llave public void run
		};//Llave de la interface runnable
		
		//Creamos un hilo para mandar al runnable. En este caso, le pondremos en "play":
		Thread hilo = new Thread (runnable);
		hilo.start();
		
		// Y aqu� podemos hacer cualquier cosa, en el hilo principal del programa
		System.out.println("Impresi�n de mensajes...");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}//Llave main. DU NOT WIPE DOWN


}//Llave class. DU NOT WIPE DOWN
