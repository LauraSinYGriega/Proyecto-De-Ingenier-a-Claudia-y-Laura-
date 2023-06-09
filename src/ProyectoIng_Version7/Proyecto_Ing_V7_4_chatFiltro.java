package ProyectoIng_Version7;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Proyecto_Ing_V7_4_chatFiltro implements Runnable {

		private String fileName;
		private int interval;

		public Proyecto_Ing_V7_4_chatFiltro(String fileName, int interval) {
			this.fileName = fileName;
			this.interval = interval;
		}

		@Override
		public void run() {
			try {
				while (true) {
					generateCsv();
					Thread.sleep(interval * 1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void generateCsv() {
			Random random = new Random();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
				StringBuilder sb = new StringBuilder();

				// Generar datos aleatorios para cada fila
				int num1 = random.nextInt(100);
				int num2 = random.nextInt(100);
				int num3 = random.nextInt(100);

				// Filtrar por rangos de números
				if (num1 >= 30 && num1 <= 70 && num2 >= 40 && num2 <= 80 && num3 >= 50 && num3 <= 90) {
					sb.append(num1).append(",").append(num2).append(",").append(num3).append("\n");
					writer.write(sb.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			String fileName = "data.csv";
			int interval = 5; // Intervalo de tiempo en segundos

			Proyecto_Ing_V7_4_chatFiltro csvGenerator = new Proyecto_Ing_V7_4_chatFiltro(fileName, interval);
			Thread thread = new Thread(csvGenerator);
			thread.start();
		}
}
