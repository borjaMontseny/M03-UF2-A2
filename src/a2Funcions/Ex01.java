package a2Funcions;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pàrquing: Una gran superfície comercial ofereix un pàrquing als seus clients.
		 * La informació sobre l'ocupació del pàrquing es manté mitjançant una parking
		 * NxN. Cada component de la qual és true si la plaça de pàrquing és ocupada
		 * i fals en cas contrari.
		 */

		Scanner sc = new Scanner(System.in);

		// crearParking(sc);

		boolean[][] parking = { { false, false, false, false },
								{ false, true, true, false },
								{ false, false, false, false },
								{ false, false, false, false } };

		System.out.println(percentatgePlacesLliuresFila(parking, 0));
		System.out.println(percentatgePlacesLliuresFila(parking, 1));
		System.out.println(percentatgePlacesLliuresFila(parking, 2));
		System.out.println(percentatgePlacesLliuresFila(parking, 3));

		System.out.println(percentatgePlacesLliuresParking(parking));
		
		System.out.println("Fila més lliure: " + numFilaMesLliure(parking));
		
		System.out.println("Total places: " + parking.length);

		sc.close();

	}

	// métode per demanar fileres:

	public static int demanarFiles(Scanner sc) {

		System.out.print("Files: ");

		int numFiles = sc.nextInt();

		return numFiles;

	}

	// métode per demanar columnes:

	public static int demanarColumnes(Scanner sc) {

		System.out.print("Columnes: ");

		int numColumnes = sc.nextInt();

		return numColumnes;

	}

	// mètode per crear un array a través dels metodes demanarFiles/Columnes
	public static boolean[][] crearParking(Scanner sc) {

		boolean[][] parking = new boolean[demanarFiles(sc)][demanarColumnes(sc)];

		return parking;

	}

	/*
	 * 1. Crea una funció anomenada **percentatgePlacesLliuresFila** que donada la
	 * parking i el número de fila de la parking, retorni el percentatge de places
	 * lliures d'aquella fila.
	 */

	public static double percentatgePlacesLliuresFila(boolean parking[][], int numFila) {

		int contadorPlacesOcupades = 0;

		for (int col = 0; col < parking[numFila].length; col++) {
			if (parking[numFila][col] == true) {
				contadorPlacesOcupades++;
			}
		}

		int percentatgePlacesLliures = (contadorPlacesOcupades * 100) / parking[numFila].length;

		return percentatgePlacesLliures;

	}

	/*
	 * 2. Crea una funció anomenada **percentatgePlacesLliuresParking** que donada
	 * la matriu del pàrquing retorni el percentatge de places lliures del parking.
	 */

	public static double percentatgePlacesLliuresParking(boolean parking[][]) {

		// sumar % de cada fila, dividir por el total de filas

		double totalPercentatgeFiles = 0;

		// for que recorra fila por fila
		for (int fil = 0; fil < parking[0].length; fil++) {
			totalPercentatgeFiles += percentatgePlacesLliuresFila(parking, fil);
		}

		double totalPercentatgeParkingLliure = totalPercentatgeFiles / parking.length;

		return totalPercentatgeParkingLliure;

	}

	public static int numFilaMesLliure(boolean[][] parking) {

		double porcentajeMaximo = 0;
		int filaMasLibre = 0;

		// Recorremos todas las filas
		for (int fil = 0; fil < parking.length; fil++) {

			// cogemos el porcentaje de la fila en la que estamos
			double porcentajeFila = percentatgePlacesLliuresFila(parking, fil);

			// buscamos al mas grande, y guardamos que fila es
			if (porcentajeFila > porcentajeMaximo) {
				porcentajeMaximo = porcentajeFila; // esto podría sobrar
				filaMasLibre = fil;
			}

		}

		return filaMasLibre;

	}

}
