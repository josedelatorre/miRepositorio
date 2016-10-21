package superMercado;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Producto {

	// VARIABLES
	private int cantidad;
	private double precio;

	// CONSTRUCTOR
	public Producto(int cantidad, double precio) {
		this.cantidad = cantidad;
		this.precio = precio;
	}

	// METODOS GET
	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	// OTROS METODOS
	public double precioFinal() {
		DecimalFormat df = new DecimalFormat("#,##");
		return Double.parseDouble(df.format(this.precio * this.cantidad));
	}
}
