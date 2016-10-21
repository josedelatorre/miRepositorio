package superMercado;

import java.util.ArrayList;
import java.util.Iterator;

public class SuperMercado {
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();

		generarProductos(productos);
		String ticket = "************Cantidad***Precio***Total\n";
		double precioTotal = 0;
		Producto productoActual;

		Iterator<Producto> it = productos.iterator();

		for (int i = 0; it.hasNext(); i++) {
			productoActual = it.next();
			precioTotal += productoActual.precioFinal();
			ticket += "Producto" + (i + 1) + "\t"
					+ productoActual.getCantidad() + "\t"
					+ productoActual.getPrecio() + "\t"
					+ productoActual.precioFinal() + "\n";
		}

		ticket += "Precio final\t\t\t" + precioTotal;
		System.out.println(ticket);
	}

	public static void generarProductos(ArrayList<Producto> lista) {
		int numeroPersonas = generaNumeroAleatorio(1, 8);
		int cantidad;
		double precio;

		for (int i = 0; i < numeroPersonas; i++) {
			cantidad = generaNumeroAleatorio(1, 10);
			precio = generaNumeroRealAleatorio(0.05, 50);
			lista.add(new Producto(cantidad, precio));
		}
	}

	public static int generaNumeroAleatorio(int minimo, int maximo) {
		int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1))
				+ (maximo + 1));
		return num;
	}

	public static double generaNumeroRealAleatorio(double minimo, double maximo) {
		double num = Math.rint(Math.floor(Math.random()
				* (minimo - ((maximo * 100) + 1)) + ((maximo * 100) + 1))) / 100;
		return num;
	}
}
