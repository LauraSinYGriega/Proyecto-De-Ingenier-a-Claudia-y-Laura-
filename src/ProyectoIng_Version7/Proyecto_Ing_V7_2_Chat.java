package ProyectoIng_Version7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Proyecto_Ing_V7_2_Chat {

	public static List<String[]> buscarElementoEnCSV(String archivoCSV, String elemento) {
	    List<String[]> resultados = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] fila = linea.split(",");
	            // Verificar si la fila contiene el elemento buscado
	            for (String valor : fila) {
	                if (valor.equals(elemento)) {
	                    resultados.add(fila);
	                    break;
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return resultados;
	}
	
	
	public static void main(String[] args) {
		
		String archivoCSV = "pruebaVersion6.csv";
		String elementoBuscado = "BER";

		List<String[]> resultados = null;
		try {
			resultados = buscarElementoEnCSV(archivoCSV, elementoBuscado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Itera sobre los resultados
		for (String[] fila : resultados) {
		    // Accede a los valores de cada columna en la fila
		    for (String valor : fila) {
		        System.out.print(valor + " ");
		    }
		    System.out.println();
		}

	}//main

}//class
