package Proyecto_Ing_v9_;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Proyecto_Ing_v9_RecolectaParametrosClass implements Runnable {

private int repeticiones;//función para poder utilizar la variable repeticiones y también usarla en el main

	
	public Proyecto_Ing_v9_RecolectaParametrosClass (int repeticiones) {
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

	@Override
	public void run() {
		for (int i=0; i<repeticiones;i++) {
			try {
				Thread.sleep(1000);
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("BaseDatos_v9.2.csv",true))) {
					File fichero = new File ("BaseDatos_v9.2.csv");
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
	}
};
	
	

