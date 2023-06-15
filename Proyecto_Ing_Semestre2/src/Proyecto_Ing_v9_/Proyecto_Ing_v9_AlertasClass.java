package Proyecto_Ing_v9_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Proyecto_Ing_v9_AlertasClass {

	public static String [] procesarArchivoCSV (String nombreArchivo) {//Método que llama a la función de separar datos e imprimir
		
		//A continuación hacemos la llamada a la función de separar datos:
		Map<String,List<String>> datosSeparados = separarDatosCSV(nombreArchivo);//Devuelve un map con componentes key y fill
		
		//Lista que ordena las entradas del mapa
		List<Map.Entry<String, List<String>>> entradasOrdenadas = new ArrayList<>(datosSeparados.entrySet());
        entradasOrdenadas.sort(Map.Entry.comparingByKey());
		
        int i=0;
        String [] miVector = new String[5];
		//Imprimir los datos separados por componentes
		for(Map.Entry<String,List<String>>entry:entradasOrdenadas) {
			String componente = entry.getKey();
			List<String>datos=entry.getValue();
			miVector[i]= componente + " " + datos;
			//System.out.println("Componente: " + componente);
           // System.out.println("Datos: " + datos);
           // System.out.println();
           // System.out.println(miVector[i]);
            i++;
		}
		return miVector;
	}
	
	
	//Función que toma los values, que en un principio se asocian al componente de manera unificada, y los divide para poder evaluarlos
	public static List<String> dividirElementos(List<String> datos1) {
        List<String> listaSubelementos = new ArrayList<>();
        for (String elemento : datos1) {
            String[] subelementos = elemento.split(",");
            listaSubelementos.addAll(Arrays.asList(subelementos));
        }
        return listaSubelementos;
    }
	
	//Función que convierte lo que hemos dividido arriba, a floats
	public static List<Float> convertirListaCadenasAFlotantes(List<String> listaCadenas) {
        List<Float> listaFlotantes = new ArrayList<>();
        for (String cadena : listaCadenas) {
            float numero = Float.parseFloat(cadena);
            listaFlotantes.add(numero);
        }
        return listaFlotantes;
    }
	
	public static Map<String,List<String>> separarDatosCSV(String nombreArchivo){
		//MAP: Key:nombre del componente / Value: lista de los datos correspondientes a ese componente
		Map<String, List<String>> components = new LinkedHashMap<>();//LinkedHashMap para mantener el orden
		String [] cabeceraNombres = {"Ancho de Banda", "Throughput", "Latencia", "BER", "Flujo de Datos"};
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				for (int i=0;i<values.length;i++) {
					String componentName=cabeceraNombres[i];
					List<String>datos=components.getOrDefault(componentName, new ArrayList<>());
					datos.add(values[i]);
					components.put(componentName, datos);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return components;
	}

/*
	public List<String> filterComponent(String componentName, String filterCriteria) {
		List<String> filteredElements = new ArrayList<>();
		String[] componentData = components.get(componentName);
		if (componentData != null) {
			for (String element : componentData) {
				// Aplica aquí tu lógica de filtrado personalizado
				if (element.contains(filterCriteria)) {
					filteredElements.add(element);
				}
			}
		}
		return filteredElements;
	}
^*/
	

	
}//Llave class
