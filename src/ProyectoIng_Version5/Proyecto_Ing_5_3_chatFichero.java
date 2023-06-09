package ProyectoIng_Version5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Proyecto_Ing_5_3_chatFichero {

	public static void main(String[] args) {

		        String dataFileName = "data.txt";
		        String headerFileName = "header.txt";
		        
		        generateRandomDataFile(dataFileName);
		        createHeaderFile(dataFileName, headerFileName);
		        
		        System.out.println("Archivo creado con �xito.");
		    }

		    private static void generateRandomDataFile(String fileName) {
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
		            Random random = new Random();
		            int numRecords = 10; // N�mero de registros aleatorios
		            
		            // Escribir los registros aleatorios en el archivo
		            for (int i = 0; i < numRecords; i++) {
		                String record = generateRandomRecord();
		                writer.write(record);
		                writer.newLine();
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    private static String generateRandomRecord() {
		        Random random = new Random();
		        int id = random.nextInt(1000);
		        String name = generateRandomName();
		        int age = random.nextInt(50) + 18; // Rango de edades de 18 a 67
		        
		        return id + "," + name + "," + age;
		    }

		    private static String generateRandomName() {
		        String[] names = {"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Benjamin", "Isabella"};
		        Random random = new Random();
		        int index = random.nextInt(names.length);
		        
		        return names[index];
		    }
		    
		    private static void createHeaderFile(String dataFileName, String headerFileName) {
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(headerFileName))) {
		            String header = "ID,Name,Age"; // Cabeceras de los datos
		            writer.write(header);
		            writer.newLine();
		            
		            // Leer los datos del archivo de datos y escribirlos en el archivo de cabecera
		            // Esto se hace para que las cabeceras est�n en el mismo orden que los datos
		            // y se pueda visualizar correctamente cuando se abra el archivo de cabecera.
		            // Si no se hace esto, las cabeceras pueden estar desordenadas si los datos se generan aleatoriamente.
		            // Tambi�n puedes simplemente escribir manualmente las cabeceras si no te importa el orden.
		            // En ese caso, solo necesitar�as escribir la l�nea "writer.write(header);" sin el bucle adicional.
		            try (BufferedReader reader = new BufferedReader(new FileReader(dataFileName))) {
		                String line;
		                while ((line = reader.readLine()) != null) {
		                    writer.write(line);
		                    writer.newLine();
		                    break; // Solo necesitamos una l�nea para obtener los nombres de los campos. ESTE BREAK SOBRAAAA PARA ESCRIBIR M�S VALORESSSS
		                }
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    
	

	}//llave main

}//llave class
