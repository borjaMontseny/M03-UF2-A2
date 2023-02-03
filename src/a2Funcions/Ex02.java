package a2Funcions;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * L'avi Pep té un hort rectangular de N x M metres, dividit en parcel·les
		 * quadrades d'un metre quadrat, limítrof pel sud amb un riu.
		 * 
		 * De tota la vida, l'Avi ha plantat una sola classe d'hortalisses a cada
		 * parcel·la (de fet, tota la comarca ho fa així).
		 */

		// T → Tomàquets E → Enciams B → Bledes R → Raves

		/*
		 * Aquest estiu les bledes pujaran de preu, i que els tomàquets baixaran. Per
		 * això, l'Avi vol plantar una filera sencera de bledes, tot suprimint, si cal
		 * tomaqueres (però només tomaqueres). Però com les bledes necessiten molta
		 * aigua i la seva esquena es ressent de portar pesos, vol que la filera de
		 * bledes es trobi el més a prop possible del riu, que està situat just a sota
		 * de la darrera fila.
		 */

		/*
		 * Però com les bledes necessiten molta aigua i la seva esquena es ressent de
		 * portar pesos, vol que la filera de bledes es trobi el més a prop possible del
		 * riu, que està situat just a sota de la darrera fila.
		 */

		/*
		 * Fes una funció anomenada esPodenPlantarBledesFila que donada la matriu i un
		 * número de fila, retorni si es pot plantar tota la filera de bledes o no
		 */

		char[][] matriu = { { 'T', 'T', 'E', 'B' }, { 'T', '0', 'E', 'B' }, { '0', '0', '0', '0' },
				{ 'E', 'T', 'E', 'T' } };

		System.out.println(esPodenPlantarBledesFila(matriu, 0));
		System.out.println(esPodenPlantarBledesFila(matriu, 1));
		System.out.println(esPodenPlantarBledesFila(matriu, 2));
		System.out.println(esPodenPlantarBledesFila(matriu, 3));

		System.out.println("Fila plantable más cercana: " + numFilaOnPodenPlantarBledesMatriu(matriu));

	}

	public static boolean esPodenPlantarBledesFila(char[][] matriu, int numFila) {

		// se recorre la fila y ++ a contador a cosas que no sean T o 0
		for (int col = 0; col < matriu[numFila].length; col++) {

			// si no es T o 0 ya directamente devolvemos false
			if (matriu[numFila][col] != 'T' && matriu[numFila][col] != '0') {
				return false;
			}

		}

		// si no ha pasado por el if, devolvemos true
		return true;

	}

	/*
	 * Fes una funció anomenada numFilaOnPodenPlantarBledesMatriu que donada la
	 * matriu, retorni el número de fila (més propera al riu) on es poden plantar
	 * bledes. Si no es poden plantar bledes en cap fila ha de retornar un -1.
	 */

	public static int numFilaOnPodenPlantarBledesMatriu(char[][] matriu) {

		// recorremos las filas al reves, empezando por el río
		for (int i = matriu.length - 1; i >= 0; i--) {

			// nomás encontrar una fila plantable, retornamos el i: el num fila
			if (esPodenPlantarBledesFila(matriu, i)) {
				return i;
			}
		}

		return -1;
	}

}
