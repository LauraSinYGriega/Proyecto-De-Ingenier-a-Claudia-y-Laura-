package Proyecto_Ing_v14;

//VERSI�N 14.0 (�DEFINITIVA!)
/* 
 * C�digo realizado por Claudia Luna Roda y Laura Mart�nez Bravo
 * 
 * Materia: Proyecto de Ingenier�a I
 * Grado: Ingenier�a en Sistemas de Telecomunicaciones
 * Fecha: 21/06/23
 */


//Importamos las librer�as generales:
import java.io.*;
import java.util.*;

public class Proyecto_Ing_v14_mainClass {

	
	//Instanciaci�n de constantes que especifican el nombre del archivo y el intervalo de tiempo entre cada generaci�n de datos
	private static final String ARCHIVO_BASE_DATOS = "BaseDatos_v14.csv";
	private static final long TIEMPO_ESPERA = 30 * 60 * 1000; //30 minutos en milisegundos

	
	//Instanciaci�n de constantes para generar par�metros de red
	//Ancho de Banda
	private static final int MIN_ANCHOBANDA = 20;
	private static final int MAX_ANCHOBANDA = 1000;
	//Throughput
	private static final int MIN_THROUGHPUT = 20;
	private static final int MAX_THROUGHPUT = 1000;
	//Latencia
	private static final int MIN_LATENCIA = 0;
	private static final int MAX_LATENCIA = 500;
	//Tasa de Error - BER
	private static final double[] BER = {1e-9, 1e-6, 1e-3};
	//Flujo de Datos
	public static final int MIN_FLUJODATOS=0;
	public static final int MAX_FLUJODATOS=1;

	
	//M�TODO QUE GENERA LOS PAR�METROS ALEATORIOS DE LA RED Y LOS ALMACENA EN UN FICHERO
	public static void generarDatosRedAleatorios() {
		Random rand = new Random();
		//Llamada a la generaci�n de aleatorios
		int anchoBanda = rand.nextInt(MAX_ANCHOBANDA - MIN_ANCHOBANDA + 1) + MIN_ANCHOBANDA;
		int throughput = rand.nextInt(MAX_THROUGHPUT - MIN_THROUGHPUT + 1) + MIN_THROUGHPUT;
		int latencia = rand.nextInt(MAX_LATENCIA - MIN_LATENCIA + 1) + MIN_LATENCIA;
		double tasaError = BER[rand.nextInt(BER.length)];
		int flujoDatos = rand.nextInt(MAX_FLUJODATOS - MIN_FLUJODATOS + 1) + MIN_FLUJODATOS;

		String datosRed = anchoBanda + ";" + throughput + ";" + latencia + ";" + tasaError + ";" + flujoDatos;

		//Escritura de datos en la base
		try (FileWriter writer = new FileWriter(ARCHIVO_BASE_DATOS, true)) {
			writer.write(datosRed + System.lineSeparator());
		} catch (IOException e) {
			System.out.println("Error al escribir los datos en el archivo.");
		}
	}//Llave m�todo-generar datos

	
	//M�TODO PARA GENERAR LOS ALEATORIOS Y HACER EL GUARDADO CADA X TIEMPO
	public static void iniciarGeneracionDatosAutomatica() {
		TimerTask tareaGenerarDatos = new TimerTask() {
			@Override
			public void run() {//Fragmento que se ejecuta seg�n el tiempo establecido
				generarDatosRedAleatorios();//Llamada al m�todo de generar par�metros
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(tareaGenerarDatos, 0, TIEMPO_ESPERA);//Establecer tiempo
	}//Llave m�todo generar datos por tiempo


	//M�TODO DE CREACCI�N DEL ARCHIVO
	public static void crearArchivoBaseDatos() {
		File archivo = new File(ARCHIVO_BASE_DATOS);
		try {
			if (!archivo.exists()) {//Evaluaci�n de la existencia del archivo
				archivo.createNewFile();

			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo de base de datos.");
		}
	}//Llave m�todo-crear archivo

	
	//M�TODO DE LECTURA DE LA BASE DE DATOS
	public static void consultarBaseDatos() {
		try (Scanner scanner = new Scanner(new File(ARCHIVO_BASE_DATOS))) {
			if (!scanner.hasNext()) {
				System.out.println("La base de datos est� vac�a.");
			} else {
				System.out.println("  AnchoBanda  " + "  Throughput  " + "  Latencia  " + "  TasaError  " + "  FlujoDatos  ");
				while (scanner.hasNextLine()) {
					String datos = scanner.nextLine();
					System.out.println(datos);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al cargar los datos desde el archivo.");
		}
	}//Llave m�todo-lectura base


	//M�TODO PARA ANALIZAR LA BASE DE DATOS
	public static void generarAnalisisDatos() {
		//Creamos un bloque Scanner para leer el archivo, y lo incluimos en un try-catch de evaluaci�n
		try (Scanner scanner = new Scanner(new File(ARCHIVO_BASE_DATOS))) {
			if (!scanner.hasNext()) {//Comprobamos si el archivo est� vac�o
				System.out.println("La base de datos est� vac�a. No se pueden generar an�lisis.");
				return;
			}
			System.out.println("---RESULTADO---");
			//Variable alertas
			boolean alertaAnchoBanda=false;
			boolean alertaThroughput=false;
			boolean alertaLatencia=false;
			boolean alertaTasaError=false;
			boolean alertaFlujoDatos=false;
			boolean alertaGeneral=false;
		
			//Lectura de las l�neas del archivo
			while (scanner.hasNextLine()) {
				String datos = scanner.nextLine();
				String[] campos = datos.split(";");//Separamos las l�neas que se van leyendo gracias a ;
				//Si una l�nea tiene 5 par�metros (contamos el 0), se convierten a enteros.
				if (campos.length == 5) {
					int anchoBanda = Integer.parseInt(campos[0]);
					int throughput = Integer.parseInt(campos[1]);
					int latencia = Integer.parseInt(campos[2]);
					double tasaError = Double.parseDouble(campos[3]);
					int flujoDatos = Integer.parseInt(campos[4]);
					
					//Comprobaci�n del Ancho de Banda
		            if (anchoBanda >= 882) {
		            	alertaAnchoBanda=true;
		            }
		            //Comprobaci�n del Throughput
		            if (throughput <= 480) {
		            	alertaThroughput=true;
		            }
		            //Comprobaci�n de la Latencia
		            if (latencia <= 100) {
		            	alertaLatencia=true;
		            }
		            //Comprobaci�n de la tasa de error de bits (BER)
		            if (tasaError == 1e-3) {//Sistema muy bueno (10e-9), Sistema bueno (10e-6), Sistema da�ado (10e-3)
		            	alertaTasaError=true;
		            }
		            //Comprobaci�n del flujo de datos
		            if (flujoDatos ==1) {
		            	alertaFlujoDatos=true;
		            }
		            //Guardado de la alerta:
		            if (alertaAnchoBanda==true||alertaThroughput==true||alertaLatencia==true||alertaTasaError==true||alertaFlujoDatos==true) {
		            	alertaGeneral=true;
		            }  
				}
			}//Llave while contador de l�neas
			
			if (alertaGeneral=true) {//Impresi�n de alerta al usuario
				System.out.println("����ALERTA!!!! Algo no va como deberia.");
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error al cargar los datos desde el archivo.");
		}	
	}//Llave m�todo an�lisis


	//M�TODO PARA IMPRIMIR ALERTAS ESPEC�FICAS DE LA BASE DE DATOS
		public static void generarImpesionAlertas() {
			//Creamos un bloque Scanner para leer el archivo, y lo incluimos en un try-catch de evaluaci�n
			try (Scanner scanner = new Scanner(new File(ARCHIVO_BASE_DATOS))) {
				if (!scanner.hasNext()) {//Comprobamos si el archivo est� vac�o
					System.out.println("La base de datos est� vac�a. No se pueden generar an�lisis.");
					return;
				}
				//Lectura de las l�neas del archivo
				while (scanner.hasNextLine()) {
					String datos = scanner.nextLine();
					String[] campos = datos.split(";");//Separamos las l�neas que se van leyendo gracias a ;
					//Si una l�nea tiene 5 par�metros (contamos el 0), se convierten a enteros.
					if (campos.length == 5) {
						int anchoBanda = Integer.parseInt(campos[0]);
						int throughput = Integer.parseInt(campos[1]);
						int latencia = Integer.parseInt(campos[2]);
						double tasaError = Double.parseDouble(campos[3]);
						int flujoDatos = Integer.parseInt(campos[4]);
						
						//Comprobaci�n del Ancho de Banda
			            if (anchoBanda >= 882) {
			            	System.out.println();
			                System.out.println(">>Fallo en Ancho de banda>> La red ha superado el 90% de uso de su ancho de banda: " + datos);
			            }
			            //Comprobaci�n del Throughput
			            if (throughput <= 480) {
			            	System.out.println();
			                System.out.println(">>Fallo en Throughput>> El throughput es elevado, la conexi�n puede que se realentice en este momento: " + datos);
			            }
			            //Comprobaci�n de la Latencia
			            if (latencia <= 100) {
			            	System.out.println();
			                System.out.println(">>Fallo en Latencia>> La latencia ha superado los 100 ms en este momento: " + datos);
			            }
			            //Comprobaci�n de la tasa de error de bits (BER)
			            if (tasaError == 1e-3) {
			            	System.out.println();
			                System.out.println(">>Fallo en Tasa de Error (BER)>> El sistema est� da�ado, los bits no se han env�ado correctamente: " + datos);
			            }
			            //Comprobaci�n del flujo de datos
			            if (flujoDatos ==1) {
			            	System.out.println();
			                System.out.println(">>Fallo en Flujo de Datos>> La red est� totalmente ocupada durante este momento de medici�n: " + datos);
			            }
					}
				}//Llave while contador de l�neas
			} catch (FileNotFoundException e) {
				System.out.println("Error al cargar los datos desde el archivo.");
			}
			
		}//Llave m�todo an�lisis
	
		
	//M�TODO PARA BORRAR LA BASE DE DATOS
	private static void borrarDatosFichero(File ARCHIVO_BASE_DATOS) {
		try {
			// Crear un objeto FileWriter en modo de escritura para borrar los datos
			FileWriter writer = new FileWriter(ARCHIVO_BASE_DATOS);
			writer.write("");//Escribir una cadena vac�a en el fichero
			writer.close();
		} catch (IOException e) {
			System.out.println("Error al borrar los datos del fichero " + ARCHIVO_BASE_DATOS.getName() + ": " + e.getMessage());
		}
	}//Llave m�todo-borrado
	
	
	
	//PUNTO DE ENTRADA DEL PROGRAMA:		
	public static void main(String[] args) {
		
		//Llamada a los m�todos principales para empezar a ejecutar
		crearArchivoBaseDatos();
		iniciarGeneracionDatosAutomatica();

		boolean salir = false;//Bandera para salir del programa
		Scanner scanner;//Habilitamos el teclado para la interacci�n con el usuario durante el programa

		while (salir == false) {
			//Embellecedores del programa
			System.out.println();
			System.out.println ("��� Bienvanido al monitor de redes Cisco, Claura v14.0 !!!");
			System.out.println();
			//Opciones de men�
			System.out.println ("     �Qu� desea realizar? ");
			System.out.println (" [1] Consultar los par�metros de la red.");
			System.out.println (" [2] Generar an�lisis de los datos.");
			System.out.println (" [3] Visualizar los momentos de error en la red.");
			System.out.println (" [4] Salir del programa.");
			System.out.println (" [5] Resetear la base de datos de la red.");
			System.out.println();
			System.out.println("Ingrese su opci�n: ");

			scanner = new Scanner(System.in);//Habilitar teclado
			while (!scanner.hasNextInt()) {//Evaluaci�n de la opci�n de usuario
				System.out.print("Ingrese una opci�n v�lida. Tecle� �ndice de la opci�n, gracias: ");
				scanner.next();
			}
			int menu = scanner.nextInt();

			switch (menu) {
			case 1:
				System.out.println();//Embellecedores del programa
				System.out.println("----- Ha seleccionado la opci�n 1 -----");
				System.out.println("Procediendo a la lectura...");
				System.out.println();
				consultarBaseDatos();
				salir = false;
				break;
			case 2:
				System.out.println();//Embellecedores del programa
				System.out.println("----- Ha seleccionado la opci�n 2 -----");
				System.out.println("Procesando datos...");
				System.out.println();
				generarAnalisisDatos();//Llamada al m�todo de an�lisis
				System.out.println("�Desea visualizar los momentos en los que ha fallado la red, y su motivo?");
				System.out.println("S� o No");
				String usuario = scanner.next();
				//Evaluaci�n de la opci�n del usuario, y ejecuci�n de la misma
				if (usuario.equalsIgnoreCase("si")) {
					generarImpesionAlertas();//Llamada al m�todo de alertas
					break;
				}else if (usuario.equalsIgnoreCase("no")) {
		            break;
		        } else {
		            System.out.println("Respuesta inv�lida. Por favor, ingrese 'si' o 'no'.");
		        }
		        scanner.close();	
				salir = false;
				break;
			case 3:
				System.out.println();//Embellecedores del programa
				System.out.println("----- Ha seleccionado la opci�n 3 -----");
				System.out.println("Imprimiendo alertas...");
				generarImpesionAlertas();//Llamada al m�todo de alertas
				salir = false;
				break;
			case 4:
				System.out.println();//Embellecedores del programa
				System.out.println("----- Ha seleccionado la opci�n 4 -----");
				System.out.println("�Hasta pronto!");
				System.out.println();
				System.out.println("Cerrando el programa...");
				salir = true;//Cambiando la bandera para cerrar el programa
				break;
			case 5:
				System.out.println();//Embellecedores del programa
				System.out.println("---��Cuidado!! Ha seleccionado la opci�n 5 ��Precauci�n!!---");
				System.out.println();
				System.out.println("�Est� seguro de querer resetear el fichero? (S�/No)");
				String respuesta = scanner.next();
				//Evaluaci�n de la respuesta y ejecuci�n de la opci�n
				if (respuesta.equalsIgnoreCase("si")) {
					//Crear objetos File para representar los ficheros
					File ficheroBorrar= new File(ARCHIVO_BASE_DATOS);
					//Borrar los datos del fichero
					borrarDatosFichero(ficheroBorrar);//Llamada al m�todo de borrado de datos del fichero csv.
					System.out.println("Los datos de los ficheros se han borrado correctamente.");
					break;
				} else if (respuesta.equalsIgnoreCase("no")) {
					break;
				} else {
					System.out.println("Respuesta inv�lida. Por favor, ingrese 'S�' o 'No'.");
				}
				scanner.close();	
				break;
			default:
				System.out.println("Opci�n inv�lida. Int�ntalo nuevamente.");//Evaluaci�n de la opci�n general del men� principal
			}//Llave del switch-menu
		}//Llave del While-salir
	}//Llave del main
}//Llave de la class
