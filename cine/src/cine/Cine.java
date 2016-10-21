package cine;

import java.util.ArrayList;
import java.util.Iterator;

public class Cine {
	public static void main(String[] args) {

		ArrayList<Persona> cola = new ArrayList<>();

		generarCola(cola);
		double recaudacion;
		double recaudacionTotal = 0;
		Persona espectadorActual;
		int edadActual;

		Iterator<Persona> it = cola.iterator();

		while (it.hasNext()) {
			espectadorActual = it.next();
			edadActual = espectadorActual.getEdad();

			if (edadActual >= 5 && edadActual <= 10) {
				recaudacion = 1;
			} else if (edadActual >= 11 && edadActual <= 17) {
				recaudacion = 2.5;
			} else {
				recaudacion = 3.5;
			}

			recaudacionTotal += recaudacion;
			System.out.println("Una persona de " + edadActual
					+ " años se le ha cobrado " + recaudacion + " euros");

		}
		System.out.println("La recaudación es de " + recaudacionTotal
				+ " euros");
	}

	public static void generarCola(ArrayList<Persona> cola) {
		int numeroPersonas = generaNumeroAleatorio(1, 50);

		for (int i = 0; i < numeroPersonas; i++) {
			cola.add(new Persona(generaNumeroAleatorio(5, 60)));
		}
	}

	public static int generaNumeroAleatorio(int minimo, int maximo) {
		int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1))
				+ (maximo + 1));
		return num;
	}
}
