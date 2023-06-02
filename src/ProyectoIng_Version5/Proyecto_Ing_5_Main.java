package ProyectoIng_Version5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;


/*ESPECIFICACIONES DE LA VERSIÓN:
 * ...
 */



public class Proyecto_Ing_5_Main {

	//Función genérica para generar números aleatorios FLOAT (Usada en: Ancho de Banda; Throughput; Latencia):
	public static float generaNumAleatorioFLOAT (float minimo, float maximo) {
		return (float)(Math.random()*(minimo-(maximo+1))+(maximo+1));
	}//llave (aleatorios con decimales)


	public static void main(String[] args) {
		
		////BLOQUE DE CONSTRUCCIÓN DE VALORES ALEATORIOS////
	
		//ANCHO DE BANDA
		float minAnchoBanda=20;
		float maxAnchoBanda=1000;
		//THROUGHPUT
		float minThroughput=20;
		float maxThroughput=1000;
		//LATENCIA
		float minLatencia=0;
		float maxLatencia=500;
		//TASA DE ERROR DE BITS (BER) **************************NO ACABADO, SERIAS DUDAS********************************************
		int minBER=0;
		int maxBER=4;
		//TRÁFICO DE DATOS O FLUJO DE DATOS
		int minFlujoDatos=0;
		int maxFlujoDatos=1;

		
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
						
						//Creaccion de aleatorios:
						float valorAnchoBanda=generaNumAleatorioFLOAT(minAnchoBanda,maxAnchoBanda);
						float valorThroughput=generaNumAleatorioFLOAT(minThroughput,maxThroughput);
						float valorLatencia=generaNumAleatorioFLOAT(minLatencia,maxLatencia);
						float valorBER = generaNumAleatorioFLOAT(minBER,maxBER);//TENGO QUE CAMBIAR ESTO A INT CON UNA NUEVA FUNCIÓN, DE MOMENTO LO HAGO CON UNA SOLA FUNCION DE FLOAT
						float valorFlujoDatos = generaNumAleatorioFLOAT(minFlujoDatos,maxFlujoDatos);
						
						
						int x=0;//Variable que nos permite guardar las posiciones del vector

						try {
							File fichero = new File ("pruebaVersion5.csv");
							if (!fichero.exists()) {
								fichero.createNewFile();
							}
							FileWriter fw = new FileWriter (fichero.getAbsoluteFile(), true);
							BufferedWriter bw = new BufferedWriter (fw);
							//Instancia del vector, sin dimensiones específicas, si se rebasa la dimensión inicial, la dimensión se duplica
							Vector vectorAnchoBanda = new Vector();
							vectorAnchoBanda.add(new Float (valorAnchoBanda));
							
							Vector vectorThroughput = new Vector ();
							vectorThroughput.add(new Float (valorThroughput));
							
							Vector vectorLatencia = new Vector();
							vectorLatencia.add(new Float (valorLatencia));
							
							Vector vectorBER = new Vector();
							vectorBER.add(new Float (valorBER));
							
							Vector vectorFlujoDatos = new Vector();
							vectorFlujoDatos.add(new Float (valorFlujoDatos));
							
							//Almacenamiento del dato por posiciones para poder guardarlo en fichero
							float GuardadoAnchoBanda=0;
							float GuardadoThroughput=0;
							float GuardadoLatencia=0;
							float GuardadoBER=0;
							float GuardadoFlujoDatos=0;
							
							//Llamada a cada posición del vector.
							GuardadoAnchoBanda=(Float)vectorAnchoBanda.get(x);
							GuardadoThroughput= (Float)vectorThroughput.get(x);
							GuardadoLatencia= (Float)vectorLatencia.get(x);
							GuardadoBER=(Float)vectorBER.get(x);
							GuardadoFlujoDatos=(Float)vectorFlujoDatos.get(x);
							
							//Escritura en el fichero de valores:
							bw.write(GuardadoAnchoBanda + "  " + GuardadoThroughput + "  " + GuardadoLatencia + "   " + GuardadoBER + "   " + GuardadoFlujoDatos +  "\r\n");
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
