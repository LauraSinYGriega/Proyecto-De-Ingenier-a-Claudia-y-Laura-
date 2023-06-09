package ProyectoIng_Version7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Proyecto_Ing_V7_3_Chat {

	//BUSCAR NÚMEROS ALEATORIOS EN UN FICHERO CREADO

    public static void main(String[] args) {
        String archivoCSV = "numeros.csv";

        // Generar números aleatorios y guardarlos en el archivo CSV
        generarNumerosAleatorios(archivoCSV, 100);

        // Filtrar el archivo para identificar los números del 12 al 22
        List<String> numerosFiltrados = filtrarArchivoCSV(archivoCSV, 12, 22);

        if (!numerosFiltrados.isEmpty()) {//Verificamos que la lista de numeros filtrados no está vacia
            System.out.println("Los números del 12 al 22 están presentes en el archivo:");
            for (String numero : numerosFiltrados) {
                System.out.println(numero);
            }
        } else {
            System.out.println("Los números del 12 al 22 no están presentes en el archivo.");
        }
        
        //VERIFICAR EL TIPO DE VARIABLE:
       /* int variable;
        if (variable instanceof Integer) {
            System.out.println("La variable es de tipo Integer.");
        } else if (variable instanceof Float) {
            System.out.println("La variable es de tipo Float.");
        } else if (variable instanceof String) {
            System.out.println("La variable es de tipo String.");
        } else {
            System.out.println("La variable no es de ninguno de los tipos mencionados.");
        }*/
        
        
        
        
        
    }

    public static void generarNumerosAleatorios(String archivoCSV, int cantidadNumeros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV))) {
            Random random = new Random();

            for (int i = 0; i < cantidadNumeros; i++) {
                int numeroAleatorio = random.nextInt(100);
                bw.write(String.valueOf(numeroAleatorio));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> filtrarArchivoCSV(String archivoCSV, int rangoInicio, int rangoFin) {
        List<String> numerosFiltrados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int numero = Integer.parseInt(linea); //Esta expresión sirve para convertir una cadena de texto en un valor entero
                if (numero >= rangoInicio && numero <= rangoFin) {
                    numerosFiltrados.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numerosFiltrados;
    }
}