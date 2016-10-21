import java.util.ArrayList;
import java.util.Calendar;

public class Persona {

	// VARIABLES
	private String nombre;
	private Fecha fechaNacimiento;
	private int dia, mes, anyo;

	// CONSTRUCTORES
	public Persona(String nombre, int dia, int mes, int anyo) {
		fechaNacimiento = new Fecha(dia, mes, anyo);
		this.nombre = nombre;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	// METODOS GET Y SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// OTROS METODOS
	public boolean esMayorDeEdad() {
		Calendar hoy = Calendar.getInstance();
		int anyoCorrecto = hoy.get(Calendar.YEAR);
		int mesActual = hoy.get(Calendar.MONTH) + 1;
		int diaActual = hoy.get(Calendar.DAY_OF_MONTH);
		if (anyoCorrecto - fechaNacimiento.getAnyo() > 18) {
			return true;
		} else if (anyoCorrecto - fechaNacimiento.getAnyo() == 18
				&& mesActual > fechaNacimiento.getMes()) {
			return true;
		} else if (anyoCorrecto - fechaNacimiento.getAnyo() == 18
				&& mesActual == fechaNacimiento.getMes()
				&& diaActual >= fechaNacimiento.getDia()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

	// METODO MAIN
	public static void main(String[] args) {
		Persona p1 = new Persona("Pepe", 25, 1, 2016);
		Persona p2 = new Persona("Jesus", 4, 8, 1985);
		System.out.println(p1.toString());
		System.out.println("�Es mayor de edad?=" + p1.esMayorDeEdad());
		System.out.println(p2.toString());
		System.out.println("�Es mayor de edad?=" + p2.esMayorDeEdad());

	}
}
